package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.ProductCategory;
import com.jnu.dropshipplatform.entity.ProductInfo;
import com.jnu.dropshipplatform.service.ProductCategoryService;
import com.jnu.dropshipplatform.service.ProductInfoService;
import com.jnu.dropshipplatform.service.ProductPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/viewProduct")
    public String getViewProduct(Model model) {
        //直接获得所有商品
        List<ProductInfo> lists = productInfoService.getAllProduct();
        model.addAttribute("allProduct",lists);
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

//    @PostMapping("/viewProduct")
//    public String getProductByCate(@RequestParam) {
//
//    }



}
