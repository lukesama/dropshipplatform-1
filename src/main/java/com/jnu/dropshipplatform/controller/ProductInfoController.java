package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.*;
import com.jnu.dropshipplatform.service.*;
import com.jnu.dropshipplatform.utils.FileUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    @Autowired
    private ProductPushService productPushService;
    @Autowired
    private UnpublishService unpublishService;

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
        model.addAttribute("selectedName","请选择筛选类别");
        return "CompanyProductShow";
    }

    @GetMapping("insert")
    public String jumpToInsert(Model model){
        List<ProductCategory> cateList = productCategoryService.getCateByFatherId(0);
        model.addAttribute("allCate",cateList);
        return "CompanyProductInsert";
    }

    @GetMapping("/insert/{id}")
    public String getProductByCate(@PathVariable("id") Integer fatherId,
                                   Model model,
                                   HttpSession session) {
        Integer isDetailCate = 0;
        Boolean isDetaileCate_temp = productCategoryService.isDetailProductByCateId(fatherId);
        if(isDetaileCate_temp) {
            isDetailCate = 1;
            session.setAttribute("cateId",fatherId);
        }
        //传入当前类别是否为详细类别
        model.addAttribute("isDetailCate",isDetailCate);
        List<ProductCategory> cateList = productCategoryService.getCateByFatherId(fatherId);
        model.addAttribute("allCate",cateList);
        ProductCategory productCategory = productCategoryService.getCateInfoById(fatherId);
        model.addAttribute("catePath",productCategory.getCatePath());
        List<BrandInfo> brandInfo=brandInfoService.findBrandInfoByBrandOwner((CompanyInfo)session.getAttribute("companyLoginInfo"));
        model.addAttribute("brand",brandInfo);
        return "CompanyProductInsert";
    }

    @PostMapping("insert")
    public  String insert(@RequestParam("brandNum") Integer brand,
                          @RequestParam("file") MultipartFile file,
                          ProductInfo productInfo,
                          HttpSession session){
        String contentType = file.getContentType();                 //图片文件类型
        String fileName = file.getOriginalFilename();               //图片名字
        String filePath = FileUtil.getUpLoadFilePath();
        fileName = System.currentTimeMillis()+fileName;
        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        }catch (Exception e){
            // TODO:handle exception
        }
        String cateId_temp = session.getAttribute("cateId").toString();
        Integer cateId = Integer.parseInt(cateId_temp);
        productInfo.setProCategoryId(cateId);
        productInfo.setProImage(fileName);
        productInfo.setProStatus(0);
        productInfoService.save(productInfo);
        BrandProduct brandProduct=new BrandProduct();
        brandProduct.setBrandId(brand);
        brandProduct.setProductInfo(productInfo.getProId());
        brandProductService.save(brandProduct);
        return "redirect:/jnu/company/ProductShow";
    }

    @GetMapping("/update")
    public String resetPage(Model model,
                            HttpSession session){
        List<ProductCategory> cateList = productCategoryService.getCateByFatherId(0);
        model.addAttribute("allCate",cateList);
        return "CompanyProductUpdate";
    }

    @GetMapping("/update/loop/{id}")
    public String loopUpdate(@PathVariable("id") Integer fatherId,
                             Model model,
                             HttpSession session){
        Integer isDetailCate = 0;
        Boolean isDetaileCate_temp = productCategoryService.isDetailProductByCateId(fatherId);
        if(isDetaileCate_temp) {
            isDetailCate = 1;
            session.setAttribute("cateId",fatherId);
        }
        //传入当前类别是否为详细类别
        model.addAttribute("isDetailCate",isDetailCate);
        List<ProductCategory> cateList = productCategoryService.getCateByFatherId(fatherId);
        model.addAttribute("allCate",cateList);
        ProductCategory productCategory = productCategoryService.getCateInfoById(fatherId);
        model.addAttribute("catePath",productCategory.getCatePath());
        List<BrandInfo> brandInfo=brandInfoService.findBrandInfoByBrandOwner((CompanyInfo)session.getAttribute("companyLoginInfo"));
        model.addAttribute("brand",brandInfo);
//        List<BrandInfo> brandInfo=brandInfoService.findBrandInfoByBrandOwner((CompanyInfo)session.getAttribute("companyLoginInfo"));
//        model.addAttribute("brand",brandInfo);
        return "CompanyProductUpdate";
    }

    @GetMapping("update/{id}")
    public String jumpToUpdate(@PathVariable ("id") Integer id,
                               Model model,
                               HttpSession session){
        ProductInfo productInfo=productInfoService.findProductInfoByProId(id);
        session.setAttribute("productInfo",productInfo);
        ProductCategory productCategory = productCategoryService.getCateInfoById(productInfo.getProCategoryId());
        Integer cateId = productCategory.getCateId();
        session.setAttribute("cateId",cateId);
        Integer isDetailCate = 1;
        //传入当前类别是否为详细类别
        model.addAttribute("isDetailCate",isDetailCate);
        List<BrandInfo> brandInfo=brandInfoService.findBrandInfoByBrandOwner((CompanyInfo)session.getAttribute("companyLoginInfo"));
        model.addAttribute("brand",brandInfo);
        return "CompanyProductUpdate";
    }

    @PostMapping("update")
    public  String update(ProductInfo productInfo,
                          @RequestParam("file")MultipartFile file,
                          HttpSession session){
        String contentType = file.getContentType();                 //图片文件类型
        String fileName = file.getOriginalFilename();               //图片名字
        String filePath = FileUtil.getUpLoadFilePath();
        fileName = System.currentTimeMillis()+fileName;
        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        }catch (Exception e){
            // TODO:handle exception
        }
        String cateId_temp = session.getAttribute("cateId").toString();
        Integer cateId = Integer.parseInt(cateId_temp);
        productInfo.setProCategoryId(cateId);
        productInfo.setProImage(fileName);
        productInfoService.save(productInfo);
        return "redirect:/jnu/company/ProductShow";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable ("id") Integer id){
        ProductInfo productInfo = productInfoService.findProductInfoByProId(id);
        if(productPushService.existProPushByProInfo(productInfo)) {
            List<ProductPush> productPushList = productPushService.getAllProByProInfo(productInfo);
            for(int i=0;i<productPushList.size();i++) {
                String proTitle = productPushList.get(i).getProId().getProTitle();
                BusinessmanInfo businessmanInfo = productPushList.get(i).getBusiId();
                Unpublish unpublish = new Unpublish();
                unpublish.setBusinessmanInfo(businessmanInfo);
                unpublish.setProTitle(proTitle);
                unpublishService.addUnpublish(unpublish);
                productPushService.cancelProduct(productPushList.get(i).getId());
            }
        }
        productInfoService.delete(id);
        return "redirect:/jnu/company/ProductShow";
    }

    @GetMapping("sortBy/{id}")
    public String sortBy(@PathVariable("id") Integer selectedItem,Model model){
        model.addAttribute("selectedItem",selectedItem);
        String[] str = {"按品牌筛选","按类别筛选","按标题筛选"};
        model.addAttribute("selectedName",str[selectedItem]);
//        return "redirect:/jnu/company/ProductShow";
        return "CompanyProductShow";
}

}
