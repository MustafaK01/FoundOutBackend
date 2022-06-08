package com.mustafak01.foundoutbackendrestaurants.controller;


import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingImage;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto;
import com.mustafak01.foundoutbackendrestaurants.model.response.ImageUploadResponse;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuServicingImageService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/menus/servicings")
@AllArgsConstructor
public class MenuServicingImageController {

    MenuServicingImageService menuServicingImageService;

    @PostMapping("/upload/image/{id}")
    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file
            ,@PathVariable("id") Long id) throws IOException {
        return this.menuServicingImageService.uploadImage(file,id);
    }

    @GetMapping(path = {"/get/image/info/{id}"})
    public ResponseEntity<MenuServicingWithImageDto> getImageDetailsByDto(@PathVariable("id") Long id) throws IOException{
        return this.menuServicingImageService.getMenuServicingImageByMenuServicingId(id);
    }

    @GetMapping(path = {"/get/image/{id}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
        return this.menuServicingImageService.getImage(id);
    }
    @GetMapping(path = {"/get/image/info/byMenuId/{id}"})
    public ResponseEntity<List<MenuServicingWithImageDto>> getMenuServicingImageByMenuId(@PathVariable("id") Long id) throws IOException{
        return this.menuServicingImageService.getMenuServicingByMenuId(id);
    }
    @DeleteMapping(path = {"/delete/imageAndServicing/{id}"})
    public ResponseEntity<Void> deleteMenuServicingImageWithMenuServicing(@PathVariable("id") Long id){
        System.out.println("Controller : "+id);
        return this.menuServicingImageService.deleteMenuServicingImageWithMenuServicingById(id);
    }
}
