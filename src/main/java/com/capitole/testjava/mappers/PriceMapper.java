package com.capitole.testjava.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capitole.testjava.domains.Price;
import com.capitole.testjava.dtos.PriceDTO;

public class PriceMapper implements RowMapper<PriceDTO> {

    @Override
    public PriceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	PriceDTO resultado = new PriceDTO();

	resultado.setId(Integer.parseInt(rs.getObject("id").toString()));
	resultado.setBrandId(Integer.parseInt(rs.getObject("brandId").toString()));
	resultado.setStartDate(rs.getTimestamp(("startDate")).toLocalDateTime());
	resultado.setEndDate(rs.getTimestamp(("endDate")).toLocalDateTime());
	resultado.setPriceList(Integer.parseInt(rs.getObject("priceList").toString()));
	resultado.setProductId(Integer.parseInt(rs.getObject("productId").toString()));
	resultado.setPriority(Integer.parseInt(rs.getObject("priority").toString()));
	resultado.setPrice(Float.parseFloat(rs.getObject("price").toString()));
	resultado.setCurr(rs.getObject("curr").toString());

	return resultado;
    }

    public static PriceDTO getPriceDTO(Price price) {
	PriceDTO resultado = new PriceDTO();

	resultado.setId(price.getId());
	resultado.setBrandId(price.getBrandId());
	resultado.setStartDate(price.getStartDate());
	resultado.setEndDate(price.getEndDate());
	resultado.setPriceList(price.getPriceList());
	resultado.setProductId(price.getProductId());
	resultado.setPriority(price.getPriority());
	resultado.setPrice(price.getPrice());
	resultado.setCurr(price.getCurr());

	return resultado;
    }
}
