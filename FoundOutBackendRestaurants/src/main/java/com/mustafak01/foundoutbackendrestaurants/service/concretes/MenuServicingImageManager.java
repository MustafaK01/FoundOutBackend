package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingImage;
import com.mustafak01.foundoutbackendrestaurants.model.MenuServicingModel;
import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingImageDtoForMobile;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto;
import com.mustafak01.foundoutbackendrestaurants.model.response.GeneralResponse;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingImageRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.MenuServicingRepository;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
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

    UserRepository userRepository;

    @Override
    public ResponseEntity<GeneralResponse> uploadImage(MultipartFile file, Long id) throws IOException {
        Optional<MenuServicingModel> menuServicingModel = this.menuServicingRepository.findById(id);
        servicingImageRepository.save(MenuServicingImage.builder()
                .menuServicingModel(menuServicingModel.get())
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new GeneralResponse("Resim Başarıyla Eklendi : " +
                        file.getOriginalFilename(),true));
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
//        final List<MenuServicingWithImageDto> servicingImage = servicingImageRepository.getMenuServicingImageByMenuServicingId(id);
        final MenuServicingWithImageDto servicingImage = servicingImageRepository.getMenuServicingImageByMenuServicingId(id);
        final List<MenuServicingWithImageDto> servicingImages = new ArrayList<>();
        if (servicingImage != null) {
            servicingImages.add(MenuServicingWithImageDto.builder().servicingId(servicingImage.getServicingId())
                        .servicingName(servicingImage.getServicingName())
                        .servicingImageId(servicingImage.getServicingImageId())
                        .servicingPrice(servicingImage.getServicingPrice())
                        .menuId(servicingImage.getMenuId())
                        .image(ImageUtility.decompressImage(servicingImage.getImage())).build());
            return new ResponseEntity(servicingImages, HttpStatus.OK);
        }
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Void> deleteMenuServicingImageWithMenuServicingById(Long id) {
        MenuServicingImage menuServicingImage = this.servicingImageRepository.getById(id);
        MenuServicingWithImageDto menuServicingWithImageDto = this.servicingImageRepository
                .getByImageId(id);
        MenuServicingModel menuServicingModel = this.menuServicingRepository
                .getById(menuServicingWithImageDto.getServicingId());
        this.servicingImageRepository.delete(menuServicingImage);
        this.menuServicingRepository.delete(menuServicingModel);
        System.out.println("Manager "+id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<MenuServicingWithImageDto>> getMenuServicingByMenuId(Long id) {
        final List<MenuServicingWithImageDto> servicingImage = servicingImageRepository.getMenuServicingImageByMenuServicingModel_MenuModel_Id(id);
        final List<MenuServicingWithImageDto> servicingImageTemp = new ArrayList<>();
        if (servicingImage != null) {
            for (MenuServicingWithImageDto i : servicingImage) {
                servicingImageTemp.add(MenuServicingWithImageDto.builder().servicingId(i.getServicingId())
                        .servicingName(i.getServicingName())
                        .servicingImageId(i.getServicingImageId())
                        .servicingPrice(i.getServicingPrice())
                        .menuId(i.getMenuId())
                        .image(ImageUtility.decompressImage(i.getImage())).build());
            }
            System.out.println(id);
            return ResponseEntity.ok().body(servicingImageTemp);
        }
        return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<MenuServicingImageDtoForMobile>> getMenuServicingImageByTitle(String title) {
        UserModel userModel= this.userRepository.findByTitle(title);
        final List<MenuServicingImageDtoForMobile> servicingImageTemp = new ArrayList<>();
        List<MenuServicingImageDtoForMobile> menuServicingImageDtoForMobile
               =this.servicingImageRepository.getMenuServicingImageByUserIdForMobile(userModel.getId());
        return getListResponseEntity(servicingImageTemp, menuServicingImageDtoForMobile);
    }

    @Override
    public ResponseEntity<List<MenuServicingImageDtoForMobile>> getMenuServicingImageByTitleAndMenuName(String title, String menuName) {
        UserModel userModel= this.userRepository.findByTitle(title);
        final List<MenuServicingImageDtoForMobile> servicingImageTemp = new ArrayList<>();
        List<MenuServicingImageDtoForMobile> menuServicingImageDtoForMobile
                =this.servicingImageRepository.getMenuServicingImageByUserIdAndMenuName(userModel.getId(),menuName);
        return getListResponseEntity(servicingImageTemp, menuServicingImageDtoForMobile);
    }

    @Override
    public ResponseEntity<List<MenuServicingImageDtoForMobile>> getMenuServicingImageByTitleAndMenuId(String title, Long menuId) {
        UserModel userModel= this.userRepository.findByTitle(title);
        final List<MenuServicingImageDtoForMobile> servicingImageTemp = new ArrayList<>();
        List<MenuServicingImageDtoForMobile> menuServicingImageDtoForMobile
                =this.servicingImageRepository.getMenuServicingImageByUserIdAndMenuId(userModel.getId(),menuId);
        return getListResponseEntity(servicingImageTemp, menuServicingImageDtoForMobile);
    }

    private ResponseEntity<List<MenuServicingImageDtoForMobile>> getListResponseEntity(List<MenuServicingImageDtoForMobile> servicingImageTemp, List<MenuServicingImageDtoForMobile> menuServicingImageDtoForMobile) {
        if (menuServicingImageDtoForMobile != null) {
            for (MenuServicingImageDtoForMobile i : menuServicingImageDtoForMobile) {
                servicingImageTemp.add(MenuServicingImageDtoForMobile.builder()
                        .servicingName(i.getServicingName())
                        .servicingPrice(i.getServicingPrice())
                        .explanation(i.getExplanation())
                        .menuName(i.getMenuName())
                        .image(ImageUtility.decompressImage(i.getImage())).build());
            }
            return ResponseEntity.ok().body(servicingImageTemp);
        }
        return new ResponseEntity("Resim Getirilemedi", HttpStatus.BAD_REQUEST);
    }

}
