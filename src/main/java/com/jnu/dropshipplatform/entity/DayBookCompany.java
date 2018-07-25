package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class DayBookCompany {

    @Id
    @GeneratedValue
    private Integer dayBookId;
    @ManyToOne
    private CompanyInfo company;
    private Double tradeAmounts;
    private Timestamp tradeTime;
    private String operationType;
    private Integer checkStatus;

    public DayBookCompany() {
    }

    public Integer getDayBookId() {
        return dayBookId;
    }

    public void setDayBookId(Integer dayBookId) {
        this.dayBookId = dayBookId;
    }

    public CompanyInfo getCompany() {
        return company;
    }

    public void setCompany(CompanyInfo company) {
        this.company = company;
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
