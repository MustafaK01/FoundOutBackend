package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.CommentModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.requests.CommentRequest;
import com.mustafak01.foundoutbackendrestaurants.repository.CommentRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {

    CommentRepository commentRepository;
    UserRepository userRepository;

    @Override
    public ResponseEntity<Void> save(CommentRequest commentRequest) {
        CommentModel commentModel = new CommentModel();
        UserModel userModel = this.userRepository.findByTitle(commentRequest.getTitle());
        System.out.println(userModel.getId());
        commentModel.setId(null);
        commentModel.setComment(commentRequest.getComment());
        commentModel.setUserModel(userModel);
        commentModel.setUserName(commentRequest.getUserName());
        this.commentRepository.save(commentModel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
