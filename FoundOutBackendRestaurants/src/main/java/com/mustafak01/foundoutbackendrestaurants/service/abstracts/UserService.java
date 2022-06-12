package com.mustafak01.foundoutbackendrestaurants.service.abstracts;


import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {


    ResponseEntity<UserModel> getUserModelById(Long id);
    ResponseEntity<List<RestaurantsDto>> getByRestaurantName(String name);

    ResponseEntity<List<RestaurantsDto>> getAll();

    ResponseEntity<UserDto> getUserInfoByRestaurantNameAndUserId(String restaurantName,Long userId);
}
