package com.capitole.testjava.controllers;

import java.util.Date;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.testjava.exceptions.PriceNotFoundException;
import com.capitole.testjava.responses.PriceResponse;
import com.capitole.testjava.services.PriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("api/v1/prices")
@Api(value = "Test Java - PRICE", description = "Se exponen recursos para obtener información de precios según fecha, producto y tienda.")
public class PricesController {

    @Autowired
    private PriceService service;

    @ApiOperation(value = "Retorna valores de precios utilizando JDBC para obtener los datos de la DB.")
    @GetMapping("consultaQuery/{fechaAplicacion}/{productoId}/{brandId}")
    public ResponseEntity<PriceResponse> consultaPrecioQuery(
	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd HH:mm:ss") Date fechaAplicacion,
	    @PathVariable @Min(0) Integer productoId, @PathVariable @Min(0) Integer brandId) {

	try {

	    PriceResponse response = service.consultarPriceWithQueryBy(fechaAplicacion, productoId, brandId);
	    return new ResponseEntity<>(response, HttpStatus.OK);

	} catch (PriceNotFoundException nfe) {
	    return ResponseEntity.notFound().build();
	} catch (Exception e) {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
    }

    @ApiOperation(value = "Retorna valores de precios utilizando JPA para obtener los datos de la DB.")
    @GetMapping("consultaJPA/{fechaAplicacion}/{productoId}/{brandId}")
    public ResponseEntity<PriceResponse> consultaPrecioJPA(
	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd HH:mm:ss") Date fechaAplicacion,
	    @PathVariable @Min(0) Integer productoId, @PathVariable @Min(0) Integer brandId) {

	try {

	    PriceResponse response = service.consultarPriceWithJPABy(fechaAplicacion, productoId, brandId);
	    return new ResponseEntity<>(response, HttpStatus.OK);

	} catch (PriceNotFoundException nfe) {
	    return ResponseEntity.notFound().build();
	} catch (Exception e) {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
    }
}
