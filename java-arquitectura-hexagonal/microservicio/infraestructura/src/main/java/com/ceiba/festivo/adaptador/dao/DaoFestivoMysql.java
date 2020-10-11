package com.ceiba.festivo.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.festivo.modelo.dto.DtoFestivo;
import com.ceiba.festivo.puerto.dao.DaoFestivo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoFestivoMysql implements DaoFestivo{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="festivo", value="listar")
    private static String sqlListar;

    public DaoFestivoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
	
	@Override
	public List<DtoFestivo> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoFestivo());
	}

}
