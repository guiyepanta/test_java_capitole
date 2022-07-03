package com.capitole.testjava.dtos;

import java.io.Serializable;
import java.util.Date;

public class PriceDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer brandId;
    private Date startDate;
    private Date endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private Float price;
    private String curr;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getBrandId() {
	return brandId;
    }

    public void setBrandId(Integer brandId) {
	this.brandId = brandId;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public Integer getPriceList() {
	return priceList;
    }

    public void setPriceList(Integer priceList) {
	this.priceList = priceList;
    }

    public Integer getProductId() {
	return productId;
    }

    public void setProductId(Integer productId) {
	this.productId = productId;
    }

    public Integer getPriority() {
	return priority;
    }

    public void setPriority(Integer priority) {
	this.priority = priority;
    }

    public Float getPrice() {
	return price;
    }

    public void setPrice(Float price) {
	this.price = price;
    }

    public String getCurr() {
	return curr;
    }

    public void setCurr(String curr) {
	this.curr = curr;
    }
}
