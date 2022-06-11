package com.mustafak01.foundoutbackendrestaurants.api.foundOutController;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user/menuServicings")
@AllArgsConstructor
public class MenuServicingImageControllerForMobile {

 /*   MenuServicingImageService menuServicingImageService;

    @GetMapping(path = {"/get/image/info/{title}"})
    public ResponseEntity<List<MenuServicingImageDtoForMobile>> getImageDetailsForMobileWithDtoByTitle(@PathVariable("title") String title) throws IOException {
        return this.menuServicingImageService.getMenuServicingImageByTitle(title);
    }

    @GetMapping(path = {"/get/image/info/byMenuName/{title}"})
    public ResponseEntity<List<MenuServicingImageDtoForMobile>> getImageDetailsForMobileWithDtoByTitleAndMenuName(@PathVariable("title") String title,String menuName) throws IOException {
        return this.menuServicingImageService.getMenuServicingImageByTitleAndMenuName(title,menuName);
    }*/




}
