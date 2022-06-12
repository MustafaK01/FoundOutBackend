package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.CommentModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel,Long> {

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto(commentModel.comment,commentModel.userName,commentModel.createdDate)"
            +"FROM CommentModel commentModel WHERE commentModel.userModel.title=:restaurantName and commentModel.userModel.id=:id")
    List<CommentDto> getCommentsByRestaurantTitleAndId(@Param("id") Long id,@Param("restaurantName") String restaurantName);



    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto(commentModel.comment,commentModel.userName,commentModel.createdDate)"
            +"FROM CommentModel commentModel WHERE commentModel.userModel.title=:restaurantName")
    List<CommentDto> getCommentModelByRestaurantName(@Param("restaurantName")String restaurantName );



}
