package com.mustafak01.foundoutbackendrestaurants.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String restaurantName;
    private String address;
    private byte[] image;

}
