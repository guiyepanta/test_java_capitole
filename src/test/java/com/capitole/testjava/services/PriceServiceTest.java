package com.capitole.testjava.services;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capitole.testjava.domains.Price;
import com.capitole.testjava.exceptions.PriceNotFoundException;
import com.capitole.testjava.repositories.PriceJPARepository;
import com.capitole.testjava.repositories.PriceQueryRepository;
import com.capitole.testjava.responses.PriceResponse;
import com.capitole.testjava.utils.DateUtil;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @Mock
    PriceQueryRepository queryRepository;
    @Mock
    PriceJPARepository jpaRepository;

    @InjectMocks
    PriceService service;

    @Test
    @DisplayName("Caso 01: Test consulta con JPA response 200")
    public void consultaJPAtest01() throws Exception {
	// GIVEN
	Price priceMock = new Price();
	priceMock.setBrandId(1);
	priceMock.setStartDate(DateUtil.getDateFromString("2020-06-14 00:00:00"));
	priceMock.setEndDate(DateUtil.getDateFromString("2020-12-31 23:59:59"));
	priceMock.setPriceList(1);
	priceMock.setProductId(35455);
	priceMock.setPriority(0);
	priceMock.setPrice(Float.valueOf("35.50"));
	priceMock.setCurr("EUR");

	// WHEN
	Date fechaAplicacion = DateUtil.getDateFromString("2020-06-14 10:00:00");
	Integer productoId = 35455;
	Integer brandId = 1;

	when(jpaRepository
		.findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			fechaAplicacion, fechaAplicacion, productoId, brandId)).thenReturn(priceMock);

	PriceResponse response = service.consultarPriceWithJPABy(fechaAplicacion, productoId, brandId);

	// THEN
	Assertions.assertEquals(1, response.getPrice().getPriceList());
	Assertions.assertEquals(Float.valueOf("35.50"), response.getPrice().getPrice());

    }

    @Test
    @DisplayName("Caso 02: Test consulta con JPA response 200")
    public void consultaJPAtest02() throws Exception {
	// GIVEN
	Price priceMock = new Price();
	priceMock.setBrandId(1);
	priceMock.setStartDate(DateUtil.getDateFromString("2020-06-14 15:00:00"));
	priceMock.setEndDate(DateUtil.getDateFromString("2020-06-14 18:30:00"));
	priceMock.setPriceList(2);
	priceMock.setProductId(35455);
	priceMock.setPriority(0);
	priceMock.setPrice(Float.valueOf("25.45"));
	priceMock.setCurr("EUR");

	// WHEN
	Date fechaAplicacion = DateUtil.getDateFromString("2020-06-14 16:00:00");
	Integer productoId = 35455;
	Integer brandId = 1;

	when(jpaRepository
		.findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			fechaAplicacion, fechaAplicacion, productoId, brandId)).thenReturn(priceMock);

	PriceResponse response = service.consultarPriceWithJPABy(fechaAplicacion, productoId, brandId);

	// THEN
	Assertions.assertEquals(2, response.getPrice().getPriceList());
	Assertions.assertEquals(Float.valueOf("25.45"), response.getPrice().getPrice());
    }

    @Test
    @DisplayName("Caso 03: Test consulta con JPA response 200")
    public void consultaJPAtest03() throws Exception {
	// GIVEN
	Price priceMock = new Price();
	priceMock.setBrandId(1);
	priceMock.setStartDate(DateUtil.getDateFromString("2020-06-14 00:00:00"));
	priceMock.setEndDate(DateUtil.getDateFromString("2020-12-31 23:59:59"));
	priceMock.setPriceList(1);
	priceMock.setProductId(35455);
	priceMock.setPriority(0);
	priceMock.setPrice(Float.valueOf("35.50"));
	priceMock.setCurr("EUR");

	// WHEN
	Date fechaAplicacion = DateUtil.getDateFromString("2020-06-14 21:00:00");
	Integer productoId = 35455;
	Integer brandId = 1;
	when(jpaRepository
		.findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			fechaAplicacion, fechaAplicacion, productoId, brandId)).thenReturn(priceMock);

	PriceResponse response = service.consultarPriceWithJPABy(fechaAplicacion, productoId, brandId);

	// THEN
	Assertions.assertEquals(1, response.getPrice().getPriceList());
	Assertions.assertEquals(Float.valueOf("35.50"), response.getPrice().getPrice());

    }

    @Test
    @DisplayName("Caso 04: Test consulta con JPA response 200")
    public void consultaJPAtest04() throws Exception {
	// GIVEN
	Price priceMock = new Price();
	priceMock.setBrandId(1);
	priceMock.setStartDate(DateUtil.getDateFromString("2020-06-15 00:00:00"));
	priceMock.setEndDate(DateUtil.getDateFromString("2020-06-15 11:00:00"));
	priceMock.setPriceList(3);
	priceMock.setProductId(35455);
	priceMock.setPriority(0);
	priceMock.setPrice(Float.valueOf("30.50"));
	priceMock.setCurr("EUR");

	// WHEN
	Date fechaAplicacion = DateUtil.getDateFromString("2020-06-15 10:00:00");
	Integer productoId = 35455;
	Integer brandId = 1;
	when(jpaRepository
		.findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			fechaAplicacion, fechaAplicacion, productoId, brandId)).thenReturn(priceMock);

	PriceResponse response = service.consultarPriceWithJPABy(fechaAplicacion, productoId, brandId);

	// THEN
	Assertions.assertEquals(3, response.getPrice().getPriceList());
	Assertions.assertEquals(Float.valueOf("30.50"), response.getPrice().getPrice());
    }

    @Test
    @DisplayName("Caso 05: Test consulta con JPA response 200")
    public void consultaJPAtest05() throws Exception {
	// GIVEN
	Price priceMock = new Price();
	priceMock.setBrandId(1);
	priceMock.setStartDate(DateUtil.getDateFromString("2020-06-15 16:00:00"));
	priceMock.setEndDate(DateUtil.getDateFromString("2020-12-31 23:59:59"));
	priceMock.setPriceList(4);
	priceMock.setProductId(35455);
	priceMock.setPriority(0);
	priceMock.setPrice(Float.valueOf("38.95"));
	priceMock.setCurr("EUR");

	// WHEN
	Date fechaAplicacion = DateUtil.getDateFromString("2020-06-16 21:00:00");
	Integer productoId = 35455;
	Integer brandId = 1;
	when(jpaRepository
		.findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			fechaAplicacion, fechaAplicacion, productoId, brandId)).thenReturn(priceMock);

	PriceResponse response = service.consultarPriceWithJPABy(fechaAplicacion, productoId, brandId);

	// THEN
	Assertions.assertEquals(4, response.getPrice().getPriceList());
	Assertions.assertEquals(Float.valueOf("38.95"), response.getPrice().getPrice());
    }

    @Test
    @DisplayName("Caso 06: Test consulta con JPA response 404 - Price inexistente")
    public void consultaJPAtestIsError404() throws Exception {
	// GIVEN
	Price priceMock = null;

	// WHEN
	Date fechaAplicacion = DateUtil.getDateFromString("2020-06-14 21:00:00");
	Integer productoId = 11111;
	Integer brandId = 1;

	when(jpaRepository
		.findTopByEndDateGreaterThanEqualAndStartDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			fechaAplicacion, fechaAplicacion, productoId, brandId)).thenReturn(priceMock);

	PriceNotFoundException exception = Assertions.assertThrows(PriceNotFoundException.class, () -> {
	    service.consultarPriceWithJPABy(fechaAplicacion, productoId, brandId);
	});

	// THEN
	Assertions.assertEquals("Precio no encontrado.", exception.getMessage());
    }

}
