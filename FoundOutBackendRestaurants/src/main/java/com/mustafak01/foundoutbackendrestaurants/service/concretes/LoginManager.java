package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.response.AuthResponseLogin;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.requests.LoginRequest;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.security.TokenProviderJwt;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginManager implements LoginService {
    private AuthenticationManager authenticationManager;
    private TokenProviderJwt tokenProviderJwt;
    private UserRepository userRepository;
    public AuthResponseLogin login(LoginRequest loginRequest){
        UserModel userModel = userRepository.findByEmail(loginRequest.getEmail());
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = tokenProviderJwt.generateToken(authentication);
        Long expirationDate = tokenProviderJwt.expirationDate(jwtToken);
        AuthResponseLogin authResponse = new AuthResponseLogin();
        authResponse.setSuccess(true);
        authResponse.setToken(jwtToken);
        authResponse.setMessage("Succesfully Logged In");
        authResponse.setUserId(userModel.getId());
        authResponse.setEmail(userModel.getEmail());
        authResponse.setExpirationDate(expirationDate);
        return authResponse;
    }
}
