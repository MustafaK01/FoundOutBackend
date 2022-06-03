package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.response.AuthResponseLogin;
import com.mustafak01.foundoutbackendrestaurants.model.requests.LoginRequest;

public interface LoginService {
    AuthResponseLogin login(LoginRequest loginRequest);
}
