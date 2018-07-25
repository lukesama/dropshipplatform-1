package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class DayBookBusinessman {

    //借卖方流水表
    @Id
    @GeneratedValue
    private Integer dayBookId;
    @ManyToOne
    private BusinessmanInfo businessman;
    private Double tradeAmounts;
    private Timestamp tradeTime;
    private String operationType;
    private Integer checkStatus;

    public DayBookBusinessman() {
    }

    public Integer getDayBookId() {
        return dayBookId;
    }

    public void setDayBookId(Integer dayBookId) {
        this.dayBookId = dayBookId;
    }

    public BusinessmanInfo getBusinessman() {
        return businessman;
    }

    public void setBusinessman(BusinessmanInfo businessman) {
        this.businessman = businessman;
    }

    public Double getTradeAmounts() {
        return tradeAmounts;
    }

    public void setTradeAmounts(Double tradeAmounts) {
        this.tradeAmounts = tradeAmounts;
    }

    public Timestamp getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Timestamp tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }
}
