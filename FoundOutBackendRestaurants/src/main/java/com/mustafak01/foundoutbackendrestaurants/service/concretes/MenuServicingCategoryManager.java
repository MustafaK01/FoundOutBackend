package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingCategoryRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuServicingCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuServicingCategoryManager implements MenuServicingCategoryService {

    MenuServicingCategoryRepository menuServicingCategoryRepository;
    @Override
    public ResponseEntity<List<MenuServicingCategoryModel>> getAll() {
        return ResponseEntity.ok().body(this.menuServicingCategoryRepository.findAll());
    }

    @Override
    public ResponseEntity<String> addCategory(MenuServicingCategoryModel categoryModel) {
        this.menuServicingCategoryRepository.save(categoryModel);
        return ResponseEntity.ok().body("Added");
    }
}
