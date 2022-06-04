package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdAndCategoryName;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddMenuRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuService {
    ResponseEntity<List<MenuModel>> getAll();
    ResponseEntity<String> addCategory(AddMenuRequest addMenuRequest);

    //ResponseEntity<List<MenuModel>> getMenusByUserId(Long id);
    ResponseEntity<List<MenuModelDtoWithUserIdAndCategoryName>> getMenusByUserId(Long id);

}