package com.ceiba.mudanza.puerto.repositorio;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.mudanza.modelo.entidad.Mudanza;
import com.ceiba.tarifario.modelo.dto.DtoTarifario;

public interface RepositorioMudanza {

	
	Long crear(Mudanza mudanza);

	boolean consultarDisponibilidadFurgon(Long furgonId, LocalDate fecha, Long tarifaHorarioId);

	List<DtoTarifario> consultarTarifario(LocalDate fecha, Long tarifaHorarioId);
}
