package com.capitole.testjava.services;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.testjava.domains.Price;
import com.capitole.testjava.dtos.PriceDTO;
import com.capitole.testjava.exceptions.PriceNotFoundException;
import com.capitole.testjava.mappers.PriceMapper;
import com.capitole.testjava.repositories.PriceJPARepository;
import com.capitole.testjava.repositories.PriceQueryRepository;
import com.capitole.testjava.responses.PriceResponse;

@Service
public class PriceService {

    @Autowired
    private PriceQueryRepository repoQuery;
    @Autowired
    private PriceJPARepository repoJPA;

    public PriceResponse consultarPriceWithQueryBy(LocalDateTime fechaAplicacion, Integer productId, Integer brandId) {
	PriceResponse response = new PriceResponse();

	PriceDTO prices = repoQuery.consultarBy(fechaAplicacion, productId, brandId);

	response.setCodigo(0);
	response.setDescripcion("OK");
	response.setPrice(prices);

	return response;
    }

    public PriceResponse consultarPriceWithJPABy(LocalDateTime fechaAplicacion, Integer productId, Integer brandId) {
	Price price = repoJPA
		.findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			fechaAplicacion, fechaAplicacion, productId, brandId);

	if (Objects.isNull(price)) {
	    throw new PriceNotFoundException("Precio no encontrado.");
	}

	PriceResponse response = new PriceResponse();
	response.setCodigo(0);
	response.setDescripcion("OK");
	response.setPrice(PriceMapper.getPriceDTO(price));

	return response;
    }
}
