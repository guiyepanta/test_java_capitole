package com.capitole.testjava.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capitole.testjava.domains.Price;

public interface PriceJPARepository extends JpaRepository<Price, Integer> {

    Price findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
	    Date endDate, Date starDate, Integer productId, Integer brandId);

}
