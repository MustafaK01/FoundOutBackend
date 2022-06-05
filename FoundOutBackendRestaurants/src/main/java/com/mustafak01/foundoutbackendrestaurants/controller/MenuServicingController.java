package com.mustafak01.foundoutbackendrestaurants.controller;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddServicingToMenuRequest;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuService;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuServicingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addServicing")
    public ResponseEntity<String> addServicing(@RequestBody AddServicingToMenuRequest addServicingToMenuRequest){
        return this.menuServicingService.addServicing(addServicingToMenuRequest);
    }
    @GetMapping("/getServicing")//id yanına başka parametreler de eklenecek
    public ResponseEntity<List<MenuServicingDto>> getServicing(Long id){
        return this.menuServicingService.getMenuServicingsWithDto(id);
   }
}
