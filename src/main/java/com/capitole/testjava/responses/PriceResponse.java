package com.capitole.testjava.responses;

import java.io.Serializable;

import com.capitole.testjava.dtos.PriceDTO;

public class PriceResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private String descripcion;
    private PriceDTO prices;

    public Integer getCodigo() {
	return codigo;
    }

    public void setCodigo(Integer codigo) {
	this.codigo = codigo;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public PriceDTO getPrice() {
	return prices;
    }

    public void setPrice(PriceDTO price) {
	this.prices = price;
    }

}
