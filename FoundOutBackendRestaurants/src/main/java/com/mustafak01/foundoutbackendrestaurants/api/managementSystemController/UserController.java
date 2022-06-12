package com.mustafak01.foundoutbackendrestaurants.api.managementSystemController;


import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.UserDto;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping(path = {"/get/info/{id}"})
    public ResponseEntity<UserModel> getUserInfo(@PathVariable("id") Long id) throws IOException {
        return this.userService.getUserModelById(id);
    }
/*   @GetMapping(path = {"/get/info/dto"})
    public ResponseEntity<RestaurantsDto> getByDto(String name) throws IOException {
        return this.userService.getByRestaurantName(name);
    }*/
    @GetMapping(path = {"/get/info/withImage/{restaurantName}"})
    public ResponseEntity<UserDto> getUserInfoByRestaurantNameAndUserId(@PathVariable("restaurantName") String restaurantName, Long userId) throws IOException {
        return this.userService.getUserInfoByRestaurantNameAndUserId(restaurantName,userId);
    }
}
