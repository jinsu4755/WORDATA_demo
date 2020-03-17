package com.wordata.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("index")
    public String test(Model model){
        model.addAttribute("string1", "testString 1");
        model.addAttribute("string2", "testString2");
        return "test/test";
    }

    @RequestMapping("param")
    public String testParam(@RequestParam("id") String id, Model model) {
        model.addAttribute("id", id);
        return "test/testParam";
    }
}
