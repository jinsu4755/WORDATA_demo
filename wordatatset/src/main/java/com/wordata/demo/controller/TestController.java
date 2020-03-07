package com.wordata.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("index")
    public String testIndex(){
        return "test/index";
    }

    @RequestMapping("join")
    public String testJoin(){
        return "test/joinMembership";
    }

    @RequestMapping("login")
    public String testLogin(){
        return "test/login";
    }

    @RequestMapping("service")
    public String testService(){
        return "test/service";
    }

    @RequestMapping("faq")
    public String testFaq(){
        return "test/faq";
    }
}
