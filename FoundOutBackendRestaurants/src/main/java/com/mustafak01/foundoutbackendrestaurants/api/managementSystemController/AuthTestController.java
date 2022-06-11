package com.mustafak01.foundoutbackendrestaurants.api.managementSystemController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthTestController {

/*
    String userName;
*/

    @GetMapping("/authTest")
    public String authTest(){
        return "Success";
    }

/*
    @PostMapping
    public void setUser(@RequestBody String userName){
        this.userName = userName;
    }*/

/*    @Bean
    public String getUser(){
        return this.userName;
    }*/
}
