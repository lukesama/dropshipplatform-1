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


    /**
     * 借卖方登录后首先跳转到此页面
     * @param session   登录界面提供的session
     * @return
     */

    @GetMapping("/ShowBusiInfo")
    public String showBusiIfo(HttpSession session){

        return "ShowBusiInfo";
    }

    /**
     * 借卖方在ShowBusiInfo.html 点击“更改”按钮后跳转到此页面
     * @param session
     * @return
     */

    @GetMapping("/addBusinessmanInfo")      //添加用户信息
    public String addBusiInfo(HttpSession session){
        return "BusinessmanInfo";
    }

    /**
     * BusinessmanInfo post回修改后的BusinessmanInfo
     * @param businessmanInfo
     * @param session
     * @return
     */
    @PostMapping("/addBusinessmanInfo")         //返回修改后的页面
    public String updateBusiInfo(BusinessmanInfo businessmanInfo, HttpSession session){
        BusinessmanInfo business = (BusinessmanInfo)session.getAttribute("businessmanLoginInfo") ;
        BusinessmanInfo businessPwd = businessmanInfoService.getBusiInfoByID(business.getUserBusiId());
        business.setUserPwd(businessPwd.getUserPwd());
        business.setBusiName(businessmanInfo.getBusiName());
        business.setSupplierName(businessmanInfo.getSupplierName());
        business.setSupplierUrl(businessmanInfo.getSupplierUrl());
        businessmanInfoService.updateBusiInfo(business);
        return "redirect:/jnu/ShowBusiInfo";
    }

    @GetMapping("Wallet")
    public String busiWallet(){
        return "BusinessmanWallet";
    }

}
