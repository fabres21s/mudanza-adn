package com.ceiba.mudanza.servicio;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.dominio.excepcion.ExcepcionFurgonNoDisponible;
import com.ceiba.dominio.excepcion.ExcepcionFurgonNoExiste;
import com.ceiba.dominio.excepcion.ExcepcionTarifarioNoConfigurado;
import com.ceiba.furgon.puerto.repositorio.RepositorioFurgon;
import com.ceiba.mudanza.modelo.entidad.Mudanza;
import com.ceiba.mudanza.puerto.repositorio.RepositorioMudanza;
import com.ceiba.mudanza.utils.Utils;
import com.ceiba.tarifario.modelo.dto.DtoTarifario;

public class ServicioCrearMudanza {
	
	private static final String EL_FURGON_NO_ESTA_DISPONIBLE_PARA_ESA_FECHA = "El furgon no esta disponible para esa fecha";
	private static final String EL_FURGON_NO_EXISTE = "El furgon seleccionado no existe";
	private static final String EL_TARIFARIO_NO_SE_ENCUENTRA_CORRECTAMENTE_CONFIGURADO = "El tarifario no se encuentra correctamente configurado para esa fecha";
	
	private final RepositorioMudanza repositorioMudanza;
	private final RepositorioFurgon repositorioFurgon;
	private Utils utils;
	
	public ServicioCrearMudanza(RepositorioMudanza repositorioMudanza, RepositorioFurgon repositorioFurgon) {
		this.repositorioMudanza = repositorioMudanza;
		this.repositorioFurgon = repositorioFurgon;
		this.utils = new Utils();
	}
	
	public Long ejecutar(Mudanza mudanza) {
		validarExistenciaFurgon(mudanza.getFurgonId());
		consultarDisponibilidadFurgon(mudanza.getFurgonId(), mudanza.getFecha(), mudanza.getTarifaHorarioId());
		DtoTarifario tarifario =  consultarTarifario(mudanza.getFecha(), mudanza.getTarifaHorarioId());
		utils.asignarTarifas(mudanza, tarifario);
		
		return this.repositorioMudanza.crear(mudanza);
	}
	
	private void consultarDisponibilidadFurgon(Long furgonId, LocalDate fecha, Long tarifaHorarioId) {
		
		boolean ocupado = this.repositorioMudanza.consultarDisponibilidadFurgon(furgonId, fecha, tarifaHorarioId);
		
		if (ocupado) {
			throw new ExcepcionFurgonNoDisponible(EL_FURGON_NO_ESTA_DISPONIBLE_PARA_ESA_FECHA);
		}
	}
	
	private void validarExistenciaFurgon(Long furgonId) {
		boolean existe = this.repositorioFurgon.existe(furgonId);
		
		if (!existe) {
			throw new ExcepcionFurgonNoExiste(EL_FURGON_NO_EXISTE);
		}
	}
	
	private DtoTarifario consultarTarifario(LocalDate fecha, Long tarifaHorarioId) {
		List<DtoTarifario> list = this.repositorioMudanza.consultarTarifario(fecha, tarifaHorarioId);
		
		if (list.size() != 1) {
			throw new ExcepcionTarifarioNoConfigurado(EL_TARIFARIO_NO_SE_ENCUENTRA_CORRECTAMENTE_CONFIGURADO);
		}
		
		return list.get(0);
	}
	
	
	

}
