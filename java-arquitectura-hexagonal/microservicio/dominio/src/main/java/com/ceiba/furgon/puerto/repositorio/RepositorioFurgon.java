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
	 * Permite crear un furgon
	 * 
	 * @param furgon
	 * @return el id generado
	 */
	Long crear(Furgon furgon);

}
