package com.mustafak01.foundoutbackendrestaurants.model.updateRequests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UpdateServicingRequest {

     private final String servicingName;//The name will not change. I added it to avoid errors.
     private final String servicingPrice;

}
