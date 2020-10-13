package com.ceiba.furgon.adaptador.dao;

import java.util.List;

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

	    public DaoFurgonMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
	        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	    }

	@Override
	public List<DtoFurgon> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoFurgon());
	}

	
}
