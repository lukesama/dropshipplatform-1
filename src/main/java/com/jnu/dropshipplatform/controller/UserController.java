package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.*;
import com.jnu.dropshipplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jnu/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductPushService productPushService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderDetailedService orderDetailedService;
    @Autowired
    private  DayBookBusinessmanService dayBookBusinessmanService;
    @Autowired
    private  BusinessmanInfoService businessmanInfoService;
    @GetMapping
    public String jumpToBuy(Model model){
        List<ProductPush> productPushs=productPushService.getAll();
        List<ProductInfo> productInfos=new ArrayList<ProductInfo>();
        for(int i=0;i<productPushs.size();i++){
            productInfos.add(productPushs.get(i).getProId());
        }
        model.addAttribute("product",productInfos);
        return "UserBuy";
    }

    @PostMapping("order")
    public String buy(@RequestParam Integer proId, @RequestParam String address, @RequestParam Integer Num, HttpSession session){
        ProductInfo productInfo=productInfoService.findProductInfoByProId(proId);
        ProductPush productPush=productPushService.getAllProByProInfo(productInfo).get(0);
        Double totalPrice=productPush.getSellPrice()*Num;
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setOrderStatus(0);
        orderInfo.setTrackingNo("0");
        orderInfo.setBusiId(productPush.getBusiId());
        orderInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        orderInfo.setDeliveryAddress(address);
        OrderInfo orderInfonew=orderInfoService.save(orderInfo);
        orderInfo.setTotalPrice(productInfoService.findProductInfoByProId(proId).getDroPrice()*Num);
        session.setAttribute("order",orderInfonew);
        session.setAttribute("totalPrice",totalPrice);
        OrderDetailed orderDetailed=new OrderDetailed();
        orderDetailed.setOrderId(orderInfonew.getOrderId());
        orderDetailed.setProId(productInfo.getProId());
        orderDetailed.setProModel(productInfo.getProModel());
        orderDetailed.setProSales(Num);
        orderDetailed.setSellPrice(productInfo.getDroPrice());
        orderDetailedService.save(orderDetailed);
        return "redirect:/jnu/user/pay";
    }

    @GetMapping("pay")
    public String jumpToPay(Model model,HttpSession session){
        List<UserInfo> userInfos=userInfoService.findAll();
        model.addAttribute("userInfos",userInfos);
        OrderInfo orderInfo=(OrderInfo)session.getAttribute("order");
        model.addAttribute("orderInfo",orderInfo);
        return "UserPay";
    }

    @PostMapping("pay")
    public String pay(@RequestParam String userName,@RequestParam String pwd,HttpSession session){
        UserInfo userInfo=userInfoService.findUserInfoByUserNameAndUserPwd(userName,pwd);
        OrderInfo orderInfo=(OrderInfo)session.getAttribute("order");
        Double totalmoney=(Double)session.getAttribute("totalPrice");
        if(userInfo!=null&&userInfo.getUserBalance()>=totalmoney){
            userInfo.setUserBalance(userInfo.getUserBalance()-orderInfo.getTotalPrice());
            DayBookBusinessman dayBookBusinessman=new DayBookBusinessman();
            dayBookBusinessman.setTradeTime(new Timestamp(System.currentTimeMillis()));
            dayBookBusinessman.setTradeAmounts(totalmoney);
            dayBookBusinessman.setOperationType("销售");
            dayBookBusinessman.setCheckStatus(1);
            dayBookBusinessman.setBusinessman(orderInfo.getBusiId());
            dayBookBusinessmanService.save(dayBookBusinessman);
            BusinessmanInfo businessmanInfo=orderInfo.getBusiId();
            businessmanInfo.setBusiBalance(businessmanInfo.getBusiBalance()+totalmoney);
            businessmanInfoService.save(businessmanInfo);
            orderInfo.setConsumerId(userInfo.getId());
            orderInfo.setOrderStatus(1);
            orderInfoService.save(orderInfo);
            return "redirect:/jnu/user/result/1";
        }
        else{
            orderInfo.setConsumerId(userInfoService.getUserByName(userName).getId());
            orderInfoService.save(orderInfo);
            return "redirect:/jnu/user/result/0";
        }
    }

    @GetMapping("result/{num}")
    public String getResult(@PathVariable Integer num,Model model){
        model.addAttribute("num",num);
        return "UserResult";
    }
}
