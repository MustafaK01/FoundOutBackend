package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.CategoryModelDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuServicingCategoryService {
    ResponseEntity<List<CategoryModelDto>> getAll();
    ResponseEntity<String> addCategory(MenuServicingCategoryModel categoryModel);
}
