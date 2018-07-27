package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.service.AdminAccountInfoService;
import com.jnu.dropshipplatform.service.BusinessmanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("jnu")
public class AdminController {

    @Autowired
    private AdminAccountInfoService adminAccountInfoService;
    @Autowired
    private BusinessmanInfoService businessmanInfoService;

    @GetMapping("admin")
    public String adminHomePage(HttpSession session){

        return "adminHomePage";
    }

    /**
     *
     * @param session  由/jnu/admin 传过来，即adminHomePage方法
     * @param model
     * @return
     */

    @GetMapping("managerBusiness")
    public String manageBusinessman(HttpSession session,Model model){
        List<BusinessmanInfo> lists = businessmanInfoService.getAllBusinessmanInfo();
        model.addAttribute("allBusinessmanInfo",lists);
        return "adminManagebusi";
    }

}
