package com.mustafak01.foundoutbackendrestaurants.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuModelDtoWithUserIdAndCategoryName {
    private Long id;
    private String categoryName;
    private Long userId;

}
