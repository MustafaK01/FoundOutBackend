package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.mernis.KPSPublicSoap;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModelImage;
import com.mustafak01.foundoutbackendrestaurants.model.requests.RegistrationRequest;
import com.mustafak01.foundoutbackendrestaurants.model.response.AuthResponseRegister;
import com.mustafak01.foundoutbackendrestaurants.repository.UserImageRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.IdentityService;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.LocationService;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.RegistrationService;
import com.mustafak01.foundoutbackendrestaurants.utils.ImageUtility;
import com.mustafak01.foundoutbackendrestaurants.utils.RegistrationUtilityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationManager implements RegistrationService {

    private IdentityService identityService;
    private LocationService locationService;
    private RegistrationUtilityService registrationUtilityService;

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private UserImageRepository userImageRepository;


    @Override
    public Boolean checkUserIfExists(String identityNumber, String email,String title) {
        if (userRepository.findByEmail(email) != null || identityService.getByIdentityNumber(identityNumber) != null
        || userRepository.findByTitle(title)!=null) {
            return false;//
        }
        return true;
    }

    //This code will be shortened
    public ResponseEntity<AuthResponseRegister> saveUser(RegistrationRequest registrationRequest) throws Exception {
        AuthResponseRegister authResponse = new AuthResponseRegister();
        MultipartFile multipartFile = new MockMultipartFile("defaultImage.jpg", new FileInputStream(new File("src/main/java/com/mustafak01/foundoutbackendrestaurants/defaultImage.jpg")));

        if (!(checkUserIfExists(registrationRequest.getRestaurantOwnerIdentityNumber()
                , registrationRequest.getEmail(), registrationRequest.getTitle()))) {
            authResponse.setMessage("Error");
            authResponse.setSuccess(false);
            return new ResponseEntity<>(authResponse, HttpStatus.UNPROCESSABLE_ENTITY);//422
        }

        if ((!registrationUtilityService.isTrueEmail(registrationRequest.getEmail())
                || !registrationUtilityService.isTruePhoneNumber(registrationRequest.getPhoneNumber()))) {
            authResponse.setMessage("Error");
            authResponse.setSuccess(false);
            return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);
        }
        ;//400

//            KPSPublicSoap kpsPublicSoap = new KPSPublicSoap();
//            Boolean isExists = kpsPublicSoap.TCKimlikNoDogrula(
//                    Long.parseLong(registrationRequest.getRestaurantOwnerIdentityNumber())
//                    ,registrationRequest.getRestaurantOwnerName().toUpperCase()
//                    ,registrationRequest.getRestaurantOwnerLastName().toUpperCase()
//                    ,registrationRequest.getBirthYear());
//
//            if (!isExists) {
//                authResponse.setMessage("Böyle Bir Kişi Bulunmuyor");
//                authResponse.setSuccess(false);
//                return new ResponseEntity<>(authResponse, HttpStatus.NOT_ACCEPTABLE);//406
//            }
        if ((checkUserIfExists(registrationRequest.getRestaurantOwnerIdentityNumber()
                , registrationRequest.getEmail(), registrationRequest.getTitle()))) {
            Optional<UserModel> user = Optional.of(new UserModel());
            user.get().setEmail(registrationRequest.getEmail());
            user.get().setTitle(registrationRequest.getTitle());
            user.get().setRestaurantOwnerIdentityNumber(registrationRequest.getRestaurantOwnerIdentityNumber());
            user.get().setPhoneNumber(registrationRequest.getPhoneNumber());
            this.locationService.save(registrationRequest.getLongitude()
                    , registrationRequest.getLatitude()
                    , registrationRequest.getAddress()
                    , registrationRequest.getTitle());
            this.userImageRepository.save(UserModelImage.builder()
                    .userModel(user.get())
                    .name(multipartFile.getName())
                    .type(multipartFile.getContentType())
                    .image(ImageUtility.compressImage(multipartFile.getBytes())).build());
            this.identityService.save(registrationRequest.getRestaurantOwnerName().toUpperCase(),
                    registrationRequest.getRestaurantOwnerLastName().toUpperCase(),
                    registrationRequest.getRestaurantOwnerIdentityNumber());
            user.get().setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            authResponse.setSuccess(true);
            authResponse.setMessage("User Registered");
            userRepository.save(user.get());
            return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(authResponse, HttpStatus.UNPROCESSABLE_ENTITY);//422
    }
}
