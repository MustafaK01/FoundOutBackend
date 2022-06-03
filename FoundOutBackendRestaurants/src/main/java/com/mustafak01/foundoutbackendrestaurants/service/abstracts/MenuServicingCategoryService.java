package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuServicingCategoryService {
    ResponseEntity<List<MenuServicingCategoryModel>> getAll();
    ResponseEntity<String> addCategory(MenuServicingCategoryModel categoryModel);
}
