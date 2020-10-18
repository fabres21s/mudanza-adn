package com.ceiba.furgon.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.furgon.modelo.entidad.Furgon;
import com.ceiba.furgon.puerto.repositorio.RepositorioFurgon;
import com.ceiba.furgon.servicio.testdatabuilder.FurgonTestDataBuilder;

public class ServicioCrearFurgonTest {
	
	@Test
	public void validarCreacionFurgon() {
		//arrange
		Furgon furgon = new FurgonTestDataBuilder().build();
		
		RepositorioFurgon repositorioFurgon = Mockito.mock(RepositorioFurgon.class);
		Mockito.when(repositorioFurgon.existe(Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioFurgon.crear(Mockito.any())).thenReturn(1l);
		
		ServicioCrearFurgon servicioCrearFurgon = new ServicioCrearFurgon(repositorioFurgon);
		//act-assert
		 assertDoesNotThrow(()  ->  servicioCrearFurgon.ejecutar(furgon));
		
		
	}
	
	@Test
	public void validarExistenciaPreviaTest() {
		//arrange
		Furgon furgon = new FurgonTestDataBuilder().build();
		
		RepositorioFurgon repositorioFurgon = Mockito.mock(RepositorioFurgon.class);
		Mockito.when(repositorioFurgon.existe(Mockito.anyString())).thenReturn(true);
		
		ServicioCrearFurgon servicioCrearFurgon = new ServicioCrearFurgon(repositorioFurgon);
		//act-assert
		BasePrueba.assertThrows(() ->  servicioCrearFurgon.ejecutar(furgon), ExcepcionDuplicidad.class, "La placa ingresada ya existe en el sistema");
		
		
	}
}
