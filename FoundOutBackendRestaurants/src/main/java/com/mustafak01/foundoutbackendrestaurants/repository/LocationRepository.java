package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<LocationModel,Long> {

//    @Query(value="INSERT INTO location_model (id, latitude,longitude,userId) VALUES (?1, ?2,?3,?4)", nativeQuery = true)
//    void insert(Long id,Double latitude, Double longitude,Long userId);

    LocationModel getByRestaurantName(String restaurantName);

}
