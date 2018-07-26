package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.service.AdminAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("jnu")
public class AdminController {

    @Autowired
    private AdminAccountInfoService adminAccountInfoService;

    @GetMapping("admin")
    public String adminHomePage(HttpSession session){

        return "adminHomePage";
    }

}
