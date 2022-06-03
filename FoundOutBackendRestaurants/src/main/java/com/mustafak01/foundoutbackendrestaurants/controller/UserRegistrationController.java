package com.mustafak01.foundoutbackendrestaurants.controller;

import com.mustafak01.foundoutbackendrestaurants.model.response.AuthResponseLogin;
import com.mustafak01.foundoutbackendrestaurants.model.requests.LoginRequest;
import com.mustafak01.foundoutbackendrestaurants.model.requests.RegistrationRequest;
import com.mustafak01.foundoutbackendrestaurants.model.response.AuthResponseRegister;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.LoginService;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class UserRegistrationController {

    private final RegistrationService registrationService;
    private final LoginService loginService;


    @PostMapping("/register")
    public ResponseEntity<AuthResponseRegister> register(@RequestBody RegistrationRequest registrationRequest){
        log.info(String.format("Registered %s",registrationRequest));
        return registrationService.saveUser(registrationRequest);
    }
    @PostMapping("/login")
    public AuthResponseLogin login(@RequestBody LoginRequest loginRequest){
        log.info(String.format("%s",loginRequest));
        return loginService.login(loginRequest);
    }
}
