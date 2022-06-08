package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.MenuModel;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingImage;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto;
import com.mustafak01.foundoutbackendrestaurants.model.response.ImageUploadResponse;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingImageRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.MenuServicingImageService;
import com.mustafak01.foundoutbackendrestaurants.utils.ImageUtility;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MenuServicingImageManager implements MenuServicingImageService {

    MenuServicingImageRepository servicingImageRepository;
    MenuServicingRepository menuServicingRepository;

    @Override
    public ResponseEntity<ImageUploadResponse> uploadImage(MultipartFile file,Long id) throws IOException {
        Optional<MenuServicingModel> menuServicingModel = this.menuServicingRepository.findById(id);
        servicingImageRepository.save(MenuServicingImage.builder()
                .menuServicingModel(menuServicingModel.get())
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Resim Başarıyla Eklendi : " +
                        file.getOriginalFilename()));
    }

    @Override
    public MenuServicingImage getImageDetails(Long id) {
        final Optional<MenuServicingImage> servicingImage = servicingImageRepository.findByMenuServicingModel_Id(id);

        return MenuServicingImage.builder().name(servicingImage.get().getName())
                .type(servicingImage.get().getType())
                .image(ImageUtility.decompressImage(servicingImage.get().getImage())).build();    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) {
        final Optional<MenuServicingImage> servicingImage = servicingImageRepository.findByMenuServicingModel_Id(id);

        return ResponseEntity.ok().contentType(MediaType.valueOf(servicingImage.get().getType()))
                .body(ImageUtility.decompressImage(servicingImage.get().getImage()));
    }
    @Override
        public ResponseEntity<MenuServicingWithImageDto> getMenuServicingImageByMenuServicingId(Long id) {
        final List<MenuServicingWithImageDto> servicingImage = servicingImageRepository.getMenuServicingImageByMenuServicingId(id);
        if (servicingImage != null) {
            for (MenuServicingWithImageDto i : servicingImage) {
                return ResponseEntity.ok().body(MenuServicingWithImageDto.builder().servicingId(i.getServicingId())
                        .servicingName(i.getServicingName())
                        .servicingPrice(i.getServicingPrice())
                        .menuId(i.getMenuId())
                        .image(ImageUtility.decompressImage(i.getImage())).build());
            }
        }
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
    }

}