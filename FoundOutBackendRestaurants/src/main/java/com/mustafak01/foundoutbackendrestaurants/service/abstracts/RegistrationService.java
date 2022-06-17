package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.requests.RegistrationRequest;
import com.mustafak01.foundoutbackendrestaurants.model.response.AuthResponseRegister;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {
    Boolean checkUserIfExists(String username,String email,String title);
    ResponseEntity<AuthResponseRegister> saveUser(RegistrationRequest registrationRequest) throws Exception;
}
