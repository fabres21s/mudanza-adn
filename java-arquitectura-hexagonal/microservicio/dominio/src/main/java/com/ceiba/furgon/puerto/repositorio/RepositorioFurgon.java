package com.ceiba.furgon.puerto.repositorio;

import com.ceiba.furgon.modelo.entidad.Furgon;

public interface RepositorioFurgon {

	/**
	 * Permite validar si existe un furgon con una placa
	 * 
	 * @param placa
	 * @return si existe o no
	 */
	boolean existe(String placa);

	/**
	 * Permite validar si existe un furgon con una placa excluyendo un id
	 * 
	 * @param placa
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String placa);

	/**
	 * Permite crear un furgon
	 * 
	 * @param furgon
	 * @return el id generado
	 */
	Long crear(Furgon furgon);

	/**
	 * Permite actualizar un furgon
	 * 
	 * @param usuario
	 */
	void actualizar(Furgon furgon);

	boolean existe(Long furgonId);

}
