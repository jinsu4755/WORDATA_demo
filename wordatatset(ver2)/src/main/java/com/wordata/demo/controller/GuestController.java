package com.wordata.demo.controller;

import com.wordata.demo.domain.UserEntity;
import com.wordata.demo.dto.UserDTO;
import com.wordata.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class GuestController {

    @Autowired
    UserService userService;

    //main page
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    //service page
    @RequestMapping("/service")
    public String service(){
        return "service";
    }

    //login page
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //join page
    @GetMapping("/joinMembership")
    public String join(Model model){
        model.addAttribute("userForm", new UserDTO());
        return "joinMembership";
    }

    //join logic Processing
    @PostMapping("/joinMembership")
    public String join(@Valid UserDTO userDTO, Errors errors, Model model) {
        if (errors.hasErrors()) {
            //회원가입 실패시 입력 데이터 유지
            model.addAttribute("userDto", userDTO);

            //유효성 통과 못한 필드와 메시지 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            return "joinMembership";
        }

        userService.signUp(userDTO);
        return "redirect:login";
    }

    // faq page
    @RequestMapping("/faq")
    public String faq(){
        return "faq";
    }

}
