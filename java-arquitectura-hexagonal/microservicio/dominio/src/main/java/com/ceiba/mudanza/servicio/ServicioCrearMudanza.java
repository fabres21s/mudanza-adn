package com.ceiba.mudanza.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import com.ceiba.dominio.excepcion.ExcepcionFurgonNoDisponible;
import com.ceiba.dominio.excepcion.ExcepcionTarifarioNoConfigurado;
import com.ceiba.mudanza.modelo.entidad.Mudanza;
import com.ceiba.mudanza.puerto.repositorio.RepositorioMudanza;
import com.ceiba.tarifario.modelo.dto.DtoTarifario;

public class ServicioCrearMudanza {
	
	private static final String EL_FURGON_NO_ESTA_DISPONIBLE_PARA_ESA_FECHA = "El furgon no esta disponible para esa fecha";
	private static final String EL_TARIFARIO_NO_SE_ENCUENTRA_CORRECTAMENTE_CONFIGURADO = "El tarifario no se encuentra correctamente configurado para esa fecha";
	
	private final RepositorioMudanza repositorioMudanza;
	
	public ServicioCrearMudanza(RepositorioMudanza repositorioMudanza) {
		this.repositorioMudanza = repositorioMudanza;
	}
	
	public Long ejecutar(Mudanza mudanza) {
		
		//TODO - Preguntar si es necesario validar la existencia del furgon
		consultarDisponibilidadFurgon(mudanza.getFurgonId(), mudanza.getFecha(), mudanza.getTarifaHorarioId());
		DtoTarifario tarifario =  consultarTarifario(mudanza.getFecha(), mudanza.getTarifaHorarioId());
		asignarTarifas(mudanza, tarifario);
		
		return this.repositorioMudanza.crear(mudanza);
	}
	
	private void asignarTarifas(Mudanza mudanza, DtoTarifario tarifario) {
		asignarTarifaBase(mudanza, tarifario.getTarifaBase());
		asignarRecargoNocturno(mudanza, tarifario);
		asignarRecargoDominical(mudanza, tarifario);
		asignarRecargoFestivo(mudanza, tarifario);
	}

	private void asignarRecargoFestivo(Mudanza mudanza, DtoTarifario tarifario) {
		if (tarifario.getEsFestivo()) {
			mudanza.setRecargoFestivo(tarifario.getTarifaBase() * tarifario.getPorcentajeRecargoFestivo() / 100);
		} else {
			mudanza.setRecargoFestivo(0.0);
		}
		
	}

	private void asignarRecargoDominical(Mudanza mudanza, DtoTarifario tarifario) {
		if (mudanza.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY) {
			mudanza.setRecargoDominical(tarifario.getTarifaBase() * tarifario.getPorcentajeRecargoDominical() / 100);
		} else {
			mudanza.setRecargoDominical(0.0);
		}
		
 	}

	private void asignarRecargoNocturno(Mudanza mudanza, DtoTarifario tarifario) {
		if (tarifario.getRecargoNocturno()) {
			mudanza.setRecargoNocturno(tarifario.getTarifaBase() * tarifario.getPorcentajeRecargoNocturno() / 100);
		} else {
			mudanza.setRecargoNocturno(0.0);
		}
		
	}

	private void asignarTarifaBase(Mudanza mudanza, Double tarifaBase) {
		mudanza.setTarifaBase(tarifaBase);
	}

	private void consultarDisponibilidadFurgon(Long furgonId, LocalDate fecha, Long tarifaHorarioId) {
		
		System.out.println(furgonId+ ":: "+fecha+" :: "+tarifaHorarioId);
		boolean ocupado = this.repositorioMudanza.consultarDisponibilidadFurgon(furgonId, fecha, tarifaHorarioId);
		
		if (ocupado) {
			throw new ExcepcionFurgonNoDisponible(EL_FURGON_NO_ESTA_DISPONIBLE_PARA_ESA_FECHA);
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
