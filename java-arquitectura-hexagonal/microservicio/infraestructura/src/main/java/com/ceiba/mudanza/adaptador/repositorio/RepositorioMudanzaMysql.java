package com.ceiba.mudanza.adaptador.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.mudanza.modelo.entidad.Mudanza;
import com.ceiba.mudanza.puerto.repositorio.RepositorioMudanza;
import com.ceiba.tarifario.modelo.dto.DtoTarifario;

@Repository
public class RepositorioMudanzaMysql implements RepositorioMudanza{

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	public RepositorioMudanzaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}
	
	@SqlStatement(namespace = "mudanza", value = "crear")
	private static String sqlCrear;
	
	@SqlStatement(namespace = "mudanza", value = "disponibilidadFurgon")
	private static String sqlDisponibilidadFurgon;
	
	@SqlStatement(namespace = "mudanza", value = "consultarTarifario")
	private static String consultarTarifario;
	
	@Override
	public Long crear(Mudanza mudanza) {
		return this.customNamedParameterJdbcTemplate.crear(mudanza, sqlCrear);
	}

	@Override
	public boolean consultarDisponibilidadFurgon(Long furgonId, LocalDate fecha, Long tarifaHorarioId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fecha", fecha);
		paramSource.addValue("tarifaHorarioId", tarifaHorarioId);
		paramSource.addValue("furgonId", furgonId);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlDisponibilidadFurgon,
				paramSource, Boolean.class);
	}

	@Override
	public List<DtoTarifario> consultarTarifario(LocalDate fecha, Long tarifaHorarioId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fecha", fecha);
		paramSource.addValue("tarifaHorarioId", tarifaHorarioId);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(consultarTarifario, paramSource, new MapeoTarifario());
	}

}
