package com.mustafak01.foundoutbackendrestaurants.service.abstracts;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingImage;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingImageDtoForMobile;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto;
import com.mustafak01.foundoutbackendrestaurants.model.response.ImageUploadResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MenuServicingImageService {
    ResponseEntity<ImageUploadResponse> uploadImage(MultipartFile file,Long id) throws IOException;
    MenuServicingImage getImageDetails(Long id);
    ResponseEntity<byte[]> getImage(Long id);

    ResponseEntity<MenuServicingWithImageDto> getMenuServicingImageByMenuServicingId(Long id);

    ResponseEntity<Void> deleteMenuServicingImageWithMenuServicingById(Long id);

    ResponseEntity<List<MenuServicingWithImageDto>> getMenuServicingByMenuId(Long id);

    ResponseEntity<List<MenuServicingImageDtoForMobile>> getMenuServicingImageByTitle(String title);

    ResponseEntity<List<MenuServicingImageDtoForMobile>> getMenuServicingImageByTitleAndMenuName(String title,String menuName);

    ResponseEntity<List<MenuServicingImageDtoForMobile>> getMenuServicingImageByTitleAndMenuId(String title,Long menuId);

}
