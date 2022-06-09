package com.mustafak01.foundoutbackendrestaurants.service.concretes;

import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import com.mustafak01.foundoutbackendrestaurants.repository.UserRepository;
import com.mustafak01.foundoutbackendrestaurants.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    UserRepository userRepository;

    @Override
    public UserModel getUserModelById(Long id) {
        return userRepository.getUserModelById(id);
    }
}
