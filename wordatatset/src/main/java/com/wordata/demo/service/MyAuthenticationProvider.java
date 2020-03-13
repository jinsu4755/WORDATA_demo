package com.wordata.demo.service;

import com.wordata.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //사용자가 입력 로그인 아이와 비밀번호 검사시 해당 method 자동 호출
        // 사용자가 입력한 로그인 아이디와 비밀번호가 해당 메소드의 파라미터로 전달된다.
        String loginId = authentication.getName();
        String passwd = authentication.getCredentials().toString();
        return authenticate(loginId, passwd);
    }


    public Authentication authenticate(String loginId, String password) throws AuthenticationException {
        User user = userService.login(loginId, password);
        if (user == null) {
            return null;
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        String role = "";
        if (user.getUserType().equals("admin")) {
            role = "ROLE_ADMIN";
        } else {
            role = "ROLE_USER";
        }
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return new MyAuthentication(loginId, password, grantedAuthorities, user);
    }

    public class MyAuthentication extends UsernamePasswordAuthenticationToken {
        private static final long serialVersionUID = 1L;
        User user;

        public MyAuthentication(String userId, String password, List<GrantedAuthority> grantedAuthorities, User user) {
            super(userId, password, grantedAuthorities);
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
