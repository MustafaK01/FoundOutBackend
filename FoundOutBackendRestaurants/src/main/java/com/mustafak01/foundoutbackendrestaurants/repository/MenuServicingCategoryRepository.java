package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.CategoryModelDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuServicingCategoryRepository extends JpaRepository<MenuServicingCategoryModel,Integer> {


    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.CategoryModelDto(categoryModel.serviceId,categoryModel.categoryName)" +
            "FROM MenuServicingCategoryModel categoryModel")
    public List<CategoryModelDto> getAllCategories();
    public MenuServicingCategoryModel findMenuServicingCategoryModelByCategoryName(String categoryName);
}
