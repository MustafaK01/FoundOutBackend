package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuServicingService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuServicingManager implements MenuServicingService {

    MenuServicingRepository menuServicingRepository;

    @Override
    public ResponseEntity<List<MenuServicingModel>> getAll() {
        return ResponseEntity.ok().body(this.menuServicingRepository.findAll());
    }
}
