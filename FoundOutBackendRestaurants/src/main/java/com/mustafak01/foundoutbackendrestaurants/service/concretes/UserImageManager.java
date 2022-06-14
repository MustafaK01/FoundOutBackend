package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModelImage;
import com.mustafak01.foundoutbackendrestaurants.model.response.GeneralResponse;
import com.mustafak01.foundoutbackendrestaurants.repository.UserImageRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.UserImageService;
import com.mustafak01.foundoutbackendrestaurants.utils.ImageUtility;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserImageManager implements UserImageService {

    UserRepository userRepository;
    UserImageRepository userImageRepository;
    @Override
    public ResponseEntity<GeneralResponse> uploadImage(MultipartFile file, Long id) throws IOException {
        Optional<UserModel> userModel = this.userRepository.findById(id);
        //the only picture belonging to the user will be deleted and a new one will be added
        this.deleteImage(userModel.get().getId());
        //userImageRepository.deleteByUserModel_Id(userModel.get().getId());
        userImageRepository.save(UserModelImage.builder()
                .userModel(userModel.get())
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.ok().body(new GeneralResponse("Resim Başarıyla Güncellendi : " +
                        file.getOriginalFilename(),true));
    }

    public void deleteImage(Long id){
        userImageRepository.deleteByUserModel_Id(id);
    }

}
