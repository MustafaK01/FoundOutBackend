package com.mustafak01.foundoutbackendrestaurants.api.managementSystemController;


import com.mustafak01.foundoutbackendrestaurants.model.response.ImageUploadResponse;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.UserImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/users/images")
@AllArgsConstructor
public class UserImageController {
    //Management sisteminden gelecek olan resimler için

    UserImageService userImageService;

    @PostMapping("/upload/image/{id}")
    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file
            ,@PathVariable("id") Long id) throws IOException {
        return this.userImageService.uploadImage(file,id);
    }



}
