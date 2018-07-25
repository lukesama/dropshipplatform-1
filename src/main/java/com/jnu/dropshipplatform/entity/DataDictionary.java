package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataDictionary {
    @Id
    @GeneratedValue
    private Integer dataId;
    private Integer dataValue;
    private String dataMeaning;
    private String dataOperation;//数据项对应操作

    public DataDictionary() {
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getDataValue() {
        return dataValue;
    }

    public void setDataValue(Integer dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataMeaning() {
        return dataMeaning;
    }

    public void setDataMeaning(String dataMeaning) {
        this.dataMeaning = dataMeaning;
    }

    public String getDataOperation() {
        return dataOperation;
    }

    public void setDataOperation(String dataOperation) {
        this.dataOperation = dataOperation;
    }
}
