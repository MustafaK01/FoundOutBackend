package com.mustafak01.foundoutbackendrestaurants.model.requests;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddMenuRequest {
    private Long id;
    private String menuName;
    private String categoryName;
    private String userEmail;
}
