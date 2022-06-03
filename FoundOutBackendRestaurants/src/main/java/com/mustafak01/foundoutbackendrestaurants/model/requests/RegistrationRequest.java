package com.mustafak01.foundoutbackendrestaurants.model.requests;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String email;
    private final String phoneNumber;
    private final String password;
    private final String address;
    private final String title;
}
