package com.capitole.testjava;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capitole.testjava.responses.PriceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@SpringBootTest
class TestJavaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private WebApplicationContext webAppConfiguration;

    private MockMvc mockMvc;

    @BeforeEach
    private void setup() throws Exception {
	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webAppConfiguration).build();
    }

    @Test
    @DisplayName("Caso 01: Test consulta con JPA response 200")
    public void consultaJPAtest01() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-14 10:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaJPA/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(1, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 02: Test consulta con JPA response 200")
    public void consultaJPAtest02() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-14 16:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaJPA/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(2, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 03: Test consulta con JPA response 200")
    public void consultaJPAtest03() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-14 21:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaJPA/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(1, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 04: Test consulta con JPA response 200")
    public void consultaJPAtest04() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-15 10:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaJPA/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(3, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 05: Test consulta con JPA response 200")
    public void consultaJPAtest05() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-16 21:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaJPA/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(4, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 06: Test consulta con JPA response 404 - Price inexistente")
    public void consultaJPAtestIsError404() throws Exception {
	String fechaAplicacion = "2020-06-16 21:00:00";
	Integer productoId = 11111;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaJPA/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().is4xxClientError()).andReturn();

	Assertions.assertEquals(404, mvcResult.getResponse().getStatus());
    }

    // ----------- TEST USANDO QUERY -----------------
    // -----------------------------------------------

    @Test
    @DisplayName("Caso 01: Test consulta con Query response 200")
    public void consultaQuerytest01() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-14 10:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaQuery/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(1, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 02: Test consulta con Query response 200")
    public void consultaQuerytest02() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-14 16:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaQuery/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(2, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 03: Test consulta con Query response 200")
    public void consultaQuerytest03() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-14 21:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaQuery/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(1, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 04: Test consulta con Query response 200")
    public void consultaQuerytest04() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-15 10:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaQuery/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(3, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 05: Test consulta con Query response 200")
    public void consultaQuerytest05() throws Exception {
	ObjectMapper mapper = new ObjectMapper();
	String fechaAplicacion = "2020-06-16 21:00:00";
	Integer productoId = 35455;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaQuery/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().isOk()).andReturn();

	PriceResponse priceResponse = mapper.readValue(mvcResult.getResponse().getContentAsString(),
		PriceResponse.class);

	Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
	Assertions.assertEquals(4, priceResponse.getPrice().getPriceList());

    }

    @Test
    @DisplayName("Caso 06: Test consulta con Query response 404 - Price inexistente")
    public void consultaQuerytestIsError404() throws Exception {
	String fechaAplicacion = "2020-06-16 21:00:00";
	Integer productoId = 11111;
	Integer brandId = 1;

	MvcResult mvcResult = this.mockMvc
		.perform(get("/api/v1/prices/consultaQuery/{fechaAplicacion}/{productoId}/{brandId}", fechaAplicacion,
			productoId, brandId))
		.andExpect(status().is4xxClientError()).andReturn();

	Assertions.assertEquals(404, mvcResult.getResponse().getStatus());
    }

}
