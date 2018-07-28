package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.*;
import com.jnu.dropshipplatform.service.BrandInfoService;
import com.jnu.dropshipplatform.service.BrandProductService;
import com.jnu.dropshipplatform.service.OrderDetailedService;
import com.jnu.dropshipplatform.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jnu/company/order")
public class OrderCompanyController {
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private BrandInfoService brandInfoService;
    @Autowired
    private BrandProductService brandProductService;
    @Autowired
    private OrderDetailedService orderDetailedService;
    @GetMapping
    public String show(HttpSession session, Model model){
        CompanyInfo companyInfo=(CompanyInfo)session.getAttribute("companyLoginInfo");
        List<BrandInfo> brandInfos=brandInfoService.findBrandInfoByBrandOwner(companyInfo);
        List<BrandProduct> brandProducts=new ArrayList<BrandProduct>();
        List<OrderDetailed> orderDetaileds=new ArrayList<OrderDetailed>();
        List<OrderInfo> orderInfosPre=new ArrayList<OrderInfo>();
        for(int i=0;i<brandInfos.size();i++){
            brandProducts.addAll(brandProductService.findBrandProductByBrandId(brandInfos.get(i).getBrandId()));
        }
        for(int i=0;i<brandProducts.size();i++){
            orderDetaileds.addAll(orderDetailedService.findAllByProId(brandProducts.get(i).getProductInfo()));
        }
        for(int i=0;i<orderDetaileds.size();i++){

            orderInfosPre.add(orderInfoService.findOrderInfoByOrderId(orderDetaileds.get(i).getOrderId()));
        }

        //遍历去重
        List<OrderInfo> orderInfos=new ArrayList<OrderInfo>();
        for(OrderInfo orderInfo:orderInfosPre){
            if(!orderInfos.contains(orderInfo)){
                orderInfos.add(orderInfo);
            }
        }

        List<OrderInfo> orderInfoUnpaid=new ArrayList<OrderInfo>();
        List<OrderInfo> orderInfoPaying=new ArrayList<OrderInfo>();
        List<OrderInfo> orderInfoShipping=new ArrayList<OrderInfo>();
        List<OrderInfo> orderInfoShipped=new ArrayList<OrderInfo>();
        List<OrderInfo> orderInfoCompleted=new ArrayList<OrderInfo>();
        List<OrderInfo> orderInfoCanceled=new ArrayList<OrderInfo>();
//0为消费未支付 1为消费者支付借卖方未支付 2为未发货 3为发货 4为已完成  -1为取消
        for(int i=0;i<orderInfos.size();i++){
            switch(orderInfos.get(i).getOrderStatus()){
                case 0:
                    orderInfoUnpaid.add(orderInfos.get(i));
                    break;
                case 1:
                    orderInfoPaying.add(orderInfos.get(i));
                    break;
                case 2:
                    orderInfoShipping.add(orderInfos.get(i));
                    break;
                case 3:
                    orderInfoShipped.add(orderInfos.get(i));
                    break;
                case 4:
                    orderInfoCompleted.add(orderInfos.get(i));
                    break;
                case -1:
                    orderInfoCanceled.add(orderInfos.get(i));
                    break;
            }

        }

        model.addAttribute("orderInfoUnpaid",orderInfoUnpaid);
        model.addAttribute("orderInfoPaying",orderInfoPaying);
        model.addAttribute("orderInfoShipping",orderInfoShipping);
        model.addAttribute("orderInfoShipped",orderInfoShipped);
        model.addAttribute("orderInfoCompleted",orderInfoCompleted);
        model.addAttribute("orderInfoCancelled",orderInfoCanceled);
        return "CompanyOrderShow";
    }

    @GetMapping("/detailed/{id}")
    public String showDetail(@PathVariable Integer id, Model model){
        List<OrderAndProduct> orderAndProducts=orderDetailedService.getOrderAndProductByOrderId(id);
        model.addAttribute("orderAndProducts",orderAndProducts);
        return "CompanyOrderDetail";
    }

    @GetMapping("/ship/{id}")
    public String jumpToShip(@PathVariable Integer id,Model model){
        model.addAttribute("orderId",id);
        return "CompanyOrderShip";
    }

    @PostMapping("/ship")
    public  String ship(@RequestParam Integer orderId, @RequestParam String trackingNo){
        OrderInfo orderInfo=orderInfoService.findOrderInfoByOrderId(orderId);
        orderInfo.setTrackingNo(trackingNo);
        orderInfo.setOrderStatus(3);
        orderInfoService.save(orderInfo);
        return "redirect:/jnu/company/order";
    }
}
