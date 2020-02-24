package com.digitalmaps.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * Retornar todos PontoDeInteresse.
	 * 
	 * @param PontoDeInteresse
	 * @return  @return ResponseEntity<Response<PontoDeInteresseDto>>
	 */	
	@ApiOperation(value="Retornar todos PontoDeInteresse")
	@GetMapping("/pontodeinteresse")
	public ResponseEntity<Response<List<PontoDeInteresseDto>>> listar() {		
		log.info("Listanto todos pontoDeInteresseDto");	
		Response<List<PontoDeInteresseDto>> response = new Response<List<PontoDeInteresseDto>>();	
		List<PontoDeInteresse> listEntity = this.pontoDeInteresseService.listar();
		response.setData(pontoDeInteresseConverter.ParseListToDto(listEntity));
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Retornar todos PontoDeInteresse abertos no perimetro.
	 * 
	 * @param PontoDeInteresse
	 * @return  @return ResponseEntity<Response<PontoDeInteresseDto>>
	 */	
	@ApiOperation(value="Retornar todos PontoDeInteresse  abertos no perimetro.")
	@GetMapping("/pontodeinteresse/listporperimetro/coordenadax/{x}/coordenaday/{y}/distancia/{mts}/horario/{hr}")
	public ResponseEntity<Response<List<PontoDeInteresseDto>>> listPorPerimetro(@PathVariable("x") int x, @PathVariable("y") int y, @PathVariable("mts") int mts, @PathVariable("hr") Time hr) {		
		log.info("Listanto todos pontoDeInteresseDto");	
		Response<List<PontoDeInteresseDto>> response = new Response<List<PontoDeInteresseDto>>();	
		List<PontoDeInteresse> listEntity = this.pontoDeInteresseService.listarPorPerimetro(x, y, mts, hr);
		response.setData(pontoDeInteresseConverter.ParseListToDto(listEntity));
		
		return ResponseEntity.ok(response);
	}
}
