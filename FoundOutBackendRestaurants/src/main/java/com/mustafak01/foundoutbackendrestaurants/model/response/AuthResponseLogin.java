package com.mustafak01.foundoutbackendrestaurants.model.response;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuthResponseLogin {
    String message;
    String token;
    Long userId;
    Long expirationDate;
    String email;
    String restaurantName;
    boolean isSuccess;
}
