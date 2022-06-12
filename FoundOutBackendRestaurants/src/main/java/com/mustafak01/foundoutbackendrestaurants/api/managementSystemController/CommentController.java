package com.mustafak01.foundoutbackendrestaurants.api.managementSystemController;

import com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {

    CommentService commentService;

    @GetMapping("/get/comments/{restaurantName}")
    public ResponseEntity<List<CommentDto>> getCommentsByRestaurantTitleAndId(@PathVariable("restaurantName") String restaurantName,Long id){
        return this.commentService.getCommentsByRestaurantTitleAndId(id,restaurantName);
    }

}
