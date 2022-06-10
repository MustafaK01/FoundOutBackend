package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.UserService;
import com.mustafak01.foundoutbackendrestaurants.utils.ImageUtility;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    UserRepository userRepository;

    @Override
    public ResponseEntity<UserModel> getUserModelById(Long id) {
        return ResponseEntity.ok().body(this.userRepository.getUserModelById(id));
    }

    @Override
    public ResponseEntity<RestaurantsDto> getByRestaurantName(String name) {
        UserModel userModel = this.userRepository.findByTitle(name);
        final List<RestaurantsDto> restaurantsDto = this.userRepository.getAllByRestaurantIdWithDto(userModel.getId());
        final List<RestaurantsDto> restaurantsDtos = new ArrayList<>();
        if (restaurantsDto != null) {
            for (RestaurantsDto i : restaurantsDto) {
                 restaurantsDtos.add(RestaurantsDto.builder()
                        .category(i.getCategory())
                        .name(i.getName())
                        .price(i.getPrice())
                        .image(ImageUtility.decompressImage(i.getImage())).build());
            }
            return new ResponseEntity(restaurantsDtos, HttpStatus.ACCEPTED);

        }
        return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
    }

}
