package com.mustafak01.foundoutbackendrestaurants.controller;

import com.mustafak01.foundoutbackendrestaurants.model.requests.CommentRequest;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
@AllArgsConstructor
public class CommentController {

    CommentService commentService;

    @PostMapping("/submit")
    public ResponseEntity<Void> submitComment(@RequestBody CommentRequest commentRequest ){
        return this.commentService.save(commentRequest);
    }
}
