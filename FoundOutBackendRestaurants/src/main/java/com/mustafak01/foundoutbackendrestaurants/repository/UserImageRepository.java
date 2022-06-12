package com.mustafak01.foundoutbackendrestaurants.repository;

import com.mustafak01.foundoutbackendrestaurants.model.UserModelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface UserImageRepository extends JpaRepository<UserModelImage, Long> {

    void deleteByUserModel_Id(Long userId);

}
