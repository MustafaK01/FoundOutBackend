package com.mustafak01.foundoutbackendrestaurants.controller;


import com.mustafak01.foundoutbackendrestaurants.model.LocationModel;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class LocationController {

    LocationService locationService;

    @GetMapping("/getAddress")
    public ResponseEntity<LocationModel> getAddressByRestaurantName(String name){
        return this.locationService.getByRestaurantName(name);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<LocationModel>> getAllAddresses(){
        return this.locationService.getAll();
    }
}
