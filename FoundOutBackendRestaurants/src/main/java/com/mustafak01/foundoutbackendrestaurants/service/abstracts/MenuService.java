package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuDtoWithCategoryName;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdCategoryNameAndMenuName;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddMenuRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuService {
    ResponseEntity<List<MenuModel>> getAll();
    ResponseEntity<String> addMenu(AddMenuRequest addMenuRequest);

    ResponseEntity<MenuModelDtoWithUserIdCategoryNameAndMenuName> getMenuNameByMenuId(Long id);

    //ResponseEntity<List<MenuModel>> getMenusByUserId(Long id);
    ResponseEntity<List<MenuModelDtoWithUserIdCategoryNameAndMenuName>> getMenusByUserId(Long id);

    ResponseEntity<Void>deleteByMenuId(Long id);

    ResponseEntity<List<MenuDtoWithCategoryName>> getMenusInfoByTitle(String title);

}
