package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.CompanyInfo;
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


    /**
     * 进入登录页面
     * @return
     */
    @GetMapping("signin")
    public String gotoSignInPage(){
        return "login";
    }

    /**
     * 尝试登陆
     * @param loginName
     * @param loginPwd
     * @param roles
     * @param session
     * @param redirectAttributes
     * @return
     */

    @PostMapping("signin")
    public String attemptToSignIn(@RequestParam String loginName,
                                  @RequestParam String loginPwd,
                                  @RequestParam String roles,
                                  HttpSession session,
                                  RedirectAttributes redirectAttributes
                                  ){
        switch(roles){
            case "0":


                break;
            case "1":
                CompanyInfo companyInfo = companyInfoService.providerLogin(loginName,loginPwd);
                if(companyInfo!=null){
                    companyInfo.setUserPwd("");
                    session.setAttribute("companyLoginInfo",companyInfo);
//                    return "index";
                    return "redirect:/jnu/company/"+companyInfo.getUserComId();
                }else{
                    redirectAttributes.addFlashAttribute("loginError","用户名后者密码错误");
                    return "redirect:/jnu/signin";
                }

            case "2":
                break;
            default:
                break;
        }

        return "";
    }


    @PostMapping("signup")
    public String attemptRegister(@RequestParam String registerRole,
                                  @RequestParam String regUserName,
                                  @RequestParam String regRealName,
                                  @RequestParam String userPwd,
                                  RedirectAttributes redirectAttributes
                                  ){
        switch (registerRole){
            case "0":
                break;
            case "1":

                CompanyInfo companyInfo = new CompanyInfo();
                companyInfo.setUserName(regUserName);
                companyInfo.setRealName(regRealName);
                companyInfo.setUserPwd(userPwd);
                companyInfo.setComBalance(0.0);
                companyInfoService.addCompanyInfo(companyInfo);
                return "redirect:/jnu/signin";

            default:
                break;
        }

        return "";

    }

    /**
     * 用户登陆后跳转到此页面
     */
    @GetMapping("homePage")
    public String accessHomePage(){
        return "index";
    }

}
