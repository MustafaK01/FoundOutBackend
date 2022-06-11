package com.mustafak01.foundoutbackendrestaurants.model.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private Double longitude;
    private Double latitude;
    private String address;
    private String restaurantName;
}
