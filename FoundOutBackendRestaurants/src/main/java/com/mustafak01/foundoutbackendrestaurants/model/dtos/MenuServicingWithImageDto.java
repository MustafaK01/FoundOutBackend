package com.mustafak01.foundoutbackendrestaurants.model.dtos;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuServicingWithImageDto {

    private Long servicingId;
    private String servicingName;
    private String servicingPrice;
    private Long menuId;
    private byte[] image;


}
