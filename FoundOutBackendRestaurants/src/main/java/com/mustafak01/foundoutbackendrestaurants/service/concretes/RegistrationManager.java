package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.requests.RegistrationRequest;
import com.mustafak01.foundoutbackendrestaurants.model.response.AuthResponseRegister;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationManager implements RegistrationService {


    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public boolean checkUserIfExists(String username,String email) {
        if(userRepository.findByEmail(email)!=null){
            return false;//
        }
        return true;
    }

    public ResponseEntity<AuthResponseRegister> saveUser(RegistrationRequest registrationRequest){
        AuthResponseRegister authResponse = new AuthResponseRegister();
        if(!(checkUserIfExists(registrationRequest.getEmail()
                ,registrationRequest.getEmail()))){
            authResponse.setMessage("User Already Registered");
            authResponse.setSuccess(false);
            return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);
        }
        UserModel user = new UserModel();
        user.setEmail(registrationRequest.getEmail());
        user.setTitle(registrationRequest.getTitle());
        user.setId(null);
        user.setPhoneNumber(registrationRequest.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setAddress(registrationRequest.getAddress());
        authResponse.setMessage("User Registered");
        authResponse.setSuccess(true);
        userRepository.save(user);
        return new ResponseEntity<>(authResponse,HttpStatus.CREATED);
    }
}
