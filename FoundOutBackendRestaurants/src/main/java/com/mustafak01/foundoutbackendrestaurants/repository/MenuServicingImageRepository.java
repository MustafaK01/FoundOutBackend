package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingImage;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdCategoryNameAndMenuName;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingImageDtoForMobile;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface MenuServicingImageRepository extends JpaRepository<MenuServicingImage,Long> {
    Optional<MenuServicingImage> findByName(String name);
    Optional<MenuServicingImage> findByMenuServicingModel_Id(Long id);

    @Query("SELECT m FROM MenuServicingImage m WHERE m.menuServicingModel.name = :name")
    MenuServicingImage findByMenuServicingModel_Name(@Param("name")String name);


    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto(menuServicingModel.id,menuServicingImage.servicingImageId,menuServicingModel.name,menuServicingModel.price,menuModel.id,menuServicingImage.image)"
            + "FROM MenuServicingImage menuServicingImage join menuServicingImage.menuServicingModel menuServicingModel join menuServicingImage.menuServicingModel.menuModel menuModel where menuServicingImage.menuServicingModel.id=:id")
//    List<MenuServicingWithImageDto> getMenuServicingImageByMenuServicingId(@Param("id")Long id);
    MenuServicingWithImageDto getMenuServicingImageByMenuServicingId(@Param("id")Long id);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto(menuServicingModel.id,menuServicingImage.servicingImageId,menuServicingModel.name,menuServicingModel.price,menuModel.id,menuServicingImage.image)"
            + "FROM MenuServicingImage menuServicingImage join menuServicingImage.menuServicingModel menuServicingModel join menuServicingImage.menuServicingModel.menuModel menuModel where menuServicingImage.servicingImageId=:id")
    MenuServicingWithImageDto getByImageId(@Param("id") Long id);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto(menuServicingModel.id,menuServicingImage.servicingImageId,menuServicingModel.name,menuServicingModel.price,menuModel.id,menuServicingImage.image)"
            + "FROM MenuServicingImage menuServicingImage join menuServicingImage.menuServicingModel menuServicingModel join menuServicingImage.menuServicingModel.menuModel menuModel where menuModel.id=:id")
    List<MenuServicingWithImageDto> getMenuServicingImageByMenuServicingModel_MenuModel_Id(@Param("id")Long id);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingImageDtoForMobile(menuServicingModel.name,menuServicingModel.price,menuServicingModel.explanation,menuModel.menuName,menuServicingImage.image)"
            + "FROM MenuServicingImage menuServicingImage join menuServicingImage.menuServicingModel menuServicingModel join menuServicingImage.menuServicingModel.menuModel menuModel where menuModel.userModel.id=:id")
    List<MenuServicingImageDtoForMobile> getMenuServicingImageByUserIdForMobile(@Param("id")Long id);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingImageDtoForMobile(menuServicingModel.name,menuServicingModel.price,menuServicingModel.explanation,menuModel.menuName,menuServicingImage.image)"
            + "FROM MenuServicingImage menuServicingImage join menuServicingImage.menuServicingModel menuServicingModel join menuServicingImage.menuServicingModel.menuModel menuModel where menuModel.userModel.id=:id and menuModel.menuName=:menuName")
    List<MenuServicingImageDtoForMobile> getMenuServicingImageByUserIdAndMenuName(@Param("id")Long id,@Param("menuName") String menuName);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingImageDtoForMobile(menuServicingModel.name,menuServicingModel.price,menuServicingModel.explanation,menuModel.menuName,menuServicingImage.image)"
            + "FROM MenuServicingImage menuServicingImage join menuServicingImage.menuServicingModel menuServicingModel join menuServicingImage.menuServicingModel.menuModel menuModel where menuModel.userModel.id=:id and menuModel.id=:menuId")
    List<MenuServicingImageDtoForMobile> getMenuServicingImageByUserIdAndMenuId(@Param("id")Long id,@Param("menuId") Long menuId);
}
