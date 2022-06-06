package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddServicingToMenuRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuServicingService {
    ResponseEntity<List<MenuServicingModel>> getAll();
    ResponseEntity<String> addServicing(AddServicingToMenuRequest addServicingToMenuRequest);
    ResponseEntity<List<MenuServicingDto>> getMenuServicingsWithDto(Long id);
    ResponseEntity<Long> findTheLastRecord();
}
