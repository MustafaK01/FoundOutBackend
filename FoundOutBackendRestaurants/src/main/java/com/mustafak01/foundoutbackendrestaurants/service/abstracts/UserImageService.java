package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.response.GeneralResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserImageService {

    ResponseEntity<GeneralResponse> uploadImage(MultipartFile file, Long id)  throws IOException;
}
