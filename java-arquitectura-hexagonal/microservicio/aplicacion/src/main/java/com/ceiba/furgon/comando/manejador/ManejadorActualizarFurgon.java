package com.ceiba.furgon.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.furgon.comando.ComandoFurgon;
import com.ceiba.furgon.comando.fabrica.FabricaFurgon;
import com.ceiba.furgon.modelo.entidad.Furgon;
import com.ceiba.furgon.servicio.ServicioActualizarFurgon;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarFurgon implements ManejadorComando<ComandoFurgon> {

	
	private final FabricaFurgon fabricaFurgon;
	private final ServicioActualizarFurgon servicioActualizarFurgon;
	
	public ManejadorActualizarFurgon(FabricaFurgon fabricaFurgon, ServicioActualizarFurgon servicioActualizarFurgon) {
		this.fabricaFurgon = fabricaFurgon;
		this.servicioActualizarFurgon = servicioActualizarFurgon;
	}
	
	public void ejecutar(ComandoFurgon comando) {
		Furgon furgon = this.fabricaFurgon.crear(comando);
		this.servicioActualizarFurgon.ejecutar(furgon);
	}

	
}
