package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.LocationModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.LocationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<LocationModel,Long> {

//    @Query(value="INSERT INTO location_model (id, latitude,longitude,userId) VALUES (?1, ?2,?3,?4)", nativeQuery = true)
//    void insert(Long id,Double latitude, Double longitude,Long userId);
    LocationModel getByRestaurantName(String restaurantName);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.LocationDto(locationModel.longitude,locationModel.latitude" +
            ",locationModel.address,locationModel.restaurantName)"
            + "FROM LocationModel locationModel where locationModel.restaurantName=:restaurantName")
    LocationDto getByRestaurantNameWithDto(@Param("restaurantName") String restaurantName);

    @Query("SELECT new com.mustafak01.foundoutbackendrestaurants.model.dtos.LocationDto(locationModel.longitude,locationModel.latitude" +
            ",locationModel.address,locationModel.restaurantName)"
            + "FROM LocationModel locationModel")
    List<LocationDto> getByAllWithDto();
}
