package com.mustafak01.foundoutbackendrestaurants.model.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDtoWithCategoryName {

    private Long menuId;
    private String menuName;
    private String explanation;
    private Integer servicings;
    private String categoryName;

}
