package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdAndCategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel,Long> {
//    List<MenuModel> findByMenuServicingCategoryModel(MenuServicingCategoryModel menuServicingCategoryModel);
    List<MenuModel> getAllByUserModel_Id(Long Id);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdAndCategoryName(menuModel.id,categoryModel.categoryName,userModel.id)"
            + "FROM MenuModel menuModel inner join menuModel.menuServicingCategoryModel categoryModel inner join menuModel.userModel userModel"
            + "")
    List<MenuModelDtoWithUserIdAndCategoryName> getMenuModelAndCategoryNameWithUserId(Long userId);

}
