package com.mustafak01.foundoutbackendrestaurants.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IdentityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "identity_id")
    private Long id;

    @Column(name = "restaurant_name_owner")
    private String name;

    @Column(name = "restaurant_lastname_owner")
    private String lastName;

    @Column(name = "restaurant_identitynumber_owner")
    private String identityNumber;
}
