package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.service.AdminAccountInfoService;
import com.jnu.dropshipplatform.service.BusinessmanInfoService;
import com.jnu.dropshipplatform.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("admin")
    public String adminHomePage(HttpSession session){

        return "adminHomePage";
    }

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
}
