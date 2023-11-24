package com.capitole.testjava.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capitole.testjava.domains.Price;

public interface PriceJPARepository extends JpaRepository<Price, Integer> {

    Price findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
	    LocalDateTime endDate, LocalDateTime starDate, Integer productId, Integer brandId);

}
