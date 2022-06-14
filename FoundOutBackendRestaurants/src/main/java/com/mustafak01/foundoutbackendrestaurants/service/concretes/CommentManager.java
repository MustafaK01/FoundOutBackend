package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.CommentModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.CommentDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.CommentRequest;
import com.mustafak01.foundoutbackendrestaurants.model.response.GeneralResponse;
import com.mustafak01.foundoutbackendrestaurants.repository.CommentRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CommentManager implements CommentService {

    CommentRepository commentRepository;
    UserRepository userRepository;

    @Override
    public ResponseEntity<GeneralResponse> save(CommentRequest commentRequest) {
        try {
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
            return ResponseEntity.ok().body(new GeneralResponse("Başarılı",true));
        }catch (Exception e){
            System.out.println(commentRequest.getUserName()+" Tarafından Boş Yorum Girildi");
            return ResponseEntity.ok().body(new GeneralResponse("Gönderilemedi",false));
        }

    }

    @Override
    public ResponseEntity<List<CommentDto>> getCommentModelByRestaurantName(String restaurantName) {
        return ResponseEntity.ok().body(this.commentRepository.getCommentModelByRestaurantName(restaurantName));
    }

    @Override
    public ResponseEntity<List<CommentDto>> getCommentModelByRestaurantNameAndUserName(String restaurantName, String userName) {
        return ResponseEntity.ok().body(this.commentRepository.getCommentModelByRestaurantNameAndUserName(restaurantName,userName));
    }


    @Override
    public ResponseEntity<List<CommentDto>> getCommentModelByUserName(String userName) {
        return ResponseEntity.ok().body(this.commentRepository.getCommentModelByUserName(userName));
    }

    @Override
    public ResponseEntity<GeneralResponse> deleteCommentByUserNameAndCommentId(Long id, String userName) {
        CommentModel commentModel = this.commentRepository.getCommentModelByIdAndUserName(id,userName);
        if(commentModel!=null){
            this.commentRepository.delete(commentModel);
            return ResponseEntity.ok().body(new GeneralResponse("Successfully Deleted",true));
        }
        return ResponseEntity.ok().body(new GeneralResponse("Error",false));
    }

//    @Override
//    public ResponseEntity<List<CommentDto>> deleteCommentByRestaurantNameAndUserName(String restaurantName, String userName) {
//        CommentModel
//    }

    @Override
    public ResponseEntity<List<CommentDto>> getCommentsByRestaurantTitleAndId(Long id, String restaurantName) {
        return ResponseEntity.ok().body(this.commentRepository.getCommentsByRestaurantTitleAndId(id,restaurantName));
    }


}
