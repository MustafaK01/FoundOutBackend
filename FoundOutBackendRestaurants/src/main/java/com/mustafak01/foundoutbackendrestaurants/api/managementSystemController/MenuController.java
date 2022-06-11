package com.mustafak01.foundoutbackendrestaurants.api.managementSystemController;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuModelDtoWithUserIdCategoryNameAndMenuName;
import com.mustafak01.foundoutbackendrestaurants.model.requests.AddMenuRequest;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
@AllArgsConstructor
public class MenuController {
    MenuService menuService;

    @GetMapping("/getAll")
    public ResponseEntity<List<MenuModel>> getAll(){
        return this.menuService.getAll();
    }

    @PostMapping("/addMenu")
    public ResponseEntity<String> addMenu(@RequestBody AddMenuRequest addMenuRequest){
        return this.menuService.addMenu(addMenuRequest);
    }
    @DeleteMapping("/deleteMenu/{id}")
    public ResponseEntity<Void> deleteMenuByMenuId(@PathVariable("id") Long id){
        return this.menuService.deleteByMenuId(id);
    }

    //Without Dto
/*    @GetMapping("/getMenusByUserId")
    public ResponseEntity<List<MenuModel>> getMenusByUserId(Long id){
        //System.out.println(this.menuService.getMenuByUserEmail(email).getBody());
        return this.menuService.getMenusByUserId(id);
    }*/

    @GetMapping("/getMenusByUserId")
    public ResponseEntity<List<MenuModelDtoWithUserIdCategoryNameAndMenuName>> getMenusByUserIdWithDto(Long id){
        //System.out.println(this.menuService.getMenuByUserEmail(email).getBody());
        return this.menuService.getMenusByUserId(id);
    }
    @GetMapping("/getMenuNameByMenuId")
    public ResponseEntity<MenuModelDtoWithUserIdCategoryNameAndMenuName> getMenuNameByMenuId(Long id){
        return this.menuService.getMenuNameByMenuId(id);
    }
}
