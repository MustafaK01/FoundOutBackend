package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.MenuServicingWithImageDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.RestaurantsDto;
import com.mustafak01.foundoutbackendrestaurants.model.dtos.UserDto;
import com.mustafak01.foundoutbackendrestaurants.model.response.GeneralResponse;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.UserService;
import com.mustafak01.foundoutbackendrestaurants.utils.ImageUtility;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    UserRepository userRepository;

    @Override
    public ResponseEntity<UserModel> getUserModelById(Long id) {
        return ResponseEntity.ok().body(this.userRepository.getUserModelById(id));
    }

    @Override
    public ResponseEntity<List<RestaurantsDto>> getByRestaurantName(String name)  {
        try {
            UserModel userModel = this.userRepository.findByTitle(name);
            final List<RestaurantsDto> restaurantsDto = this.userRepository.getAllByRestaurantIdWithDto(userModel.getId());
            return getListRestaurantsDto(restaurantsDto);
        }catch (Exception e){
            System.err.println(e);
            throw e;
        }
    }

    @Override
    public ResponseEntity<List<RestaurantsDto>> getAll() {
        final List<RestaurantsDto> restaurantsDto = this.userRepository.getAllByDto();
        return getListRestaurantsDto(restaurantsDto);
    }

    private ResponseEntity<List<RestaurantsDto>> getListRestaurantsDto(List<RestaurantsDto> restaurantsDto) {
        final List<RestaurantsDto> restaurantsDtos = new ArrayList<>();
        if (restaurantsDto.size() != 0) {
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

    @Override
    public ResponseEntity<UserDto> getUserInfoByRestaurantNameAndUserId(String restaurantName, Long userId) {
        UserModel userModel = this.userRepository.getById(userId);
        final UserDto userDto  =  this.userRepository.getUserInfoByUserIdAndRestaurantName(userModel.getId(),restaurantName);
        if (userDto != null) {
            UserDto userDtoTemp=UserDto.builder()
                    .restaurantName(userDto.getRestaurantName())
                    .address(userDto.getAddress())
                    .image(ImageUtility.decompressImage(userDto.getImage())).build();
            return new ResponseEntity(userDtoTemp, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);

    }

}
