package com.mustafak01.foundoutbackendrestaurants.controller;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuService;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuServicingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menus/servicings")
@AllArgsConstructor
public class MenuServicingController {

    MenuServicingService menuServicingService;

    @GetMapping("/getAll")
    public ResponseEntity<List<MenuServicingModel>> getAll(){
        return this.menuServicingService.getAll();
    }
}
