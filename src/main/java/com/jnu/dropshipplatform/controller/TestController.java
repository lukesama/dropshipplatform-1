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

}
