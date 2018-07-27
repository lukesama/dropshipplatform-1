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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("jnu")
public class BusinessmanInfoController {
    @Autowired
    private BusinessmanInfoService businessmanInfoService;

    @GetMapping("Wallet")
    public String busiWallet(){
        return "BusinessmanWallet";
    }

    @GetMapping("/addInfo/{id}")      //添加用户信息
    public String addBusiInfo(@PathVariable("id") Integer userBusiId, Model model,HttpSession session){
        session.setAttribute("userBusiId",userBusiId);
        BusinessmanInfo bus=businessmanInfoService.getBusiInfoByID(userBusiId);
        model.addAttribute("bus",bus);
        return "BusinessmanInfo";
    }
    @GetMapping("/addInfo")
    public String updatePage(Model model,HttpSession session){
        String str=""+session.getAttribute("userBusiId");
        Integer userBusiId=Integer.parseInt(str);
        BusinessmanInfo bus=businessmanInfoService.getBusiInfoByID(userBusiId);
        model.addAttribute("bus",bus);
        return "BusinessmanInfo";
    }

    @PostMapping("/addInfo")         //返回修改后的页面
    public String updateBusiInfo(BusinessmanInfo businessmanInfo, HttpSession session){
        BusinessmanInfo business = (BusinessmanInfo)session.getAttribute("businessmanLoginInfo") ;
        BusinessmanInfo businessPwd = businessmanInfoService.getBusiInfoByID(business.getUserBusiId());
        business.setUserPwd(businessPwd.getUserPwd());
        business.setBusiName(businessmanInfo.getBusiName());
        business.setSupplierName(businessmanInfo.getSupplierName());
        business.setSupplierUrl(businessmanInfo.getSupplierUrl());
        businessmanInfoService.updateBusiInfo(business);
        return "ShowBusiInfo";
    }
    @GetMapping("/ShouBusiInfo")
    public String showBusiIfo(Model model,HttpSession session){
        String str=""+session.getAttribute("userbusiId");
        Integer userbusiId=Integer.parseInt(str);
        BusinessmanInfo bus=businessmanInfoService.getBusiInfoByID(userbusiId);
        model.addAttribute("bus",bus);
        Integer oneId=userbusiId;
        BusinessmanInfo businessmanInfo=businessmanInfoService.getBusiInfoByID(oneId);
        session.setAttribute("one",businessmanInfo);
        return "ShowBusiInfo";
    }
}
