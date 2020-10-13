package com.ceiba.furgon.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.furgon.comando.ComandoFurgon;
import com.ceiba.furgon.comando.fabrica.FabricaFurgon;
import com.ceiba.furgon.modelo.entidad.Furgon;
import com.ceiba.furgon.servicio.ServicioCrearFurgon;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearFurgon implements ManejadorComandoRespuesta<ComandoFurgon, ComandoRespuesta<Long>> {

	
	private final FabricaFurgon fabricaFurgon;
	private final ServicioCrearFurgon servicioCrearFurgon;
	
	public ManejadorCrearFurgon(FabricaFurgon fabricaFurgon, ServicioCrearFurgon servicioCrearFurgon) {
		this.fabricaFurgon = fabricaFurgon;
		this.servicioCrearFurgon = servicioCrearFurgon;
	}
	
	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoFurgon comando) {

		Furgon furgon = this.fabricaFurgon.crear(comando);
		return new ComandoRespuesta<>(this.servicioCrearFurgon.ejecutar(furgon));
	}

	
}
