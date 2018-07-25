package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parameter {
    @Id
    @GeneratedValue
    private Integer paraId;
    private String paraName;
    private Integer paraValue;

    public Parameter() {
    }

    public Integer getParaId() {
        return paraId;
    }

    public void setParaId(Integer paraId) {
        this.paraId = paraId;
    }

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    public Integer getParaValue() {
        return paraValue;
    }

    public void setParaValue(Integer paraValue) {
        this.paraValue = paraValue;
    }
}
