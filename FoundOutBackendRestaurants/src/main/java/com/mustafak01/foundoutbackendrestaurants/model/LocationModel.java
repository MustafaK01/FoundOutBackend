package com.mustafak01.foundoutbackendrestaurants.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LocationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "location_longitude")
    private Double longitude;

    @Column(name = "location_latitude",unique = true)
    private Double latitude;

    @Column(name = "location_address",unique = true)
    private String address;

    @Column(name="restaurant_name",unique = true)
    private String restaurantName;


}
