package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingImage;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModelImage;
import com.mustafak01.foundoutbackendrestaurants.model.response.ImageUploadResponse;
import com.mustafak01.foundoutbackendrestaurants.repository.UserImageRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.UserImageService;
import com.mustafak01.foundoutbackendrestaurants.utils.ImageUtility;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserImageManager implements UserImageService {

    UserRepository userRepository;
    UserImageRepository userImageRepository;
    @Override
    public ResponseEntity<ImageUploadResponse> uploadImage(MultipartFile file, Long id) throws IOException {
        Optional<UserModel> userModel = this.userRepository.findById(id);
        userImageRepository.save(UserModelImage.builder()
                .userModel(userModel.get())
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Resim Başarıyla Eklendi : " +
                        file.getOriginalFilename()));
    }

}
