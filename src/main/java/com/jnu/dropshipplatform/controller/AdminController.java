package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.*;
import com.jnu.dropshipplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("jnu")
public class AdminController {

    @Autowired
    private AdminAccountInfoService adminAccountInfoService;
    @Autowired
    private BusinessmanInfoService businessmanInfoService;
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private DayBookBusinessmanService dayBookBusinessmanService;
    @Autowired
    private DayBookCompanyService dayBookCompanyService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("admin")
    public String adminHomePage(HttpSession session){

        return "adminHomePage";
    }

    //BusinessmanInfo manage begin here

    /**
     *管理借卖用户
     * @param session  由/jnu/admin 传过来，即adminHomePage方法
     * @param model
     * @return
     */

    @GetMapping("managerBusiness")
    public String manageBusinessman(HttpSession session,Model model){
        List<BusinessmanInfo> lists = businessmanInfoService.getAllBusinessmanInfo();
        model.addAttribute("allBusinessmanInfo",lists);
        return "adminManagebusi";
    }

    /**
     * 根据用户选中的record 改变用户的状态
     * @param userId
     * @param session
     * @return
     */

    @GetMapping("changeBusiStatus/{id}")
    public String changeBusiStatus(@PathVariable("id")Integer userId, HttpSession session){

        BusinessmanInfo businessmanInfo = businessmanInfoService.getBusiInfoByID(userId);
        if(businessmanInfo.getUserStatus() == 1){
            businessmanInfo.setUserStatus(0);
        }else{
            businessmanInfo.setUserStatus(1);
        }
        businessmanInfoService.updateBusiInfo(businessmanInfo);

        return "redirect:/jnu/managerBusiness";
    }

    /**
     * 删除指定ID 对应的用户
     * @param userId
     * @param session
     * @return
     */
    @GetMapping("deleteBusiUser/{id}")
    public String deleteBusiUser(@PathVariable("id") Integer userId,HttpSession session){
        businessmanInfoService.deleteByUserId(userId);
        return "redirect:/jnu/managerBusiness";
    }

    //BusinessmanInfo manage begin here

    //CompanyInfo manage begin here

    /**
     * 管理品牌商所有账户
     * @param session 由/jnu/admin 传过来，即adminHomePage方法
     * @param model
     * @return
     */
    @GetMapping("managerCompany")
    public String managerCompany(HttpSession session,Model model){
        List<CompanyInfo> lists = companyInfoService.getAllCompany();
        model.addAttribute("allCompanyInfo",lists);
        return "adminManageCpy";
    }

    /**
     * 修改指定品牌商账户的状态
     * @param userId
     * @param session
     * @return
     */
    @GetMapping("changeCpyStatus/{id}")
    public String changeCpyStatus(@PathVariable("id") Integer userId,HttpSession session){

        CompanyInfo companyInfo = companyInfoService.getCompanyById(userId);
        if(companyInfo.getUserStatus()==1){
            companyInfo.setUserStatus(0);
        }else{
            companyInfo.setUserStatus(1);
        }

        companyInfoService.updateCompanyInfo(companyInfo);

        return "redirect:/jnu/managerCompany";
    }

    /**
     * 删除指定品牌商账户
     * @param userId
     * @param session
     * @return
     */
    @GetMapping("deleteCpyUser/{id}")
    public String deleteCpyUser(@PathVariable("id") Integer userId,HttpSession session){
        companyInfoService.deleteCompanyById(userId);
        return "redirect:/jnu/managerCompany";
    }

    //CompanyInfo manage end here

    //BusinessmanDayBook manage begin here


    /**
     * 审核所有借卖方账户流水
     * @param session
     * @param model
     * @return
     */
    @GetMapping("busiDayBookCheck")
    public String busiDayBookCheck(HttpSession session,Model model ){
        List<DayBookBusinessman> lists = dayBookBusinessmanService.getAllDayBookBusinessman();
        model.addAttribute("allBusiDayBook",lists);
        return "adminManageBusiDayBook";
    }


    /**
     * 对指定ID 进行审核
     * @param dayBookID
     * @param toPass
     * @param session
     * @return
     */
    @GetMapping("changeBusiDayBookStatus/{id}/{flag}")
    public String changeBusiDayBookStatus(@PathVariable("id") Integer dayBookID,
                                          @PathVariable("flag") String toPass,
                                           HttpSession session){
        DayBookBusinessman dayBookBusinessman = dayBookBusinessmanService.findDayBookBusinessmanById(dayBookID);

        if(toPass.equals("1")){
            dayBookBusinessman.setCheckStatus(1);

            //审核通过后，在对应账户上增加金额
            BusinessmanInfo businessmanInfo =  dayBookBusinessman.getBusinessman();
            businessmanInfo.setBusiBalance(businessmanInfo.getBusiBalance()+dayBookBusinessman.getTradeAmounts());
            businessmanInfoService.updateBusiInfo(businessmanInfo);
        }else if(toPass.equals("0")){
            dayBookBusinessman.setCheckStatus(-1);
        }

        dayBookBusinessmanService.save(dayBookBusinessman);

        return "redirect:/jnu/busiDayBookCheck";

    }

    //BusinessmanDayBook manage end here


    //cpyDayBook manage begin here

    @GetMapping("cpyDayBookCheck")
    public String cpyDayBookCheck(HttpSession session,Model model){
        List<DayBookCompany> lists = dayBookCompanyService.getAllCpyDayBook();
        model.addAttribute("allCpyDayBook",lists);
        return "adminManageCpyDayBook";
    }

    @GetMapping("changeCpyDayBookStatus/{id}/{flag}")
    public String changeCpyDayBookStatus(@PathVariable("id") Integer dayBookID,
                                         @PathVariable("flag") String toPass,
                                         HttpSession session){
        DayBookCompany dayBookCompany = dayBookCompanyService.findDayBookCpyByID(dayBookID);
        if(toPass.equals("1")){
            dayBookCompany.setCheckStatus(1);
        }else if(toPass.equals("0")){
            dayBookCompany.setCheckStatus(-1);
        }

        dayBookCompanyService.save(dayBookCompany);

        return "redirect:/jnu/cpyDayBookCheck";
    }
    //cpyDayBook manage end here

    //admin manage category begin here

    /**
     * 商品类别展示页面（有添加类别的功能）
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/manageCategory/list/{PID}")
    public String manageCategory(@PathVariable(value = "PID")Integer PID, HttpSession session,Model model){

        //展示分类表
        List<ProductCategory> lists = productCategoryService.getAllProCategory();

        //获取主类别
        List<ProductCategory> list2 = productCategoryService.getCateByFatherId(PID);

        model.addAttribute("mainCate",list2);
        model.addAttribute("allProCategory",lists);
        return "adminManageCategory";
    }

    @GetMapping("/fatherID/{PID}")
    @ResponseBody
    public List<ProductCategory> getAllCategoryByPID(@PathVariable(value = "PID") Integer PID,HttpSession session){
        List<ProductCategory> lists = productCategoryService.getCateByFatherId(PID);
        return lists;
    }

    @GetMapping("addCatagory")
    public String addCatagory(@RequestParam String firstCate,
                              @RequestParam String secondCate,
                              @RequestParam String cateName,
                              HttpSession session){

        ProductCategory productCategory = new ProductCategory();
        Integer fatehrId;
        if(firstCate.equals("0") && secondCate.equals("0")){
            productCategory.setCateName(cateName);
            productCategory.setFatherCateId(0);
            productCategory.setCatePath(">"+cateName);
            productCategoryService.addCatagory(productCategory);
        }else if(!firstCate.equals("0") && secondCate.equals("0")){
            fatehrId = Integer.parseInt(firstCate);
            productCategory.setCateName(cateName);
            productCategory.setFatherCateId(fatehrId);
            productCategory.setCatePath(productCategoryService.getCateInfoById(fatehrId).getCatePath()+">"+cateName);
            productCategoryService.addCatagory(productCategory);
        }else if(!firstCate.equals("0") && !secondCate.equals("0")){
            fatehrId = Integer.parseInt(secondCate);
            productCategory.setCateName(cateName);
            productCategory.setFatherCateId(fatehrId);
            productCategory.setCatePath(productCategoryService.getCateInfoById(fatehrId).getCatePath()+">"+cateName);
            productCategoryService.addCatagory(productCategory);
        }

        return "redirect:/jnu//manageCategory/list/0";
    }

    //admin manage category end here
}
