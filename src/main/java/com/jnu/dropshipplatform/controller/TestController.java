package com.jnu.dropshipplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("jnu")
public class TestController {

    @GetMapping("/t")
    public String forTest(){
        return "0ForTest";
    }

    @PostMapping("/tr")
    public String forTestReturn(@RequestParam("price") Double pr){
        return "0ForTest";
    }
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
//    @GetMapping("t")
//    public String tester(Model model){
//        String s ="abcd";
//        model.addAttribute("test",s);
//        return "0ForTest";
//    }

}
