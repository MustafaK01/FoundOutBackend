package com.mustafak01.foundoutbackendrestaurants.service.abstracts;


import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<UserModel> getUserModelById(Long id);
    ResponseEntity<RestaurantsDto> getByRestaurantName(String name);
}
