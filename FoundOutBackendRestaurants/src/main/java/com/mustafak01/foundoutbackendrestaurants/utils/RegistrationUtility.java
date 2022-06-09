package com.mustafak01.foundoutbackendrestaurants.utils;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegistrationUtility implements RegistrationUtilityService {

    public Boolean isTrueEmail(String email){
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern patternCompileEmailRegex = Pattern.compile(emailRegex);
        Matcher matcher = patternCompileEmailRegex.matcher(email);
        return matcher.matches();
    }
    public Boolean isTruePhoneNumber(String phoneNumber){
        String regexPhoneNumber = "^5(0[5-7]|[3-5]\\d)\\d{3}\\d{4}$";
        Pattern patternCompilePhoneNumberRegex = Pattern.compile(regexPhoneNumber);
        Matcher matcher = patternCompilePhoneNumberRegex.matcher(phoneNumber);
        return matcher.matches();
    }



}
