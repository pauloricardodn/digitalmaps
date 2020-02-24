package com.digitalmaps.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalmaps.api.converters.PontoDeInteresseConverter;
import com.digitalmaps.api.dtos.PontoDeInteresseDto;
import com.digitalmaps.api.entities.PontoDeInteresse;
import com.digitalmaps.api.response.Response;
import com.digitalmaps.api.services.PontoDeInteresseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	
	/**
	 * Persiste um PontoDeInteresse na base de dados.
	 * 
	 * @param PontoDeInteresse
	 * @return  @return ResponseEntity<Response<PontoDeInteresseDto>>
	 */	
	@ApiOperation(value="Persistir um PontoDeInteresse")
	@PostMapping("/pontodeinteresse")
	public ResponseEntity<Response<PontoDeInteresseDto>> persistir(@Valid @RequestBody PontoDeInteresseDto pontoDeInteresseDto,
			BindingResult result) throws ParseException, NoSuchAlgorithmException {
		
		log.info("Cadastrando pontoDeInteresseDto: {}", pontoDeInteresseDto.toString());
		Response<PontoDeInteresseDto> response = new Response<PontoDeInteresseDto>();

		PontoDeInteresse pontoDeInteresse = pontoDeInteresseConverter.ParseToEntity(pontoDeInteresseDto);		
		
		if (result.hasErrors()) {
			log.error("Erro validando dados de cadastro PF: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		this.pontoDeInteresseService.persistir(pontoDeInteresse);

		response.setData(pontoDeInteresseConverter.ParseToDto(pontoDeInteresse));
		return ResponseEntity.ok(response);
	}
}
