package com.ceiba.mudanza.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionFurgonNoDisponible;
import com.ceiba.dominio.excepcion.ExcepcionFurgonNoExiste;
import com.ceiba.dominio.excepcion.ExcepcionTarifarioNoConfigurado;
import com.ceiba.furgon.puerto.repositorio.RepositorioFurgon;
import com.ceiba.mudanza.modelo.entidad.Mudanza;
import com.ceiba.mudanza.puerto.repositorio.RepositorioMudanza;
import com.ceiba.mudanza.servicio.testdatabuilder.MudanzaTestDataBuilder;
import com.ceiba.tarifario.modelo.dto.DtoTarifario;

public class ServicioCrearMudanzaTest {
	
	
	@Test
	public void validarCreacionExistenciaFurgon() {
		//arrange
		Mudanza mudanza = new MudanzaTestDataBuilder().build();
		
		RepositorioMudanza repositorioMudanza = Mockito.mock(RepositorioMudanza.class);
		RepositorioFurgon repositorioFurgon = Mockito.mock(RepositorioFurgon.class);
		
		Mockito.when(repositorioFurgon.existe(Mockito.anyLong())).thenReturn(false);
		
		ServicioCrearMudanza servicioCrearMudanza = new ServicioCrearMudanza(repositorioMudanza, repositorioFurgon);
		//act-assert
		 
		 BasePrueba.assertThrows(() -> servicioCrearMudanza.ejecutar(mudanza),
				 ExcepcionFurgonNoExiste.class, "El furgon seleccionado no existe");
		
		
	}

	@Test
	public void validarCreacionDisponibilidadFurgon() {
		//arrange
		Mudanza mudanza = new MudanzaTestDataBuilder().build();
		
		RepositorioMudanza repositorioMudanza = Mockito.mock(RepositorioMudanza.class);
		RepositorioFurgon repositorioFurgon = Mockito.mock(RepositorioFurgon.class);
		
		Mockito.when(repositorioFurgon.existe(Mockito.anyLong())).thenReturn(true);
		Mockito.when(repositorioMudanza.consultarDisponibilidadFurgon(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(true);
		
		ServicioCrearMudanza servicioCrearMudanza = new ServicioCrearMudanza(repositorioMudanza, repositorioFurgon);
		//act-assert
		 
		 BasePrueba.assertThrows(() -> servicioCrearMudanza.ejecutar(mudanza),
				 ExcepcionFurgonNoDisponible.class, "El furgon no esta disponible para esa fecha");
		
		
	}
	
	@Test
	public void validarCreacionMudanzaTarifario() {
		//arrange
		Mudanza mudanza = new MudanzaTestDataBuilder().build();
		
		RepositorioMudanza repositorioMudanza = Mockito.mock(RepositorioMudanza.class);
		
		RepositorioFurgon repositorioFurgon = Mockito.mock(RepositorioFurgon.class);
		
		Mockito.when(repositorioFurgon.existe(Mockito.anyLong())).thenReturn(true);
		Mockito.when(repositorioMudanza.consultarDisponibilidadFurgon(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(false);
		Mockito.when(repositorioMudanza.consultarTarifario(Mockito.any(), Mockito.anyLong())).thenReturn(new ArrayList<>());
		
		ServicioCrearMudanza servicioCrearMudanza = new ServicioCrearMudanza(repositorioMudanza, repositorioFurgon);
		//act-assert
		 
		 BasePrueba.assertThrows(() -> servicioCrearMudanza.ejecutar(mudanza),
				 ExcepcionTarifarioNoConfigurado.class, "El tarifario no se encuentra correctamente configurado para esa fecha");
		
		
	}
	
	@Test
	public void validarCreacionMudanza() {
		//arrange
		Mudanza mudanza = new MudanzaTestDataBuilder().build();
		List<DtoTarifario> list = new ArrayList<>();
		list.add(new DtoTarifario(Double.valueOf(50000.0),Double.valueOf(50000.0),Double.valueOf(50000.0),Double.valueOf(50000.0), Boolean.FALSE, Boolean.FALSE));
		
		RepositorioMudanza repositorioMudanza = Mockito.mock(RepositorioMudanza.class);
		RepositorioFurgon repositorioFurgon = Mockito.mock(RepositorioFurgon.class);
		
		Mockito.when(repositorioFurgon.existe(Mockito.anyLong())).thenReturn(true);
		
		Mockito.when(repositorioMudanza.consultarDisponibilidadFurgon(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(false);
		Mockito.when(repositorioMudanza.consultarTarifario(Mockito.any(), Mockito.anyLong())).thenReturn(list);
		Mockito.when(repositorioMudanza.crear(Mockito.any())).thenReturn(1l);
		
		ServicioCrearMudanza servicioCrearMudanza = new ServicioCrearMudanza(repositorioMudanza, repositorioFurgon);
		//act-assert
		 
		assertDoesNotThrow(() -> servicioCrearMudanza.ejecutar(mudanza));
		
		
	}
}
