package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.CommentRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    ResponseEntity<Void> save(CommentRequest commentRequest);

    ResponseEntity<List<CommentDto>> getCommentModelByRestaurantName(String restaurantName);

    ResponseEntity<List<CommentDto>>getCommentsByRestaurantTitleAndId(Long id,String restaurantName);

}
