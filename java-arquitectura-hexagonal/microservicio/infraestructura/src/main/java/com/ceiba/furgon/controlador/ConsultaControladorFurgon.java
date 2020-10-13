package com.ceiba.furgon.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.furgon.consulta.ManejadorListarFurgon;
import com.ceiba.furgon.modelo.dto.DtoFurgon;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/furgones")
@Api(tags={"Controlador consulta furgones"})
public class ConsultaControladorFurgon {

	private final ManejadorListarFurgon manejadorListarFurgon;
	
	public ConsultaControladorFurgon(ManejadorListarFurgon manejadorListarFurgon) {
		this.manejadorListarFurgon = manejadorListarFurgon;
	}
	
	@GetMapping
	@ApiOperation("Listar furgones")
	public List<DtoFurgon> listar() {
		return this.manejadorListarFurgon.ejecutar();
	}
}
