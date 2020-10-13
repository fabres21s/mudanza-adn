package com.ceiba.furgon.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.furgon.comando.ComandoFurgon;
import com.ceiba.furgon.comando.manejador.ManejadorCrearFurgon;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/furgones")
@Api(tags = { "Controlador comando furgon"})
public class ComandoControladorFurgon {

	private final ManejadorCrearFurgon manejadorCrearFurgon;
	
	@Autowired
	public ComandoControladorFurgon(ManejadorCrearFurgon manejadorCrearFurgon) {
		this.manejadorCrearFurgon = manejadorCrearFurgon;
	}
	
	@PostMapping
	@ApiOperation("Crear furgon")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoFurgon comandoFurgon) {
		return manejadorCrearFurgon.ejecutar(comandoFurgon);
	}
}
