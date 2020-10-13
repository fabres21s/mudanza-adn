package com.ceiba.furgon.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.furgon.modelo.entidad.Furgon;
import com.ceiba.furgon.puerto.repositorio.RepositorioFurgon;

public class ServicioCrearFurgon {

	private static final String EL_FURGON_YA_EXISTE_EN_EL_SISTEMA = "La placa ingresada ya existe en el sistema";
	
	private final RepositorioFurgon repositorioFurgon;
	
	public ServicioCrearFurgon(RepositorioFurgon repositorioFurgon) {
		this.repositorioFurgon = repositorioFurgon;
	}
	
	public Long ejecutar(Furgon furgon) {
		validarExistenciaPrevia(furgon);
		return this.repositorioFurgon.crear(furgon);
	}

	private void validarExistenciaPrevia(Furgon furgon) {
		boolean existe = this.repositorioFurgon.existe(furgon.getPlaca());
		if (existe) {
			throw new ExcepcionDuplicidad(EL_FURGON_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
	
}
