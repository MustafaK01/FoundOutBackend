package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserModel,Long>{
    UserModel findByEmail(String email);

    UserModel findByTitle(String title);

    Optional<UserModel> findById(Long id);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto(userModel.title,menuModels.menuServicingCategoryModel.categoryName,menuServicing.price,image.image)"
            +"FROM UserModel userModel join userModel.menuModels menuModels join menuModels.menuServicingModels menuServicing join userModel.userModelImages image " +
            "WHERE userModel.id=:id ")
    List<RestaurantsDto> getAllByRestaurantIdWithDto(@Param("id") Long id);

    UserModel getUserModelById(Long id);


    @Query("select m from UserModel m where m.id =:id")
    UserModel getUserModelByUserId(@Param("id") Long userId);
}

