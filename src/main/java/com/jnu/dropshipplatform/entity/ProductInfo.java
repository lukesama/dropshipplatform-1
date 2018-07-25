package com.jnu.dropshipplatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductInfo {

    @Id
    @GeneratedValue
    private Integer proId;
}
