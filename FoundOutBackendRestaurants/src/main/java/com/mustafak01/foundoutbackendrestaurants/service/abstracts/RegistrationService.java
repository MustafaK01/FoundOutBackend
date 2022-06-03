package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.requests.RegistrationRequest;
import com.mustafak01.foundoutbackendrestaurants.model.response.AuthResponseRegister;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {
    boolean checkUserIfExists(String username,String email);
    ResponseEntity<AuthResponseRegister> saveUser(RegistrationRequest registrationRequest);
}
