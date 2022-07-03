package com.capitole.testjava.repositories;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capitole.testjava.dtos.PriceDTO;
import com.capitole.testjava.exceptions.PriceNotFoundException;
import com.capitole.testjava.mappers.PriceMapper;

@Repository
public class PriceQueryRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SENTENCIA_SQL = "SELECT "
    						+ "TOP 1 "
    						+ "id, "
    						+ "brand_id as brandId, "
    						+ "product_id as productId, "
    						+ "start_date as startDate, "
    						+ "end_date as endDate, "
    						+ "price, "
    						+ "price_list as priceList, "
    						+ "priority, "
    						+ "curr "
    						+ "FROM prices "
    						+ "WHERE start_date <= :fechaAplicacion "
    						+ "AND end_date >= :fechaAplicacion "
    						+ "AND product_id = :productId "
    						+ "AND brand_id = :brandId "
    						+ "ORDER BY priority DESC";

    public PriceDTO consultarBy(Date fechaAplicacion, Integer productId, Integer brandId) {

	Map<String, Object> sqlParameterSource = new HashMap<String, Object>();
	sqlParameterSource.put("fechaAplicacion", fechaAplicacion);
	sqlParameterSource.put("productId", productId);
	sqlParameterSource.put("brandId", brandId);

	List<PriceDTO> resultado = namedParameterJdbcTemplate.query(SENTENCIA_SQL, sqlParameterSource,
		new PriceMapper());

	if (resultado != null && resultado.size() > 0) {
	    return resultado.get(0);
	}

	throw new PriceNotFoundException("Precio no encontrado.");
    }
}
