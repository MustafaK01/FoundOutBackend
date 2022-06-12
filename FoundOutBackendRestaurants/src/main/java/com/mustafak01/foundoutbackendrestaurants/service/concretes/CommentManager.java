package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.CommentModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.CommentRequest;
import com.mustafak01.foundoutbackendrestaurants.repository.CommentRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {

    CommentRepository commentRepository;
    UserRepository userRepository;

    @Override
    public ResponseEntity<Void> save(CommentRequest commentRequest) {
        CommentModel commentModel = new CommentModel();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        UserModel userModel = this.userRepository.findByTitle(commentRequest.getRestaurantName());
//        System.out.println(userModel.getId());
        commentModel.setId(null);
        commentModel.setComment(commentRequest.getComment());
        commentModel.setCreatedDate(dateTime.format(dateTimeFormatter));
        commentModel.setUserModel(userModel);
        commentModel.setUserName(commentRequest.getUserName());
        this.commentRepository.save(commentModel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<CommentDto>> getCommentModelByRestaurantName(String restaurantName) {
        return ResponseEntity.ok().body(this.commentRepository.getCommentModelByRestaurantName(restaurantName));
    }

    @Override
    public ResponseEntity<List<CommentDto>> getCommentsByRestaurantTitleAndId(Long id, String restaurantName) {
        return ResponseEntity.ok().body(this.commentRepository.getCommentsByRestaurantTitleAndId(id,restaurantName));
    }


}
