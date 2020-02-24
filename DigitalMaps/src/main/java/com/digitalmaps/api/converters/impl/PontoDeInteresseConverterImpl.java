package com.digitalmaps.api.converters.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.digitalmaps.api.converters.PontoDeInteresseConverter;
import com.digitalmaps.api.dtos.PontoDeInteresseDto;
import com.digitalmaps.api.entities.PontoDeInteresse;

@Component()
public class PontoDeInteresseConverterImpl implements PontoDeInteresseConverter{

	public PontoDeInteresse ParseToEntity(PontoDeInteresseDto origin)
    {
        if (origin == null) return null;
        PontoDeInteresse pontoDeInteresse =  new PontoDeInteresse();
        pontoDeInteresse.setId(origin.getId());
        pontoDeInteresse.setNome(origin.getNome());
        pontoDeInteresse.setCoordenadaX(origin.getCoordenadaX());
        pontoDeInteresse.setCoordenadaY(origin.getCoordenadaY());
        pontoDeInteresse.setOpened(origin.getOpened());
        pontoDeInteresse.setClosed(origin.getClosed());
        pontoDeInteresse.setStatusFuncionamento(origin.getStatusFuncionamento());
        
        return pontoDeInteresse;
    }
	
	public PontoDeInteresseDto ParseToDto(PontoDeInteresse origin)
    {
        if (origin == null) return null;
        PontoDeInteresseDto pontoDeInteresseDto =  new PontoDeInteresseDto();
        pontoDeInteresseDto.setId(origin.getId());
        pontoDeInteresseDto.setNome(origin.getNome());
        pontoDeInteresseDto.setCoordenadaX(origin.getCoordenadaX());
        pontoDeInteresseDto.setCoordenadaY(origin.getCoordenadaY());
        pontoDeInteresseDto.setOpened(origin.getOpened());
        pontoDeInteresseDto.setClosed(origin.getClosed());
        pontoDeInteresseDto.setStatusFuncionamento(origin.getStatusFuncionamento());
        
        return pontoDeInteresseDto;
    }
	
	public List<PontoDeInteresse> ParseListToEntity(List<PontoDeInteresseDto> origin)
    {
        if (origin == null) return null;
        List<PontoDeInteresse> list = new ArrayList<PontoDeInteresse>();		
		origin.forEach(item -> list.add(ParseToEntity(item)));
		
		return list;
    }
	
	public List<PontoDeInteresseDto> ParseListToDto(List<PontoDeInteresse> origin)
    {
        if (origin == null) return null;
        List<PontoDeInteresseDto> list = new ArrayList<PontoDeInteresseDto>();  
        origin.forEach(item -> list.add(ParseToDto(item)));
        
		return list;
    }	
}
