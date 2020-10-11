package com.ceiba.festivo.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.festivo.consulta.ManejadorListarFestivos;
import com.ceiba.festivo.modelo.dto.DtoFestivo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/festivos")
@Api(tags= {"Controlador consulta de festivos"})
public class ConsultaControladorFestivo {

	private final ManejadorListarFestivos manejadorListarFestivos;
	
	public ConsultaControladorFestivo(ManejadorListarFestivos manejadorListarFestivos) {
		this.manejadorListarFestivos = manejadorListarFestivos;
	}
	
	
	@GetMapping
	@ApiOperation("Listar festivos")
	public List<DtoFestivo> listar() {
		return this.manejadorListarFestivos.ejecutar();
	}
}
