package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.service.AdminAccountInfoService;
import com.jnu.dropshipplatform.service.BusinessmanInfoService;
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

}
