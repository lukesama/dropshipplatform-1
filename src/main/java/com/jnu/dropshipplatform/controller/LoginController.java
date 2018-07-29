package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.AdminAccountInfo;
import com.jnu.dropshipplatform.entity.BusinessmanInfo;
import com.jnu.dropshipplatform.entity.CompanyInfo;
import com.jnu.dropshipplatform.service.AdminAccountInfoService;
import com.jnu.dropshipplatform.service.BrandInfoService;
import com.jnu.dropshipplatform.service.BusinessmanInfoService;
import com.jnu.dropshipplatform.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("jnu")
public class LoginController {

    @Autowired
    private BrandInfoService brandInfoService;
    @Autowired
    private BusinessmanInfoService businessmanInfoService;
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private AdminAccountInfoService adminAccountInfoService;


    /**
     * 进入登录页面
     * @return
     */
    @GetMapping("signin")
    public String gotoSignInPage(){
        return "login";
    }

    /**
     *借卖方、品牌商、管理员 尝试登陆
     * @param loginName
     * @param loginPwd
     * @param roles 0，1，2 分别代表借卖方、品牌商、管理员，如果登录时没有选择roles,则默认值为-1
     * @param session
     * @param redirectAttributes
     * @Param roleSort 前端界面根据roleSort（0，1，2）显示不同的菜单项
     * @return
     */

    @PostMapping("signin")
    public String attemptToSignIn(@RequestParam String loginName,
                                  @RequestParam String loginPwd,
                                  @RequestParam(value = "roles",defaultValue = "-1") String roles,
                                  HttpSession session,
                                  RedirectAttributes redirectAttributes
                                  ){
        switch(roles){
            case "0":
                BusinessmanInfo businessmanInfo = businessmanInfoService.businessmanLogin(loginName,loginPwd);
                if(businessmanInfo!=null){
                    if(businessmanInfo.getUserStatus()==1){ //1代表账户状态正常
                        businessmanInfo.setUserPwd("");
                        session.setAttribute("businessmanLoginInfo",businessmanInfo);
                        session.setAttribute("roleSort",roles);
                        return "redirect:/jnu/ShowBusiInfo";
                    }else{
                        redirectAttributes.addFlashAttribute("loginError","账户处于冻结状态");
                    }
                }else{
                    redirectAttributes.addFlashAttribute("loginError","用户名或者密码错误");
                }

                return "redirect:/jnu/signin";

            case "1":
                CompanyInfo companyInfo = companyInfoService.providerLogin(loginName,loginPwd);
                if(companyInfo!=null){
                    if(companyInfo.getUserStatus()==1){
                        companyInfo.setUserPwd("");
                        session.setAttribute("companyLoginInfo",companyInfo);
                        session.setAttribute("roleSort",roles);
                        return "redirect:/jnu/providerInfo";
                    }else{
                        redirectAttributes.addFlashAttribute("loginError","账户处于冻结状态");
                    }
                }else{
                    redirectAttributes.addFlashAttribute("loginError","用户名或者密码错误");
                }

                return "redirect:/jnu/signin";

            case "2":
                AdminAccountInfo adminAccountInfo = adminAccountInfoService.adminLogin(loginName,loginPwd);
                if(adminAccountInfo!=null){
                    adminAccountInfo.setAdminUserPwd("");
                    session.setAttribute("adminLoginInfo",adminAccountInfo);
                    session.setAttribute("roleSort",roles);
                    return "redirect:/jnu/admin";
                }else{
                    redirectAttributes.addFlashAttribute("loginError","用户名或者密码错误");
                    return "redirect:/jnu/signin";
                }
            case "-1":
                redirectAttributes.addFlashAttribute("loginError","请选择登录类别：借卖方、品牌商或管理员");
                return "redirect:/jnu/signin";
            default:
                return "redirect:/jnu/signin";
        }
    }

    /**
     * 借卖方、品牌商用户注册，同时验证账户名是否已存在
     * @param registerRole
     * @param regUserName
     * @param regRealName
     * @param userPwd
     * @param redirectAttributes
     * @return
     */

    @PostMapping("signup")
    public String attemptRegister(@RequestParam(value = "registerRole",defaultValue = "-1") String registerRole,
                                  @RequestParam String regUserName,
                                  @RequestParam String regRealName,
                                  @RequestParam String userPwd,
                                  @RequestParam String regPhone,
                                  HttpSession session,
                                  RedirectAttributes redirectAttributes
                                  ){
        switch (registerRole){
            case "0":
                if(!businessmanInfoService.existUserName(regUserName)){
                    BusinessmanInfo businessmanInfo = new BusinessmanInfo();
                    businessmanInfo.setUserName(regUserName);
                    businessmanInfo.setRealName(regRealName);
                    businessmanInfo.setPhone(regPhone);
                    businessmanInfo.setUserPwd(userPwd);
                    businessmanInfo.setBusiBalance(0.0);
                    businessmanInfo.setUserStatus(1); //初始状态为1，表示正常使用；状态0表示禁用
                    businessmanInfoService.addBusiInfo(businessmanInfo);

                    //注册成功，直接跳到补充更多账户信息页面，无需进行登录操作
                    businessmanInfo.setUserPwd("");
                    session.setAttribute("roleSort",registerRole);
                    session.setAttribute("businessmanLoginInfo",businessmanInfo);
                    return "redirect:/jnu/addBusinessmanInfo";
                }else{
                    redirectAttributes.addFlashAttribute("registerError","注册失败，用户名已存在");
                    return "redirect:/jnu/signin#signup";
                }
            case "1":
                if(!companyInfoService.existUserName(regUserName)){
                    CompanyInfo companyInfo = new CompanyInfo();
                    companyInfo.setUserName(regUserName);
                    companyInfo.setRealName(regRealName);
                    companyInfo.setPhone(regPhone);
                    companyInfo.setUserPwd(userPwd);
                    companyInfo.setComBalance(0.0);
                    companyInfo.setUserStatus(1);//初始状态为1，表示正常使用；状态0表示禁用
                    companyInfoService.addCompanyInfo(companyInfo);

                    //注册成功，直接跳到补充更多账户信息页面，无需进行登录操作
                    companyInfo.setUserPwd("");
                    session.setAttribute("roleSort",registerRole);
                    session.setAttribute("companyLoginInfo",companyInfo);
                    return "redirect:/jnu/company";
                }else{
                    redirectAttributes.addFlashAttribute("registerError","注册失败，用户名已存在");
                    return "redirect:/jnu/signin#signup";
                }
            case "-1":
                redirectAttributes.addFlashAttribute("registerError","注册失败，请选择账户类型：借卖方或品牌方");
                return "redirect:/jnu/signin#signup";
            default:
                return "redirect:/jnu/signin#signup";
        }

    }

//    /**
//     * (初始调试)用户登陆后跳转到此页面
//     */
//    @GetMapping("homePage")
//    public String accessHomePage(){
//        return "index";
//    }

}
