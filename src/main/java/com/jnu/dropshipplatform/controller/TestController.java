package com.jnu.dropshipplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("jnu")
public class TestController {

//    @GetMapping
//    public String test(){
//        return "login";
//    }
//
    @GetMapping("homePage1")
    public String toHome(HttpSession session){
        session.setAttribute("roleSort","1");
        return "index";
    }



}
