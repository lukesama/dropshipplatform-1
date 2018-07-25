package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.service.BusinessmanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("BIC")
public class BusinessmanInfoController {
    @Autowired
    private BusinessmanInfoService businessmanInfoService;

    @GetMapping("Wallet")
    public String busiWallet(){
        return "BusinessmanWallet";
    }

    @GetMapping("/addInfo/{id}")      //添加用户信息
    public String addBusiInfo(@PathVariable("id") Integer userBusiId, Model model){
        BusinessmanInfo busi=businessmanInfoService.getBusiInfoByID(userBusiId);
        model.addAttribute("bus",busi);
        return "BusinessmanInfo";
    }
    @PostMapping("/addInfo")         //返回修改后的页面
    public String addBusiInfo(BusinessmanInfo businessmanInfo){
        businessmanInfoService.updateBusiInfo(businessmanInfo);
        return "redirect:/jnu/addInfo/"+businessmanInfo.getUserBusiId();
    }
}
