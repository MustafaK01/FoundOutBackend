package com.mustafak01.foundoutbackendrestaurants.api.foundOutController;


import com.mustafak01.foundoutbackendrestaurants.model.dtos.LocationDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuDtoWithCategoryName;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingImageDtoForMobile;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto;
import com.mustafak01.foundoutbackendrestaurants.model.requests.CommentRequest;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/foundOut")
@AllArgsConstructor
public class FoundOutController {

    MenuService menuService;
    LocationService locationService;
    MenuServicingImageService menuServicingImageService;
    UserService userService;
    CommentService commentService;

    @GetMapping("/menus/get/menus/byTitle/{title}")
    public ResponseEntity<List<MenuDtoWithCategoryName>> getAddressByRestaurantName(@PathVariable("title") String title){
        return this.menuService.getMenusInfoByTitle(title);
    }

    @GetMapping("/location/getByRestaurantNameWithDto")
    public ResponseEntity<LocationDto> getByRestaurantNameWithDto(String restaurantName){
        return this.locationService.getByRestaurantNameWithDto(restaurantName);
    }

    @GetMapping("/location/getAllWithDto")
    public ResponseEntity<List<LocationDto>> getAllWithDto(){
        return this.locationService.getAllWithDto();
    }

    @GetMapping(path = {"/restaurant/get/info/dto"})
    public ResponseEntity<RestaurantsDto> getByDto(String restaurantName) throws IOException {
        return this.userService.getByRestaurantName(restaurantName);
    }


    @GetMapping(path = {"/menuServicings/get/image/info/{restaurantName}"})
    public ResponseEntity<List<MenuServicingImageDtoForMobile>> getImageDetailsForMobileWithDtoByTitle(@PathVariable("restaurantName") String restaurantName) throws IOException {
        return this.menuServicingImageService.getMenuServicingImageByTitle(restaurantName);
    }

    @GetMapping(path = {"/menuServicings/get/image/info/byMenuName/{restaurantName}"})
    public ResponseEntity<List<MenuServicingImageDtoForMobile>> getImageDetailsWithDtoByRestaurantNameAndMenuName(@PathVariable("restaurantName") String restaurantName,String menuName) throws IOException {
        return this.menuServicingImageService.getMenuServicingImageByTitleAndMenuName(restaurantName,menuName);
    }

    @GetMapping(path = {"/menuServicings/get/image/info/byMenuId/{restaurantName}"})
    public ResponseEntity<List<MenuServicingImageDtoForMobile>> getImageDetailsWithDtoByRestaurantNameAndMenuId(@PathVariable("restaurantName") String restaurantName,Long menuId) throws IOException {
        return this.menuServicingImageService.getMenuServicingImageByTitleAndMenuId(restaurantName,menuId);
    }

    @PostMapping("/comment/submit")
    public ResponseEntity<Void> submitComment(@RequestBody CommentRequest commentRequest ){
        return this.commentService.save(commentRequest);
    }

}
