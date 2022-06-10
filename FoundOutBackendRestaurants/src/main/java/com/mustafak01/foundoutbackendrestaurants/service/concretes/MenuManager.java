package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdCategoryNameAndMenuName;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddMenuRequest;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingCategoryRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuManager implements MenuService {

    MenuRepository menuRepository;
    UserRepository userRepository;
    MenuServicingCategoryRepository menuServicingCategoryRepository;
    @Override
    public ResponseEntity<List<MenuModel>> getAll() {
        return ResponseEntity.ok().body(this.menuRepository.findAll());
    }

    @Override
    public ResponseEntity<String> addMenu(AddMenuRequest addMenuRequest) {
        MenuModel menuModel = new MenuModel();
        UserModel userModel = this.userRepository.findByEmail(addMenuRequest.getUserEmail());//it will get the user with userıd(userıd will take from the localstorage)
        MenuServicingCategoryModel menuServicingCategoryModel=this.menuServicingCategoryRepository.//it will get the category with category name
                findMenuServicingCategoryModelByCategoryName(addMenuRequest.getCategoryName());
        menuModel.setId(null);
        menuModel.setExplanation(addMenuRequest.getExplanation());
        menuModel.setMenuName(addMenuRequest.getMenuName());
        menuModel.setMenuServicingCategoryModel(menuServicingCategoryModel);
        menuModel.setUserModel(userModel);
        this.menuRepository.save(menuModel);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }




    @Override
    public ResponseEntity<MenuModelDtoWithUserIdCategoryNameAndMenuName> getMenuNameByMenuId(Long id) {
        return ResponseEntity.ok().body(this.menuRepository.getMenuNameByMenuId(id));
    }
    @Override
    public ResponseEntity<List<MenuModelDtoWithUserIdCategoryNameAndMenuName>> getMenusByUserId(Long id) {
        return ResponseEntity.ok().body(this.menuRepository.getMenuModelAndCategoryNameWithUserId(id));
    }

    @Override
    public ResponseEntity<Void> deleteByMenuId(Long id) {
        MenuModel menuModel = this.menuRepository.getMenuModelById(id);
        System.out.println("Menu Model "+menuModel.getMenuName() + " " + menuModel.getId());
        this.menuRepository.deleteById(menuModel.getId());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
