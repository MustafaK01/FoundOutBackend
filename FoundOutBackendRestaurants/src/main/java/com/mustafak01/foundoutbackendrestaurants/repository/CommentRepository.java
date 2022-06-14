package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.CommentModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto;
import com.mustafak01.foundoutbackendrestaurants.model.response.GeneralResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel,Long> {

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto(commentModel.id,commentModel.comment,commentModel.userName,commentModel.createdDate,restaurant.title,location.address)"
            +"FROM CommentModel commentModel, LocationModel location join commentModel.userModel restaurant WHERE commentModel.userModel.title=:restaurantName and location.restaurantName=:restaurantName " +
            "and commentModel.userModel.id=:id " +
            "ORDER BY commentModel.createdDate desc")
    List<CommentDto> getCommentsByRestaurantTitleAndId(@Param("id") Long id,@Param("restaurantName") String restaurantName);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto(commentModel.id,commentModel.comment,commentModel.userName,commentModel.createdDate,restaurant.title,location.address)"
            +"FROM CommentModel commentModel, LocationModel location join commentModel.userModel restaurant WHERE commentModel.userModel.title=:restaurantName and location.restaurantName=:restaurantName " +
            "ORDER BY commentModel.createdDate desc")
    List<CommentDto> getCommentModelByRestaurantName(@Param("restaurantName")String restaurantName );

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto(commentModel.id,commentModel.comment,commentModel.userName,commentModel.createdDate,restaurant.title,location.address)"
            +"FROM CommentModel commentModel, LocationModel location join commentModel.userModel restaurant WHERE commentModel.userModel.title=:restaurantName and location.restaurantName=:restaurantName " +
            "and commentModel.userName=:userName ORDER BY commentModel.createdDate desc")
    List<CommentDto> getCommentModelByRestaurantNameAndUserName(@Param("restaurantName")String restaurantName,@Param("userName") String userName);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto(commentModel.id,commentModel.comment,commentModel.userName,commentModel.createdDate,restaurant.title,location.address)"
            +"FROM CommentModel commentModel, LocationModel location join commentModel.userModel restaurant WHERE commentModel.userName=:userName and location.restaurantName=restaurant.title " +
            " ORDER BY commentModel.createdDate desc")
    List<CommentDto> getCommentModelByUserName(@Param("userName") String userName);

    CommentModel getCommentModelByIdAndUserName(Long id,String userName);

    void deleteCommentModelByCommentAndIdAndUserName(String comment,Long id,String userName);

}
