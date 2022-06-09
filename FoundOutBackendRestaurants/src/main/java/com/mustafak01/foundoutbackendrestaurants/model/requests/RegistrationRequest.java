package com.mustafak01.foundoutbackendrestaurants.model.requests;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private final String restaurantOwnerName;
    private final String restaurantOwnerLastName;
    private final String restaurantOwnerIdentityNumber;
    private Double longitude;
    private Double latitude;
    private String address;
    private final String email;
    private final String phoneNumber;
    private final String password;
    private final String title;
    private final Integer birthYear;

}
