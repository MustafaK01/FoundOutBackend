package com.mustafak01.foundoutbackendrestaurants.model.requests;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CommentRequest {
    private String userName;
    private String comment;
    private String title;
}
