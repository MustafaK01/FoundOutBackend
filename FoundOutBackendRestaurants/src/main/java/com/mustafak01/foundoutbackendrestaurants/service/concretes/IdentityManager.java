package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.IdentityModel;
import com.mustafak01.foundoutbackendrestaurants.repository.IdentityRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.IdentityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IdentityManager implements IdentityService {

    IdentityRepository identityRepository;

    @Override
    public void save(String name,String lastName,String identityNumber) {
        IdentityModel identityModel = new IdentityModel();
        identityModel.setName(name);
        identityModel.setLastName(lastName);
        identityModel.setIdentityNumber(identityNumber);
        this.identityRepository.save(identityModel);
    }

    @Override
    public IdentityModel getByIdentityNumber(String identityNumber){
        System.out.println(this.identityRepository.getByIdentityNumber(identityNumber));
        return this.identityRepository.getByIdentityNumber(identityNumber);
    }
}
