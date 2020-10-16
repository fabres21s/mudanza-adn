package com.ceiba.furgon.adaptador.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.furgon.modelo.dto.DtoFurgon;
import com.ceiba.furgon.puerto.dao.DaoFurgon;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoFurgonMysql implements DaoFurgon{
	
	 private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	    @SqlStatement(namespace="furgon", value="listar")
	    private static String sqlListar;
	    
	    @SqlStatement(namespace="furgon", value="listarDisponibles")
	    private static String listarDisponibles;

	    public DaoFurgonMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
	        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	    }

	@Override
	public List<DtoFurgon> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoFurgon());
	}

	@Override
	public List<DtoFurgon> consultarDisponibles(Long tarifaHorarioId, LocalDate fecha) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fecha", fecha);
		paramSource.addValue("tarifaHorarioId", tarifaHorarioId);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(listarDisponibles, paramSource, new MapeoFurgon());
	}

	
}
