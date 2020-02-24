package com.digitalmaps.api.services.impl;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<PontoDeInteresse> listar() {
		log.info("Listando todos pontoDeInteresse");
		return this.pontoDeInteresseRepository.findAll();
	}
	
	public List<PontoDeInteresse> listarPorPerimetro(int x, int y, int mts, Time hr) {
		List<PontoDeInteresse> list = this.pontoDeInteresseRepository.findAll();
		List<PontoDeInteresse> listPerimetro = list.stream().filter(item -> 
				distacia(item.getCoordenadaX(), item.getCoordenadaY(), x, y) <= mts).collect(Collectors.toList());	
		
		for(PontoDeInteresse item: listPerimetro) {			
			if(item.getOpened() == null)  
				item.setStatusFuncionamento("aberto");
			else if ((item.getOpened().getTime() <= hr.getTime()) & (item.getClosed().getTime() > hr.getTime()))
					item.setStatusFuncionamento("aberto");	
			else
				item.setStatusFuncionamento("fechado");			
		};
		
		return listPerimetro;
	}

	private Double distacia(int piCordenadaX, int piCordenadaY, int x, int  y) {
		return Math.sqrt(Math.pow(piCordenadaX- x, 2) + Math.pow(piCordenadaY - y, 2));
	}
}
