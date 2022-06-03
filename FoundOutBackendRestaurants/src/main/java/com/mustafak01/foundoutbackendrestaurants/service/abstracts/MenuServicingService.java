package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuServicingService {
    ResponseEntity<List<MenuServicingModel>> getAll();
}
