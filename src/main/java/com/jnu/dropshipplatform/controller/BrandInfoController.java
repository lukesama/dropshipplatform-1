//package com.jnu.dropshipplatform.controller;
//
//
//import com.jnu.dropshipplatform.entity.BrandInfo;
//import com.jnu.dropshipplatform.entity.CompanyInfo;
//import com.jnu.dropshipplatform.service.BrandInfoService;
//import com.jnu.dropshipplatform.service.CompanyInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import javax.websocket.server.PathParam;
//import java.util.List;
//
//@Controller
//@RequestMapping("jnu/providerInfo")
//public class BrandInfoController {
//
//    @Autowired
//    private BrandInfoService brandInfoService;
//    @Autowired
//    private CompanyInfoService companyInfoService;
//
//    @GetMapping("{id}")
//    public String getAllBrand(@PathVariable("id") Integer ownerId, Model model, HttpSession session){
//        CompanyInfo companyInfo = companyInfoService.getCompanyInfoById(ownerId);
//        session.setAttribute("owner",companyInfo);
//        List<BrandInfo> brandInfos = brandInfoService.getAllBrand(ownerId);
//        model.addAttribute("allBrand",brandInfos);
//        return "ProviderInfo";
//    }
//
//    @GetMapping("/add")
//    public String addBrandInfoPage(){
//        return "addBrandInfo";
//    }
//
//    @PostMapping("/add")
//    public String addBrandInfo(BrandInfo brandInfo,HttpSession session){
//        CompanyInfo owner = (CompanyInfo) session.getAttribute("owner");
//        brandInfo.setBrandOwner(owner);
//        brandInfoService.addBrandInfo(brandInfo);
//        return "redirect:/jnu/providerInfo/"+owner.getUserComId();
//    }
//
//    @GetMapping("{id}/delete")
//    public String deleteBrandInfo(@PathVariable("id") Integer brandId,HttpSession session){
//        brandInfoService.deleteBrandInfo(brandId);
//        CompanyInfo owner = (CompanyInfo) session.getAttribute("owner");
//        return "redirect:/jnu/providerInfo/"+owner.getUserComId();
//    }
//
//    @GetMapping("{id}/update")
//    public String updateBrandInfoPage(@PathVariable("id") Integer brandId,Model model){
//        BrandInfo brandInfo = brandInfoService.getBrandInfoByBrandId(brandId);
//        model.addAttribute("brandInfo",brandInfo);
//        return "updateBrandInfo";
//    }
//
//    @PostMapping("/update")
//    public String updateBrandInfo(BrandInfo brandInfo,HttpSession session){
//        CompanyInfo owner = (CompanyInfo)session.getAttribute("owner");
//        brandInfo.setBrandOwner(owner);
//        brandInfoService.updateBrandInfo(brandInfo);
//        return "redirect:/jnu/providerInfo/"+owner.getUserComId();
//    }
//
//}
