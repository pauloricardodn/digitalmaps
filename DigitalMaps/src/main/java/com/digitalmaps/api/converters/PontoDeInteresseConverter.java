package com.digitalmaps.api.converters;

import java.util.List;

import com.digitalmaps.api.dtos.PontoDeInteresseDto;
import com.digitalmaps.api.entities.PontoDeInteresse;

public interface PontoDeInteresseConverter {
	PontoDeInteresse ParseToEntity(PontoDeInteresseDto origin);
	PontoDeInteresseDto ParseToDto(PontoDeInteresse origin);
	List<PontoDeInteresse> ParseListToEntity(List<PontoDeInteresseDto> origin);
	List<PontoDeInteresseDto> ParseListToDto(List<PontoDeInteresse> origin);

}
