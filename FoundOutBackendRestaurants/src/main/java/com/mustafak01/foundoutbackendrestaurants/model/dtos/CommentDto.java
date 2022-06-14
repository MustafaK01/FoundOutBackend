package com.mustafak01.foundoutbackendrestaurants.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long commentId;
    private String comment;
    private String userName;
    private String createdDate;
    private String restaurantName;
    private String restaurantAddress;

}
