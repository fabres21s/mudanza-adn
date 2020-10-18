package com.ceiba.furgon.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.furgon.modelo.entidad.Furgon;
import com.ceiba.furgon.puerto.repositorio.RepositorioFurgon;
import com.ceiba.furgon.servicio.testdatabuilder.FurgonTestDataBuilder;

public class ServicioActualizarFurgonTest {

	@Test
	public void validarFurgonExistenciaPreviaTest() {
		// arrange
		Furgon furgon = new FurgonTestDataBuilder().conId(1L).build();
		RepositorioFurgon repositorioFurgon = Mockito.mock(RepositorioFurgon.class);
		Mockito.when(repositorioFurgon.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
		ServicioActualizarFurgon servicio = new ServicioActualizarFurgon(repositorioFurgon);
		// act - assert
		BasePrueba.assertThrows(() -> servicio.ejecutar(furgon), ExcepcionDuplicidad.class,
				"La placa ingresada ya existe en el sistema");
	}
	
	@Test
	public void validarFurgonNoExistenciaPreviaTest() {
		// arrange
		Furgon furgon = new FurgonTestDataBuilder().conId(1L).build();
		RepositorioFurgon repositorioFurgon = Mockito.mock(RepositorioFurgon.class);
		Mockito.when(repositorioFurgon.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
		ServicioActualizarFurgon servicio = new ServicioActualizarFurgon(repositorioFurgon);
		// act - assert
		 assertDoesNotThrow(()  -> servicio.ejecutar(furgon));
	}
}
