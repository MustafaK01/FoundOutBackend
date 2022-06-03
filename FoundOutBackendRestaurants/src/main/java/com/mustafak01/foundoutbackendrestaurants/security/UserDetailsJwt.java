package com.mustafak01.foundoutbackendrestaurants.security;

import com.mustafak01.foundoutbackendrestaurants.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.lang.Long;

public class UserDetailsJwt implements UserDetails {

    private Long id;
    private String userName;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsJwt(Long id, String userName,
                          String password,
                          Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsJwt create(UserModel userModel){
        List<GrantedAuthority> authorityList  = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("user"));
        return new UserDetailsJwt(userModel.getId(), userModel.getEmail(),
                userModel.getPassword(),
                authorityList);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
