package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuServicingCategoryRepository extends JpaRepository<MenuServicingCategoryModel,Integer> {
    public MenuServicingCategoryModel findMenuServicingCategoryModelByCategoryName(String categoryName);
}
