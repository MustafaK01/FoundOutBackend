package com.mustafak01.foundoutbackendrestaurants.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_images")
public class UserModelImage {

    @Id
    @Column(name = "user_image_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userImageId;

    @Column(name = "user_image_name", unique = false)
    private String name;

    @Column(name = "user_image_type", unique = false)
    private String type;

    @Column(name = "user_image", unique = false, nullable = false, length = 100000)
    private byte[] image;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_restaurant_id")
    UserModel userModel;

}
