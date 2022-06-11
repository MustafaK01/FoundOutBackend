package com.mustafak01.foundoutbackendrestaurants.model.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuServicingImageDtoForMobile {


    //    private Long servicingId;
    //    private Long servicingImageId;
    private String servicingName;
    private String servicingPrice;
    private String explanation;
    private String menuName;
    private byte[] image;


}
