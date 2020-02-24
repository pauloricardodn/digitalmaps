package com.digitalmaps.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalmaps.api.entities.PontoDeInteresse;
import com.digitalmaps.api.repositories.PontoDeInteresseRepository;
import com.digitalmaps.api.services.PontoDeInteresseService;

@Service
public class PontoDeInteresseServiceImpl implements PontoDeInteresseService {

	private static final Logger log = LoggerFactory.getLogger(PontoDeInteresseServiceImpl.class);
	
	@Autowired
	private PontoDeInteresseRepository pontoDeInteresseRepository;
	
	public PontoDeInteresse persistir(PontoDeInteresse pontoDeInteresse) {
		log.info("Persistindo pontoDeInteresse: {}", pontoDeInteresse);
		return this.pontoDeInteresseRepository.save(pontoDeInteresse);
	}

}
