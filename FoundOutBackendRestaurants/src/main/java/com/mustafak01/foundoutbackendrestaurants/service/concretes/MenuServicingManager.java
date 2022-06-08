package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingImage;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddServicingToMenuRequest;
import com.mustafak01.foundoutbackendrestaurants.model.updateRequests.UpdateServicingRequest;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingImageRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuServicingService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuServicingManager implements MenuServicingService {

    MenuServicingRepository menuServicingRepository;
    MenuRepository menuRepository;

    MenuServicingImageRepository servicingImageRepository;

    @Override
    public ResponseEntity<List<MenuServicingModel>> getAll() {
        return ResponseEntity.ok().body(this.menuServicingRepository.findAll());
    }

    @Override
    public ResponseEntity<String> addServicing(AddServicingToMenuRequest addServicingToMenuRequest) {
        MenuServicingModel menuServicingModel = new MenuServicingModel();
        //List<MenuModel> menuModels = this.menuRepository.getMenuModelByMenuNameAndUserModel_Id(addServicingToMenuRequest.getMenuName(), addServicingToMenuRequest.getUserId());
        MenuModel menuModel = this.menuRepository.getMenuModelByMenuName(addServicingToMenuRequest.getMenuName());
//        MenuModel menuModel1 = this.menuRepository.getMenuModelByUserModel_Id(addServicingToMenuRequest.getUserId());
       // if(menuModel==menuModel1&&menuModel1!=null){
            menuServicingModel.setId(null);
            menuServicingModel.setName(addServicingToMenuRequest.getServicingName());
            menuServicingModel.setPrice(addServicingToMenuRequest.getServicingPrice());
            menuServicingModel.setMenuModel(menuModel);
            this.menuServicingRepository.save(menuServicingModel);
            return ResponseEntity.ok().body("Added");
       // }
       // return ResponseEntity.badRequest().body("Couldnt Added");
    }

    @Override
    public ResponseEntity<List<MenuServicingDto>> getMenuServicingsWithDto(Long id) {
        return ResponseEntity.ok().body(this.menuServicingRepository.getMenuServicingByMenuId(id));
    }

    @Override
    public ResponseEntity<Long> findTheLastRecord() {
        return ResponseEntity.ok().body(this.menuServicingRepository.findTopByOrderByIdDesc().getId());
    }

    @Override
    public ResponseEntity<Void> updateServicingByServicingId(Long id, UpdateServicingRequest updateServicingRequest) {
         MenuServicingModel menuServicingModel = this.menuServicingRepository.findMenuServicingModelById(id);
         menuServicingModel.setPrice(updateServicingRequest.getServicingPrice());
         menuServicingModel.setName(menuServicingModel.getName());
        this.menuServicingRepository.save(menuServicingModel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @Override
    public ResponseEntity<Void> deleteServicingByServicingId(Long id) {
        MenuServicingModel menuServicingModel = this.menuServicingRepository.getById(id);
        this.menuServicingRepository.delete(menuServicingModel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

