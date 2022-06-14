package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.CommentRequest;
import com.mustafak01.foundoutbackendrestaurants.model.response.GeneralResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    ResponseEntity<GeneralResponse> save(CommentRequest commentRequest);

    ResponseEntity<List<CommentDto>> getCommentModelByRestaurantName(String restaurantName);

    ResponseEntity<List<CommentDto>> getCommentModelByRestaurantNameAndUserName(String restaurantName,String userName);

//    ResponseEntity<List<CommentDto>> deleteCommentByRestaurantNameAndUserName(String restaurantName,String userName);
    ResponseEntity<List<CommentDto>> getCommentModelByUserName(String userName);

    ResponseEntity<GeneralResponse> deleteCommentByUserNameAndCommentId(Long id,String userName);

    ResponseEntity<List<CommentDto>>getCommentsByRestaurantTitleAndId(Long id,String restaurantName);

}
