package com.wordata.demo.config;

import com.wordata.demo.service.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
        //base resource 는 보안에서 무시
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin/**").access("ROLE_ADMIN")
                .antMatchers("/").permitAll();

        http.formLogin()
                .loginPage("/login") //login page url setting
                .loginProcessingUrl("/login_processing")
                .failureUrl("/login?error") //로그인 실패시 해당 url로 redirect
                .defaultSuccessUrl("/") //로그인 성공시 해당 url reidrect
                .usernameParameter("loginId")
                .passwordParameter("password");
                //위 2 옵션은 로그인 파라미터 이름 지정

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout_processing"))
                // 로그아웃 버튼이나 링크로 url요청하고 절차는 security 엔진에서 자동진행
                .logoutSuccessUrl("/").invalidateHttpSession(true);
                //logout 후 넘어갈 page 지정하고 세션에 들어있는 데이터는 삭제

        http.authenticationProvider(myAuthenticationProvider);
    }
}
