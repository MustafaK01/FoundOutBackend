package com.mustafak01.foundoutbackendrestaurants.controller;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.CategoryModelDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddMenuCategoryRequest;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingCategoryRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuServicingCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class MenuServicingCategoryController {
    MenuServicingCategoryService menuServicingCategoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryModelDto>> getAll(){
        //System.out.println(this.menuServicingCategoryService.getAll());
        return this.menuServicingCategoryService.getAll();
    }
    @PostMapping("/addCategory")
    public ResponseEntity<String> addMenuCategory(@RequestBody AddMenuCategoryRequest addMenuCategoryRequest){
        MenuServicingCategoryModel menuServicingCategoryModel = new MenuServicingCategoryModel();
        menuServicingCategoryModel.setServiceId(addMenuCategoryRequest.getId());
        menuServicingCategoryModel.setCategoryName(addMenuCategoryRequest.getCategoryName());
        return menuServicingCategoryService.addCategory(menuServicingCategoryModel);
    }

}
