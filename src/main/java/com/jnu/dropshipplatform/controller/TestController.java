package com.jnu.dropshipplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("jnu")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

//    @GetMapping
//    public String test(){
//        return "login";
//    }
//
//    @GetMapping("homePage1/{id}")
//    public String toHome(@PathVariable("id") Integer integer){
////
//        return "0ForTest";
//    }
//
    @GetMapping("t")
    public String tester(Model model){
        String s ="abcd";
        model.addAttribute("test",s);
        return "0ForTest";
    }

}
