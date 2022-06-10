package com.mustafak01.foundoutbackendrestaurants.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantsDto {
    private String name;
    private String category;
    private String price;
    private byte[] image;
}
