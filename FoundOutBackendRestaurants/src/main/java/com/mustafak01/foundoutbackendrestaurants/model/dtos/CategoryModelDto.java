package com.mustafak01.foundoutbackendrestaurants.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModelDto {
    public int categoryId;
    public String categoryName;
}
