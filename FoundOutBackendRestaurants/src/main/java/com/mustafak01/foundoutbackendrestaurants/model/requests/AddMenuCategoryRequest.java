package com.mustafak01.foundoutbackendrestaurants.model.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddMenuCategoryRequest {
    private final int id;
    private final String categoryName;
}
