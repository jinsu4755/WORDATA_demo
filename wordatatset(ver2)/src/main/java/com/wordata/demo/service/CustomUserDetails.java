package com.wordata.demo.service;

import com.wordata.demo.domain.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private UserEntity userEntity;
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        //계정의 만료 확인
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //계정이 잠겼는지 확인
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //계정의 password 가 만료되었나 확인
        return true;
    }

    @Override
    public boolean isEnabled() {
        //계정의 활성화 여부
        return true;
    }
}
