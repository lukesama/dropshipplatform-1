package com.jnu.dropshipplatform.controller;


import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.entity.DayBookBusinessman;
import com.jnu.dropshipplatform.entity.DayBookCompany;
import com.jnu.dropshipplatform.service.CompanyInfoService;
import com.jnu.dropshipplatform.service.DayBookCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/jnu/company")
public class CompanyWalletController {
    @Autowired
    private DayBookCompanyService dayBookCompanyService;
    @Autowired
    private CompanyInfoService companyInfoService;

    @GetMapping("Wallet")
    public String jumpToWallet(HttpSession session, Model model){
        CompanyInfo companyInfo=(CompanyInfo)session.getAttribute("companyLoginInfo");
        model.addAttribute("company",companyInfo);
        return "CompanyWallet";
    }

    @GetMapping("/Wallet/daybook")
    public String jumpToDaybook(HttpSession session,Model model){
        CompanyInfo companyInfo=(CompanyInfo)session.getAttribute("companyLoginInfo");
        List<DayBookCompany> dayBookCompany=dayBookCompanyService.findDayBookCompanyByCompanyInfo(companyInfo);
        model.addAttribute("daybook",dayBookCompany);
        return "CompanyDaybook";
    }
    @GetMapping("/Wallet/Recharge")
    public String jumpToRecharge(){
        return "CompanyWithdraw";
    }
    @PostMapping("/Wallet/Recharge")
    public String jumpToRecharge(@RequestParam("money") Double money,
                                 @RequestParam("pwd") String password,
                                 HttpSession session){
        CompanyInfo companyInfo=(CompanyInfo)session.getAttribute("companyLoginInfo");
        CompanyInfo companyInfo1=companyInfoService.providerLogin(companyInfo.getComName(),password);
        if(companyInfo1!=null&&companyInfo.getComBalance()>=money){
            companyInfo1.setComBalance(companyInfo1.getComBalance()-money);
            companyInfo.setComBalance(companyInfo.getComBalance()-money);
            companyInfoService.save(companyInfo1);

            DayBookCompany dayBookCompany=new DayBookCompany();
            dayBookCompany.setCheckStatus(0);
            dayBookCompany.setCompany(companyInfo);
            dayBookCompany.setOperationType("提现");
            dayBookCompany.setTradeAmounts(money);
            dayBookCompany.setTradeTime(new Timestamp(System.currentTimeMillis()));
            dayBookCompanyService.save(dayBookCompany);
            return "redirect:/jnu/company/Wallet";
        }
        else{
            return "CompanyRechargeError";
        }
    }
}
