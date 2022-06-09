package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.LocationModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface LocationService {

    void save(Double longitude, Double latitude,String address, String restaurantName);
    ResponseEntity<LocationModel> getByRestaurantName(String restaurantName);
}