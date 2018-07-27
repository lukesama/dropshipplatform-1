package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.BrandInfo;
import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.service.BrandInfoService;
import com.jnu.dropshipplatform.service.CompanyInfoService;
import com.jnu.dropshipplatform.entity.*;
import com.jnu.dropshipplatform.service.*;
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
    @Autowired
    private BrandInfoService brandInfoService;


    /**
     * 登录成功后跳转到此页面
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/providerInfo")
    public String getAllCom(Model model,HttpSession session) {
        CompanyInfo com_tmp =  (CompanyInfo) session.getAttribute("companyLoginInfo");
        CompanyInfo com = companyInfoService.getCompanyById(com_tmp.getUserComId());
        model.addAttribute("company",com);
//        Integer ownerId = com_tmp.getUserComId();
//        CompanyInfo companyInfo = companyInfoService.getCompanyInfoById(ownerId);
//        session.setAttribute("owner",companyInfo);
        List<BrandInfo> brandInfos = brandInfoService.getAllBrand(com_tmp.getUserComId());
        model.addAttribute("allBrand",brandInfos);
        return "ProviderInfo";
    }

    /**
     * ProviderInfo.html 页点击更改公司信息，跳转到此页面
     * @param session
     * @return
     */
    @GetMapping("/company")
    public String updatePage(HttpSession session) {

        return "CompanyInfo";
    }

    /**
     * CompanyInfo.html 页面点击提交修改，跳转到此
     * @param companyInfo
     * @param session
     * @return
     */
    @PostMapping("/company")
    public String updateCompany(CompanyInfo companyInfo,HttpSession session) {
        CompanyInfo com = (CompanyInfo) session.getAttribute("companyLoginInfo");
        CompanyInfo comGetPwd = companyInfoService.getCompanyById(com.getUserComId());
        com.setUserPwd(comGetPwd.getUserPwd());
        com.setComName(companyInfo.getComName());
        com.setComDescription(companyInfo.getComDescription());
        com.setComLogo(companyInfo.getComLogo());
        companyInfoService.updateCompanyInfo(com);
        return "redirect:/jnu/providerInfo";
    }


    //BrandInfo begin here....
    @GetMapping("providerInfo/add")
    public String addBrandInfoPage(){
        return "addBrandInfo";
    }

    @PostMapping("providerInfo/add")
    public String addBrandInfo(BrandInfo brandInfo,HttpSession session){
        CompanyInfo comForId = (CompanyInfo) session.getAttribute("companyLoginInfo");
        CompanyInfo owner = companyInfoService.getCompanyById(comForId.getUserComId());
        brandInfo.setBrandOwner(owner);
        brandInfoService.addBrandInfo(brandInfo);
        return "redirect:/jnu/providerInfo";
    }

    @GetMapping("providerInfo/{id}/delete")
    public String deleteBrandInfo(@PathVariable("id") Integer brandId,HttpSession session){
        brandInfoService.deleteBrandInfo(brandId);
//        CompanyInfo owner = (CompanyInfo) session.getAttribute("owner");
        return "redirect:/jnu/providerInfo";
    }

    @GetMapping("providerInfo/{id}/update")
    public String updateBrandInfoPage(@PathVariable("id") Integer brandId,Model model){
        BrandInfo brandInfo = brandInfoService.getBrandInfoByBrandId(brandId);
        model.addAttribute("brandInfo",brandInfo);
        return "updateBrandInfo";
    }

    @PostMapping("providerInfo/update")
    public String updateBrandInfo(BrandInfo brandInfo,HttpSession session){
        CompanyInfo comForId = (CompanyInfo) session.getAttribute("companyLoginInfo");
        CompanyInfo owner = companyInfoService.getCompanyById(comForId.getUserComId());
        brandInfo.setBrandOwner(owner);
        brandInfoService.updateBrandInfo(brandInfo);
        return "redirect:/jnu/providerInfo";
    }

}
