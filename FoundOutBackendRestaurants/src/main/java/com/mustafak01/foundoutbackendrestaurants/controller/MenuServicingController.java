package com.mustafak01.foundoutbackendrestaurants.controller;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddServicingToMenuRequest;
import com.mustafak01.foundoutbackendrestaurants.model.updateRequests.UpdateServicingRequest;
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
    @GetMapping("/getLastRecord/{id}")
    public ResponseEntity<Long> getTheLastRecord(@PathVariable Long id){
        return this.menuServicingService.findTheLastRecord(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateServicingByServicingId(@PathVariable Long id, @RequestBody UpdateServicingRequest updateServicingRequest){
        return this.menuServicingService.updateServicingByServicingId(id,updateServicingRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteServicingByServicingId(@PathVariable Long id){
        return this.menuServicingService.deleteServicingByServicingId(id);
    }


}
