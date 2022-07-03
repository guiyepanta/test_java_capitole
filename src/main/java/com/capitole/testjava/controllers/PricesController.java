package com.capitole.testjava.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.testjava.exceptions.PriceNotFoundException;
import com.capitole.testjava.responses.PriceResponse;
import com.capitole.testjava.services.PriceService;

@RestController
@RequestMapping("api/v1/prices")
public class PricesController {

    @Autowired
    private PriceService service;

    @GetMapping("hello")
    public String hello() {
	return "Hola mundo!";
    }

    @GetMapping("consultaQuery/{fechaAplicacion}/{productoId}/{brandId}")
    public ResponseEntity<PriceResponse> consultaPrecioQuery(
	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd HH:mm:ss") Date fechaAplicacion,
	    @PathVariable Integer productoId, @PathVariable Integer brandId) {

	try {

	    PriceResponse response = service.consultarPriceWithQueryBy(fechaAplicacion, productoId, brandId);
	    return new ResponseEntity<>(response, HttpStatus.OK);

	} catch (PriceNotFoundException nfe) {
	    return ResponseEntity.notFound().build();
	}
    }

    @GetMapping("consultaJPA/{fechaAplicacion}/{productoId}/{brandId}")
    public ResponseEntity<PriceResponse> consultaPrecioJPA(
	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd HH:mm:ss") Date fechaAplicacion,
	    @PathVariable Integer productoId, @PathVariable Integer brandId) {

	try {

	    PriceResponse response = service.consultarPriceWithJPABy(fechaAplicacion, productoId, brandId);
	    return new ResponseEntity<>(response, HttpStatus.OK);

	} catch (PriceNotFoundException nfe) {
	    return ResponseEntity.notFound().build();
	}
    }
}
