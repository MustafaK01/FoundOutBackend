package com.mustafak01.foundoutbackendrestaurants.model.requests;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CommentRequest {
    private String userName;
    private String comment;
    private String restaurantName;
}
