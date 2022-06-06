package com.mustafak01.foundoutbackendrestaurants.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuServicingDto {

    private Long servicingId;
    private String servicingName;
    private String servicingPrice;
    private Long menuId;


}
