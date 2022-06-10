package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.requests.CommentRequest;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    ResponseEntity<Void> save(CommentRequest commentRequest);
}
