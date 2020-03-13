package com.wordata.demo.service;

import com.wordata.demo.domain.UserEntity;
import com.wordata.demo.dto.UserDTO;
import com.wordata.demo.repository.UserRepository;
import com.wordata.demo.utils.EncryptionUtils;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    public Map<String, String> validateHandling(Errors errors) {
        //회원 가입시 유효성 체크
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError fieldError : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", fieldError.getField());
            validatorResult.put(validKeyName, fieldError.getDefaultMessage());
        }

        return validatorResult;
    }

    @Transactional
    public void signUp(UserDTO userDTO) {
        //db에 user 저장
        //비밀번호 암호화
        userDTO.setPassword(EncryptionUtils.encryptSHA256(userDTO.getPassword()));
        userDTO.setUserType("");
        userRepository.save(userDTO.toEntity());
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByLoginId(loginId);

        if (userEntity == null) {
            throw new UsernameNotFoundException(loginId + "is not found.");
        }
        //user 의 type 를 읽어와서 해당 type 에 맞는 권한을 부여
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        String role = "";
        if (userEntity.getUserType().equals("admin")) {
            role = "ROLE_ADMIN";
        } else {
            role = "ROLE_USER";
        }
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return new CustomUserDetails(userEntity, grantedAuthorities);
    }
}
