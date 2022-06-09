package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.mernis.KPSPublicSoap;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.requests.RegistrationRequest;
import com.mustafak01.foundoutbackendrestaurants.model.response.AuthResponseRegister;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.IdentityService;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.LocationService;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.RegistrationService;
import com.mustafak01.foundoutbackendrestaurants.utils.RegistrationUtilityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationManager implements RegistrationService {

    private IdentityService identityService;
    private LocationService locationService;
    private RegistrationUtilityService registrationUtilityService;

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public Boolean checkUserIfExists(String identityNumber, String email) {
        if (userRepository.findByEmail(email) != null || identityService.getByIdentityNumber(identityNumber) != null) {
            return false;//
        }
        return true;
    }

    //This code will be shortened
    public ResponseEntity<AuthResponseRegister> saveUser(RegistrationRequest registrationRequest) throws Exception {
        AuthResponseRegister authResponse = new AuthResponseRegister();

        if (!(checkUserIfExists(registrationRequest.getRestaurantOwnerIdentityNumber()
                , registrationRequest.getEmail()))) {
            authResponse.setMessage("Error");
            authResponse.setSuccess(false);
            return new ResponseEntity<>(authResponse, HttpStatus.UNPROCESSABLE_ENTITY);//422
        }

        if ((!registrationUtilityService.isTrueEmail(registrationRequest.getEmail())
                || !registrationUtilityService.isTruePhoneNumber(registrationRequest.getPhoneNumber()))) {
            authResponse.setMessage("Error");
            authResponse.setSuccess(false);
            return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);
        };//400

            KPSPublicSoap kpsPublicSoap = new KPSPublicSoap();
            Boolean isExists = kpsPublicSoap.TCKimlikNoDogrula(
                    Long.parseLong(registrationRequest.getRestaurantOwnerIdentityNumber())
                    ,registrationRequest.getRestaurantOwnerName().toUpperCase()
                    ,registrationRequest.getRestaurantOwnerLastName().toUpperCase()
                    ,registrationRequest.getBirthYear());

            if (!isExists) {
                authResponse.setMessage("Böyle Bir Kişi Bulunmuyor");
                authResponse.setSuccess(false);
                return new ResponseEntity<>(authResponse, HttpStatus.NOT_ACCEPTABLE);//406
            }

            UserModel user = new UserModel();
            user.setEmail(registrationRequest.getEmail());
            user.setTitle(registrationRequest.getTitle());
            user.setRestaurantOwnerIdentityNumber(registrationRequest.getRestaurantOwnerIdentityNumber());
            user.setPhoneNumber(registrationRequest.getPhoneNumber());

            this.locationService.save(registrationRequest.getLongitude()
                    , registrationRequest.getLatitude()
                    , registrationRequest.getAddress()
                    , registrationRequest.getTitle());

            this.identityService.save(registrationRequest.getRestaurantOwnerName().toUpperCase(),
                    registrationRequest.getRestaurantOwnerLastName().toUpperCase(),
                    registrationRequest.getRestaurantOwnerIdentityNumber());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));

            authResponse.setSuccess(true);
            authResponse.setMessage("User Registered");
            userRepository.save(user);
            return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
        }
}





/*
    private RegistrationUtilityService registrationUtilityService;

        if((!registrationUtilityService.isTrueEmail(registrationRequest.getEmail())
                || !registrationUtilityService.isTruePhoneNumber(registrationRequest.getPhoneNumber()))){
                authResponse.setMessage("Error");
                authResponse.setSuccess(false);
                return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);//400
        }*/
