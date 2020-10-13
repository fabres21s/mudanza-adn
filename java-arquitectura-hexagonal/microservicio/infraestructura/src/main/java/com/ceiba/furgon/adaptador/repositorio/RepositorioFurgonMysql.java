package com.ceiba.furgon.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.furgon.modelo.entidad.Furgon;
import com.ceiba.furgon.puerto.repositorio.RepositorioFurgon;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioFurgonMysql implements RepositorioFurgon {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "furgon", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "furgon", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "furgon", value = "existe")
	private static String sqlExiste;

	@SqlStatement(namespace = "furgon", value = "existeExcluyendoId")
	private static String sqlExisteExcluyendoId;

	public RepositorioFurgonMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public boolean existe(String placa) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("placa", placa);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

	@Override
	public Long crear(Furgon furgon) {
		return this.customNamedParameterJdbcTemplate.crear(furgon, sqlCrear);
	}

	@Override
	public boolean existeExcluyendoId(Long id, String placa) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		paramSource.addValue("placa", placa);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
	}

	@Override
	public void actualizar(Furgon furgon) {
		this.customNamedParameterJdbcTemplate.actualizar(furgon, sqlActualizar);

	}

}
