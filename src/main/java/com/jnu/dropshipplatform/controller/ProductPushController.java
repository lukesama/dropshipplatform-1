package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.*;
import com.jnu.dropshipplatform.repository.BusinessmanInfoRepository;
import com.jnu.dropshipplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("jnu/Businessman")
public class ProductPushController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductPushService productPushService;

    @Autowired
    private BusinessmanInfoService businessmanInfoService;

    @Autowired
    private UnpublishService unpublishService;

    @GetMapping("/viewProduct")
    public String getViewProduct(Model model) {
        //直接获得所有商品
        List<ProductInfo> lists = productInfoService.getAllProduct();
        model.addAttribute("allProduct",lists);
        //For Classify
        List<ProductCategory> cateList = productCategoryService.getCateByFatherId(0);
        model.addAttribute("allCate",cateList);
        return "ViewProduct";
    }

    @GetMapping("/productDetail/{id}")
    public String proDetailPage(@PathVariable("id") Integer proId, Model model) {
        ProductInfo productInfo = productInfoService.findProductInfoByProId(proId);
        ProductCategory productCategory = productCategoryService.getCateInfoById(productInfo.getProCategoryId());
        model.addAttribute("product",productInfo);
        model.addAttribute("catePath",productCategory);
        return "ProductDetail";
    }

    @GetMapping("/viewProduct/{id}")
    public String getProductByCate(@PathVariable("id") Integer fatherId, Model model) {
        List<ProductCategory> cateList = productCategoryService.getCateByFatherId(fatherId);
        model.addAttribute("allCate",cateList);
        List<ProductInfo> lists = productInfoService.getProductByMidCate(fatherId);
        model.addAttribute("allProduct",lists);
        ProductCategory productCategory = productCategoryService.getCateInfoById(fatherId);
        model.addAttribute("catePath",productCategory.getCatePath());
        return "ViewProduct";
    }

    @PostMapping("/pushProduct/{id}")
    public String pushProduct(@PathVariable("id") Integer proId, HttpSession session,@RequestParam("price") Double price){
        BusinessmanInfo businessmanInfo = (BusinessmanInfo) session.getAttribute("businessmanLoginInfo");
        BusinessmanInfo busi = businessmanInfoService.getBusiInfoByID(businessmanInfo.getUserBusiId());
        ProductInfo productInfo = productInfoService.findProductInfoByProId(proId);
        ProductPush push = new ProductPush();
        if (productPushService.existProductPush(busi,productInfo)){
            push = productPushService.getProductPushByBusAndPro(busi,productInfo);
        }
        push.setBusiId(busi);
        push.setProId(productInfo);
        push.setSellPrice(price);
        productPushService.insertProductPush(push);
        return "redirect:/jnu/Businessman/productDetail/"+proId;
    }

    @GetMapping("/viewPushProduct")
    public String viewProduct(HttpSession session, Model model){
        BusinessmanInfo businessmanInfo = (BusinessmanInfo)session.getAttribute("businessmanLoginInfo");
        List<ProductPush> pushList = productPushService.getAllPushProduct(businessmanInfo);
        model.addAttribute("allProduct",pushList);
        List<Unpublish> unpublishList = unpublishService.getUnpublishByBusInfo(businessmanInfo);
        model.addAttribute("allUnpublish",unpublishList);
        return "showPush";
    }

    @GetMapping("/viewPushProduct/{id}/delete")
    public String cancelPush(@PathVariable("id")Integer pushId){
        productPushService.cancelProduct(pushId);
        return "redirect:/jnu/Businessman/viewPushProduct";
    }

    @GetMapping("/viewPushProduct/{id}/hasRead")
    public String hasRead(@PathVariable("id")Integer readId){
        unpublishService.deleteById(readId);
        return "redirect:/jnu/Businessman/viewPushProduct";
    }
}
