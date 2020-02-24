package com.digitalmaps.api.services;

import java.sql.Time;
import java.util.List;

import com.digitalmaps.api.entities.PontoDeInteresse;

public interface PontoDeInteresseService {

	/**
	 * Persiste um PontoDeInteresse na base de dados.
	 * 
	 * @param PontoDeInteresse
	 * @return PontoDeInteresse
	 */
	PontoDeInteresse persistir(PontoDeInteresse pontoDeInteresse);	
	
	/**
	 * Retornar todos PontoDeInteresse.
	 * 
	 * @return PontoDeInteresse
	 */
	List<PontoDeInteresse> listar();
	
	/**
	 *Retornar todos PontoDeInteresse no perimetro.
	 * 
	 * @param PontoDeInteresse
	 * @return x, y, mts, hr
	 */
	List<PontoDeInteresse> listarPorPerimetro(int x, int y, int mts, Time hr);
}
