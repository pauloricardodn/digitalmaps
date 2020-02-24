package com.digitalmaps.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.digitalmaps.api.entities.PontoDeInteresse;
import com.digitalmaps.api.repositories.PontoDeInteresseRepository;
import com.digitalmaps.api.services.PontoDeInteresseService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PontoDeInteresseTestService {

	@MockBean
	private PontoDeInteresseRepository pontoDeInteresseRepository;
	
	@Autowired
	private PontoDeInteresseService pontoDeInteresseService;
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.pontoDeInteresseRepository.save(Mockito.any(PontoDeInteresse.class))).willReturn(new PontoDeInteresse());
		BDDMockito.given(this.pontoDeInteresseRepository.findAll(Mockito.any(PageRequest.class)))
		.willReturn(new PageImpl<PontoDeInteresse>(new ArrayList<PontoDeInteresse>()));
		
	}
	
	@Test
	public void testPersistirLancamento() {

		PontoDeInteresse pontoDeInteresse = this.pontoDeInteresseService.persistir(new PontoDeInteresse());

		assertNotNull(pontoDeInteresse);
	}
	
	@Test
	public void testListar() {
	
		List<PontoDeInteresse> lancamento = this.pontoDeInteresseService.listar();

		assertNotNull(lancamento);	
	}
}
