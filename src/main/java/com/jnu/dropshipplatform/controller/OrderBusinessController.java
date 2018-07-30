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
@RequestMapping("/jnu/businessman/order")
public class OrderBusinessController {
    @Autowired
    private OrderDetailedService orderDetailedService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private  BusinessmanInfoService businessmanInfoService;
    @Autowired
    private  DayBookBusinessmanService dayBookBusinessmanService;
    @Autowired
    private BrandProductService brandProductService;
    @Autowired
    private BrandInfoService brandInfoService;
    @Autowired
    private DayBookCompanyService dayBookCompanyService;
    @Autowired
    private  CompanyInfoService companyInfoService;
    @Autowired
    private ProductInfoService productInfoService;
    @GetMapping
    public String show(HttpSession session,Model model){
        BusinessmanInfo businessmanInfo=(BusinessmanInfo)session.getAttribute("businessmanLoginInfo");
        //0为消费未支付 1为消费者支付借卖方未支付 2为未发货 3为发货 4为已完成  -1为取消
        List<OrderInfo> orderInfoUnpaid=orderInfoService.findOrderInfoByBussinessman(businessmanInfo,0);
        model.addAttribute("orderInfoUnpaid",orderInfoUnpaid);
        List<OrderInfo> orderInfoPaying=orderInfoService.findOrderInfoByBussinessman(businessmanInfo,1);
        model.addAttribute("orderInfoPaying",orderInfoPaying);
        List<OrderInfo> orderInfoShipping=orderInfoService.findOrderInfoByBussinessman(businessmanInfo,2);
        model.addAttribute("orderInfoShipping",orderInfoShipping);
        List<OrderInfo> orderInfoShipped=orderInfoService.findOrderInfoByBussinessman(businessmanInfo,3);
        model.addAttribute("orderInfoShipped",orderInfoShipped);
        List<OrderInfo> orderInfoCompleted=orderInfoService.findOrderInfoByBussinessman(businessmanInfo,4);
        model.addAttribute("orderInfoCompleted",orderInfoCompleted);
        List<OrderInfo> orderInfoCanceled=orderInfoService.findOrderInfoByBussinessman(businessmanInfo,-1);
        model.addAttribute("orderInfoCancelled",orderInfoCanceled);

        return "BusinessmanOrderShow";
    }
    @GetMapping("/detailed/{id}")
    public String showDetail(@PathVariable Integer id,Model model){
        List<OrderAndProduct> orderAndProducts=orderDetailedService.getOrderAndProductByOrderId(id);
        model.addAttribute("orderAndProducts",orderAndProducts);
        return "BusinessmanOrderDetail";
    }

    @GetMapping("/pay/{id}")
    public String jumpToPay(@PathVariable Integer id,Model model){
        OrderInfo orderInfo=orderInfoService.findOrderInfoByOrderId(id);
        OrderDetailed orderDetailed = orderDetailedService.findAllByOrderId(id).get(0);
        ProductInfo productInfo = productInfoService.findProductInfoByProId(orderDetailed.getProId());
        Double total = orderDetailed.getProSales()*productInfo.getDroPrice();
        orderInfo.setTotalPrice(total);
        model.addAttribute("orderInfo",orderInfo);
        return "BusinessmanOrderPay";
    }

    @PostMapping("/pay")
    public String pay( @RequestParam Integer orderId,
                           @RequestParam Double money,@RequestParam String pwd,HttpSession session){
        BusinessmanInfo businessmanInfo=(BusinessmanInfo)session.getAttribute("businessmanLoginInfo");
        BusinessmanInfo businessman=businessmanInfoService.businessmanLogin(businessmanInfo.getUserName(),pwd);
        if(businessman!=null&&businessmanInfo.getBusiBalance()>=money){
            DayBookBusinessman dayBookBusinessman=new DayBookBusinessman();
            dayBookBusinessman.setBusinessman(businessmanInfo);
            dayBookBusinessman.setCheckStatus(1);
            dayBookBusinessman.setOperationType("消费");
            dayBookBusinessman.setTradeAmounts(money);
            dayBookBusinessman.setOrderId(orderId);
            dayBookBusinessman.setTradeTime(new Timestamp(System.currentTimeMillis()));
            dayBookBusinessmanService.save(dayBookBusinessman);
            businessman.setBusiBalance(businessman.getBusiBalance()-money);
            businessmanInfo.setBusiBalance(businessman.getBusiBalance());
            businessmanInfoService.save(businessman);


            List<OrderDetailed> orderDetailed=orderDetailedService.findAllByOrderId(orderId);
            List<BrandProduct> brandProducts=new ArrayList<BrandProduct>();
            List<CompanyInfo> companyInfos=new ArrayList<CompanyInfo>();
            for(int i=0;i<orderDetailed.size();i++){
               brandProducts.addAll(brandProductService.findBrandProductByProduct(orderDetailed.get(i).getProId()));
            }
            for(int i=0;i<brandProducts.size();i++){
                companyInfos.add(brandInfoService.getBrandInfoByBrandId(brandProducts.get(i).getBrandId()).getBrandOwner());
            }
            DayBookCompany dayBookCompany=new DayBookCompany();
            dayBookCompany.setCompany(companyInfos.get(0));
            dayBookCompany.setTradeTime(new Timestamp(System.currentTimeMillis()));
            dayBookCompany.setTradeAmounts(money);
            dayBookCompany.setOperationType("销售");
            dayBookCompany.setCheckStatus(1);
            dayBookCompany.setOrderId(orderId);
            dayBookCompanyService.save(dayBookCompany);
            CompanyInfo companyInfo=companyInfos.get(0);
            companyInfo.setComBalance(companyInfo.getComBalance()+money);
            companyInfoService.save(companyInfo);


            OrderInfo orderInfo=orderInfoService.findOrderInfoByOrderId(orderId);
            orderInfo.setOrderStatus(2);
            orderInfoService.save(orderInfo);
            return "redirect:/jnu/businessman/order";
        }
        else{
            return "BusinessmanOrderPayError";
        }

    }
}
