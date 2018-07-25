package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderDetailed {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer orderId; //外键
    private Integer proId;   //外键

    private Double sellPrice; //商品销售价格
    private Integer proSales; //商品销量
    private String proModel; //商品型号




    public OrderDetailed() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }



    public Integer getProSales() {
        return proSales;
    }

    public void setProSales(Integer proSales) {
        this.proSales = proSales;
    }

    public String getProModel() {
        return proModel;
    }

    public void setProModel(String proModel) {
        this.proModel = proModel;
    }
}
