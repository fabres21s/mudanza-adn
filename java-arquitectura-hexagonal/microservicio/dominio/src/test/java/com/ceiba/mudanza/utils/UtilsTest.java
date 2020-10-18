package com.ceiba.mudanza.utils;

import java.time.DayOfWeek;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.ceiba.mudanza.modelo.entidad.Mudanza;
import com.ceiba.mudanza.servicio.testdatabuilder.MudanzaTestDataBuilder;
import com.ceiba.tarifario.modelo.dto.DtoTarifario;

public class UtilsTest {

	@Test
	public void validarAsignarTarifaBase() {
		
		Utils utils = new Utils();
		DtoTarifario tarifario = new DtoTarifario(100.0, 10.0, 15.0,20.0, false, false);
		Mudanza mudanza = new MudanzaTestDataBuilder().build();
		
		utils.asignarTarifas(mudanza, tarifario);
		
		Assertions.assertEquals(mudanza.getTarifaBase(), tarifario.getTarifaBase());
	}
	
	@Test
	public void validarRecargoFestivo() {
		
		Utils utils = new Utils();
		DtoTarifario tarifario = new DtoTarifario(100.0, 10.0, 15.0,20.0, false, true);
		Mudanza mudanza = new MudanzaTestDataBuilder().build();
		
		utils.asignarTarifas(mudanza, tarifario);
		
		Assertions.assertEquals(mudanza.getRecargoFestivo(), Double.valueOf(20.0));
	}
	
	@Test
	public void validarRecargoNoFestivo() {
		
		Utils utils = new Utils();
		DtoTarifario tarifario = new DtoTarifario(100.0, 10.0, 15.0,20.0, false, false);
		Mudanza mudanza = new MudanzaTestDataBuilder().build();
		
		utils.asignarTarifas(mudanza, tarifario);
		
		Assertions.assertEquals(mudanza.getRecargoFestivo(), Double.valueOf(0));
	}
	
	@Test
	public void validarRecargoNocturno() {
		
		Utils utils = new Utils();
		DtoTarifario tarifario = new DtoTarifario(100.0, 10.0, 15.0,20.0, true, false);
		Mudanza mudanza = new MudanzaTestDataBuilder().build();
		
		utils.asignarTarifas(mudanza, tarifario);
		
		Assertions.assertEquals(mudanza.getRecargoNocturno(), Double.valueOf(10.0));
	}
	
	@Test
	public void validarRecargoNoNocturno() {
		
		Utils utils = new Utils();
		DtoTarifario tarifario = new DtoTarifario(100.0, 10.0, 15.0,20.0, false, false);
		Mudanza mudanza = new MudanzaTestDataBuilder().build();
		
		utils.asignarTarifas(mudanza, tarifario);
		
		Assertions.assertEquals(mudanza.getRecargoNocturno(), Double.valueOf(0));
	}
	
	@Test
	public void validarRecargoDominical() {
		
		Utils utils = new Utils();
		DtoTarifario tarifario = new DtoTarifario(100.0, 10.0, 15.0,20.0, true, false);
		Mudanza mudanza = new MudanzaTestDataBuilder().proximoDia(DayOfWeek.SUNDAY).build();
		
		utils.asignarTarifas(mudanza, tarifario);
		
		Assertions.assertEquals(mudanza.getRecargoDominical(), Double.valueOf(15.0));
	}
	
	@Test
	public void validarRecargoNoDominical() {
		
		Utils utils = new Utils();
		DtoTarifario tarifario = new DtoTarifario(100.0, 10.0, 15.0,20.0, false, false);
		Mudanza mudanza = new MudanzaTestDataBuilder().proximoDia(DayOfWeek.MONDAY).build();
		
		utils.asignarTarifas(mudanza, tarifario);
		
		Assertions.assertEquals(mudanza.getRecargoDominical(), Double.valueOf(0));
	}
}
