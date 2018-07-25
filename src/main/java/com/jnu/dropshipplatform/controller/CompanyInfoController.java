package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("jnu")
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;

    @GetMapping("/company/{id}")
    public String addComInfo(@PathVariable("id") Integer comId,Model model,HttpSession session) {
        session.setAttribute("comId",comId);
        CompanyInfo com = companyInfoService.getCompanyById(comId);
        model.addAttribute("company",com);
        return "CompanyInfo";
    }

    @GetMapping("/provider")
    public String getAllCom(Model model,HttpSession session) {
        String str = ""+session.getAttribute("comId");
        Integer comId = Integer.parseInt(str);
        CompanyInfo com = companyInfoService.getCompanyById(comId);
        model.addAttribute("company",com);
        return "ProviderInfo";
    }

    @GetMapping("/company")
    public String addPage(Model model, HttpSession session) {
        String str = ""+session.getAttribute("comId");
        Integer comId = Integer.parseInt(str);
        CompanyInfo com = companyInfoService.getCompanyById(comId);
        model.addAttribute("company",com);
        return "CompanyInfo";
    }

    @PostMapping("/company")
    public String addCompany(CompanyInfo companyInfo,HttpSession session) {
        String str = ""+session.getAttribute("comId");
        Integer comId = Integer.parseInt(str);
        companyInfo.setUserComId(comId);
        companyInfo.setComBalance(0.0);
        companyInfoService.updateCompanyInfo(companyInfo);
        return "redirect:/jnu/provider";
    }


}
