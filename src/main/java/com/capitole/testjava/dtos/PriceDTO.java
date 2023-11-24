package com.capitole.testjava.dtos;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PriceDTO implements Serializable {

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

}
