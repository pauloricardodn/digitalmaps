package com.digitalmaps.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.digitalmaps.api.entities.PontoDeInteresse;
import com.digitalmaps.api.services.PontoDeInteresseService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PontoDeInteresseTestService {

	@Autowired
	private PontoDeInteresseService pontoDeInteresseService;
	
	@Test
	public void testPersistirLancamento() {
		PontoDeInteresse pontoDeInteresse = new PontoDeInteresse();
		pontoDeInteresse.setNome("Praça");
		pontoDeInteresse.setCoordenadaX(10);
		pontoDeInteresse.setCoordenadaY(10);
		PontoDeInteresse pontoDeInteresseRet = this.pontoDeInteresseService.persistir(pontoDeInteresse);

		assertTrue(pontoDeInteresseRet.getId() != 0);
	}
}
