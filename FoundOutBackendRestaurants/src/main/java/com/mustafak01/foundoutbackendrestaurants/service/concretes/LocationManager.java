package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.LocationModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.repository.LocationRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationManager implements LocationService {



    LocationRepository locationRepository;

    @Override
    public void save(Double longitude, Double latitude,String address, String restaurantName) {
        LocationModel locationModel = new LocationModel();
        locationModel.setAddress(address);
        locationModel.setRestaurantName(restaurantName);
        locationModel.setLatitude(latitude);
        locationModel.setLongitude(longitude);
        this.locationRepository.save(locationModel);
    }

    @Override
    public ResponseEntity<LocationModel> getByRestaurantName(String restaurantName) {
        return ResponseEntity.ok().body(this.locationRepository.getByRestaurantName(restaurantName));
    }
    @Override
    public ResponseEntity<List<LocationModel>> getAll() {
        return ResponseEntity.ok().body(this.locationRepository.findAll());
    }
}
