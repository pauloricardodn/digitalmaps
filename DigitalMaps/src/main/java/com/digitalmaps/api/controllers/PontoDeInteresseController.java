package com.digitalmaps.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalmaps.api.converters.PontoDeInteresseConverter;
import com.digitalmaps.api.services.PontoDeInteresseService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST PontoDeInteresse")
public class PontoDeInteresseController {

	private static final Logger log = LoggerFactory.getLogger(PontoDeInteresseController.class);
	
	@Autowired
	private PontoDeInteresseService pontoDeInteresseService;
	@Autowired
	private PontoDeInteresseConverter pontoDeInteresseConverter;
	
	public PontoDeInteresseController(){
		
	}
}
