package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.*;
import com.jnu.dropshipplatform.service.BrandInfoService;
import com.jnu.dropshipplatform.service.BrandProductService;
import com.jnu.dropshipplatform.service.CompanyInfoService;
import com.jnu.dropshipplatform.service.ProductInfoService;
import com.jnu.dropshipplatform.utils.FileUtil;
import com.jnu.dropshipplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("/ProductShow")
    public String getProduct(HttpSession session,/*@PathVariable("id") Integer id,*/ Model model){
        CompanyInfo companyInfo=(CompanyInfo)session.getAttribute("companyLoginInfo");
        //CompanyInfo companyInfo=companyInfoService.findCompanyInfoByUserComId(id);
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
    public String jumpToInsert(HttpSession session,Model model){
        List<BrandInfo> brandInfo=brandInfoService.findBrandInfoByBrandOwner((CompanyInfo)session.getAttribute("companyLoginInfo"));
        List<ProductCategory> firstProductCategories= productCategoryService.getCateByFatherId(0);
        model.addAttribute("brand",brandInfo);
        return "CompanyProductInsert";
    }
    @PostMapping("insert")
    public  String insert(@RequestParam("brandNum") Integer brand,
                          @RequestParam("file") MultipartFile file,
                          ProductInfo productInfo){
        String contentType = file.getContentType();                 //图片文件类型
        String fileName = file.getOriginalFilename();               //图片名字
        String filePath = FileUtil.getUpLoadFilePath();
        fileName = System.currentTimeMillis()+fileName;
        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        }catch (Exception e){
            // TODO:handle exception
        }
        productInfo.setProImage(fileName);
        productInfo.setProStatus(0);
        productInfoService.save(productInfo);
        BrandProduct brandProduct=new BrandProduct();
        brandProduct.setBrandId(brand);
        brandProduct.setProductInfo(productInfo.getProId());
        brandProductService.save(brandProduct);
        return "redirect:/jnu/company/ProductShow";
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
        return "redirect:/jnu/company/ProductShow";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable ("id") Integer id){
        productInfoService.delete(id);
        return "redirect:/jnu/company/ProductShow";
    }
}
