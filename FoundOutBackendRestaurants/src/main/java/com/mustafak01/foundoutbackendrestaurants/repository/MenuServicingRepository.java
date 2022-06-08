package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuServicingRepository extends JpaRepository<MenuServicingModel,Long> {

    MenuServicingModel findMenuServicingModelById(Long id);
    Optional<MenuServicingModel> findById(Long id);
    MenuServicingModel findTopByOrderByIdDesc();



    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto(menuServicingModel.id,menuServicingModel.name,menuServicingModel.price,menuModel.id)"
            + "FROM MenuServicingModel menuServicingModel join menuServicingModel.menuModel menuModel where menuServicingModel.menuModel.id=:id")
    List<MenuServicingDto> getMenuServicingByMenuId(@Param("id")Long id);
}
