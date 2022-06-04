package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdCategoryNameAndMenuName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel,Long> {
//    List<MenuModel> findByMenuServicingCategoryModel(MenuServicingCategoryModel menuServicingCategoryModel);
    List<MenuModel> getAllByUserModel_Id(Long Id);

    List<MenuModel> getMenuModelByMenuNameAndUserModel_Id(String menuName,Long userId);
    MenuModel getMenuModelByMenuName(String menuName);
    MenuModel getMenuModelByUserModel_Id(Long userId);
    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdCategoryNameAndMenuName(menuModel.id,categoryModel.categoryName,menuModel.menuName,userModel.id)"
            + "FROM MenuModel menuModel inner join menuModel.menuServicingCategoryModel categoryModel inner join menuModel.userModel userModel"
            + "")
    List<MenuModelDtoWithUserIdCategoryNameAndMenuName> getMenuModelAndCategoryNameWithUserId(Long userId);
}
