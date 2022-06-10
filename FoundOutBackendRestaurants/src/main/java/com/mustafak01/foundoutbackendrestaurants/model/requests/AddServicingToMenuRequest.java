package com.mustafak01.foundoutbackendrestaurants.model.requests;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddServicingToMenuRequest {
    private final Long id;
    private final Long userId;
    private final String servicingName;
    private final String servicingPrice;
    private final String menuName;
    private final String explanation;
}
