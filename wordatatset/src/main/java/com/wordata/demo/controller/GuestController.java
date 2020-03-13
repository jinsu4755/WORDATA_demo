package com.wordata.demo.controller;

import com.wordata.demo.domain.User;
import com.wordata.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("userForm", new User());
        return "joinMembership";
    }

    //join logic Processing
    @PostMapping("/joinMembership")
    public String join(User user) {
        user.setUserType("");
        userService.signup(user);
        return "redirect:login";
    }

    // faq page
    @RequestMapping("/faq")
    public String faq(){
        return "faq";
    }

}
