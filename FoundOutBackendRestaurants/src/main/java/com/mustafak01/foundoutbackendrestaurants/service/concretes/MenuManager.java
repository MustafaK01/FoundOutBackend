package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingCategoryModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdAndCategoryName;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddMenuRequest;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingCategoryRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
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
    public ResponseEntity<String> addCategory(AddMenuRequest addMenuRequest) {
        MenuModel menuModel = new MenuModel();
        UserModel userModel = this.userRepository.findByEmail(addMenuRequest.getUserEmail());//it will get the user with userıd(userıd will take from the localstorage)
        MenuServicingCategoryModel menuServicingCategoryModel=this.menuServicingCategoryRepository.//it will get the category with category name
                findMenuServicingCategoryModelByCategoryName(addMenuRequest.getCategoryName());
        menuModel.setId(null);
        menuModel.setMenuName(addMenuRequest.getMenuName());
        menuModel.setMenuServicingCategoryModel(menuServicingCategoryModel);
        menuModel.setUserModel(userModel);
        this.menuRepository.save(menuModel);
        return ResponseEntity.ok().body("Added");
    }

/*    @Override
    public ResponseEntity<List<MenuModel>> getMenusByUserId(Long id) {
        return ResponseEntity.ok().body(this.menuRepository.getAllByUserModel_Id(id));
    }*/
    @Override
    public ResponseEntity<List<MenuModelDtoWithUserIdAndCategoryName>> getMenusByUserId(Long id) {
        return ResponseEntity.ok().body(this.menuRepository.getMenuModelAndCategoryNameWithUserId(id));
    }
}