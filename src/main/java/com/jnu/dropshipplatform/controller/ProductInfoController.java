package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.*;
import com.jnu.dropshipplatform.service.BrandInfoService;
import com.jnu.dropshipplatform.service.BrandProductService;
import com.jnu.dropshipplatform.service.CompanyInfoService;
import com.jnu.dropshipplatform.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("jnu/company")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private BrandInfoService brandInfoService;
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private BrandProductService brandProductService;

    @GetMapping("/ProductShow/{id}")
    public String getProduct(/*HttpSession session,*/@PathVariable("id") Integer id, Model model){
        //CompanyInfo companyInfo=session.getAttribute("CompanyInfo");
        CompanyInfo companyInfo=companyInfoService.findCompanyInfoByUserComId(id);
        List<BrandInfo> brandInfos=brandInfoService.findBrandInfoByBrandOwner(companyInfo);
        List<BrandProduct> brandProducts=new ArrayList<BrandProduct>();
        List<ProductAndCategory> product=new ArrayList<ProductAndCategory>();
        for(int i=0;i<brandInfos.size();i++){
            brandProducts.addAll(brandProductService.findBrandProductByBrandId(brandInfos.get(i).getBrandId()));
        }
        for(int i=0;i<brandProducts.size();i++){
            product.addAll(productInfoService.getProductAndCategory(brandProducts.get(i).getProductInfo()));
        }
        model.addAttribute("product",product);
        return "CompanyProductShow";
    }

    @GetMapping("insert")
    public String jumpToInsert(/*HttpSession session,Model model*/){

        return "CompanyProductInsert";
    }
    @PostMapping("insert")
    public  String insert(ProductInfo productInfo){
        productInfo.setProStatus(0);
        productInfoService.save(productInfo);
        BrandProduct brandProduct=new BrandProduct();
        brandProduct.setBrandId(1);
        brandProduct.setProductInfo(productInfo.getProId());
        brandProductService.save(brandProduct);
        return "redirect/jnu/company/CompanyProductShow";
    }

    @GetMapping("update/{id}")
    public String jumpToUpdate(@PathVariable ("id") Integer id,Model model){
        ProductInfo productInfo=productInfoService.findProductInfoByProId(id);
        model.addAttribute("product",productInfo);
        return "CompanyProductUpdate";
    }
    @PostMapping("update")
    public  String update(ProductInfo productInfo){
        productInfoService.save(productInfo);
        return "redirect/jnu/company/CompanyProductShow";
    }
}
