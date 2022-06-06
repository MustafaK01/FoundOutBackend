package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingImage;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdCategoryNameAndMenuName;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
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

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto(menuServicingModel.id,menuServicingModel.name,menuServicingModel.price,menuModel.id,menuServicingImage.image)"
            + "FROM MenuServicingImage menuServicingImage join menuServicingImage.menuServicingModel menuServicingModel join menuServicingImage.menuServicingModel.menuModel menuModel where menuServicingImage.menuServicingModel.id=:id")
    List<MenuServicingWithImageDto> getMenuServicingImageByMenuServicingId(@Param("id")Long id);
}
