package com.digitalmaps.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.digitalmaps.api.controllers.PontoDeInteresseController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PontoDeInteresseTestController {
	
	private static final String URL_BASE = "/api/pontodeinteresse";
	int x = 20;
	int y = 10;
	int mts = 30;
	String hr = "07:00:00";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PontoDeInteresseController pontoDeInteresseController;

//	@Before(value = "")
//	public void setUp() {
//		this.mockMvc = MockMvcBuilders.standaloneSetup(pontoDeInteresseController).build();
//	}
	
	@Test
	public void testCadastrarSemHorario() throws Exception {

		JSONObject json = new JSONObject();
		json.put("id", 1);
		json.put("nome", "Praça");
		json.put("coordenadaX", 20);
		json.put("coordenadaY", 10);
		
		mockMvc.perform(MockMvcRequestBuilders.post(URL_BASE)
				.content(json.toString())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.errors").isEmpty());
	}
	
	@Test
	public void testCadastrarComHorario() throws Exception {

		JSONObject json = new JSONObject();
		json.put("id", 0);
		json.put("nome", "Restautante A");
		json.put("coordenadaX", 20);
		json.put("coordenadaY", 10);
		json.put("opened", "07:00:00");
		json.put("closed", "18:00:00");
		
		mockMvc.perform(MockMvcRequestBuilders.post(URL_BASE)
				.content(json.toString())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.errors").isEmpty());
	}
	
	@Test
	public void testCadastrarComCordenaXNegativa() throws Exception {

		JSONObject json = new JSONObject();
		json.put("id", 1);
		json.put("nome", "Restautante A");
		json.put("cordenadaX", -20);
		json.put("cordenadaY", 10);
		json.put("opened", "07:00:00");
		json.put("closed", "18:00:00");
		
		mockMvc.perform(MockMvcRequestBuilders.post(URL_BASE)
				.content(json.toString())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Cordenada x não pode ser negativa."))
				.andExpect(jsonPath("$.data").isEmpty());
	}
	
	@Test
	public void testCadastrarComCordenaYNegativa() throws Exception {

		JSONObject json = new JSONObject();
		json.put("nome", "Restautante A");
		json.put("cordenadaX", 20);
		json.put("cordenadaY", -10);
		json.put("opened", "07:00:00");
		json.put("closed", "18:00:00");
		
		mockMvc.perform(MockMvcRequestBuilders.post(URL_BASE)
				.content(json.toString())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Cordenada y não pode ser negativa."))
				.andExpect(jsonPath("$.data").isEmpty());
	}
	
	@Test
	public void testListar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URL_BASE)				
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void listPorPerimetro() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/pontodeinteresse/listporperimetro/coordenadax/5/coordenaday/12/distancia/10/horario/20:00:00")		
				
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void listPorPerimetroFaltandoParametro() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(URL_BASE+"/listporperimetro/coordenadax/5/coordenaday/12/distancia/10")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
}
