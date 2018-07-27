package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.DayBookBusinessman;
import com.jnu.dropshipplatform.service.BusinessmanInfoService;
import com.jnu.dropshipplatform.service.DayBookBusinessmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("jnu")
public class BusinessmanInfoController {
    @Autowired
    private BusinessmanInfoService businessmanInfoService;
    @Autowired
    private DayBookBusinessmanService dayBookBusinessmanService;

    @GetMapping("Wallet")
    public String jumpToWallet(HttpSession session, Model model) {
        BusinessmanInfo businessmanInfo = (BusinessmanInfo) session.getAttribute("businessmanLoginInfo");
        model.addAttribute("businessman", businessmanInfo);
        return "BusinessmanWallet";
        }

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

//    @GetMapping("Wallet")
//    public String busiWallet(){
//        return "BusinessmanWallet";
//    }
    @GetMapping("/Wallet/daybook")
    public String jumpToDaybook(HttpSession session,Model model){
        BusinessmanInfo businessmanInfo=(BusinessmanInfo)session.getAttribute("businessmanLoginInfo");
        List<DayBookBusinessman> dayBookBusinessmen=dayBookBusinessmanService.findDaybookByBussinessman(businessmanInfo);
        model.addAttribute("daybook",dayBookBusinessmen);
        return "BusinessmanDaybook";
    }
    @GetMapping("/Wallet/Recharge")
    public String jumpToRecharge(){
        return "BussinessmanRecharge";
    }
    @PostMapping("/Wallet/Recharge")
    public String jumpToRecharge(@RequestParam("money") Double money,
                                 @RequestParam("pwd") String password,
                                 HttpSession session){
        BusinessmanInfo businessmanInfo=(BusinessmanInfo)session.getAttribute("businessmanLoginInfo");
        BusinessmanInfo businessman=businessmanInfoService.businessmanLogin(businessmanInfo.getUserName(),password);
        if(businessman!=null){
            DayBookBusinessman dayBookBusinessman=new DayBookBusinessman();
            dayBookBusinessman.setBusinessman(businessmanInfo);
            dayBookBusinessman.setCheckStatus(0);
            dayBookBusinessman.setOperationType("充值");
            dayBookBusinessman.setTradeAmounts(money);
            dayBookBusinessman.setTradeTime(new Timestamp(System.currentTimeMillis()));
            dayBookBusinessmanService.save(dayBookBusinessman);
            return "redirect:/jnu/Wallet";
        }
       else{
            return "BusinessmanRechargeError";
        }
    }

}
