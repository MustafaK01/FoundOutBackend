package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.IdentityModel;

public interface IdentityService {

    void save(String name,String lastName,String identityNumber);
    IdentityModel getByIdentityNumber(String identityNumber);

}
