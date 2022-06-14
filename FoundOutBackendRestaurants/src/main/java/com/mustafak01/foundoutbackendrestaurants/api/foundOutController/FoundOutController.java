package com.mustafak01.foundoutbackendrestaurants.api.foundOutController;


import com.mustafak01.foundoutbackendrestaurants.model.dtos.*;
import com.mustafak01.foundoutbackendrestaurants.model.requests.CommentRequest;
import com.mustafak01.foundoutbackendrestaurants.model.response.GeneralResponse;
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

    @GetMapping("/location/get/byRestaurantName")
    public ResponseEntity<LocationDto> getByRestaurantNameWithDto(String restaurantName){
        return this.locationService.getByRestaurantNameWithDto(restaurantName);
    }

    @GetMapping("/location/get/all")
    public ResponseEntity<List<LocationDto>> getAllWithDto(){
        return this.locationService.getAllWithDto();
    }

    @GetMapping(path = {"/restaurant/get/info/{restaurantName}"})
    public ResponseEntity<List<RestaurantsDto>> getByDto(@PathVariable("restaurantName") String restaurantName) throws IOException {
        return this.userService.getByRestaurantName(restaurantName);
    }

    @GetMapping(path = {"/restaurant/get/all"})
    public ResponseEntity<List<RestaurantsDto>> getAll() throws IOException {
        return this.userService.getAll();
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
    public ResponseEntity<GeneralResponse> submitComment(@RequestBody CommentRequest commentRequest ){
        return this.commentService.save(commentRequest);
    }
    @GetMapping("/comment/get/{restaurantName}")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable("restaurantName")String restaurantName){
        return this.commentService.getCommentModelByRestaurantName(restaurantName);
    }

    @GetMapping("/comment/get/byUserNameAndRestaurantName/{restaurantName}")
    public ResponseEntity<List<CommentDto>> getCommentsByRestaurantNameAndUserName(@PathVariable("restaurantName")String restaurantName, String userName){
        return this.commentService.getCommentModelByRestaurantNameAndUserName(restaurantName,userName);
    }
    @GetMapping("/comment/get/byUserName/{userName}")
    public ResponseEntity<List<CommentDto>> getCommentsByUserName(@PathVariable("userName") String userName){
        return this.commentService.getCommentModelByUserName(userName);
    }
    @DeleteMapping("/comment/delete/comment/byId/{userName}")
    public ResponseEntity<GeneralResponse> deleteCommentsByUserNameCommentAndId(Long id,@PathVariable("userName") String userName){
        return this.commentService.deleteCommentByUserNameAndCommentId(id,userName);
    }


}
