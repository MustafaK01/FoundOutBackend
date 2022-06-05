package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuServicingCategoryRepository extends JpaRepository<MenuServicingCategoryModel,Integer> {
    public MenuServicingCategoryModel findMenuServicingCategoryModelByCategoryName(String categoryName);
}
