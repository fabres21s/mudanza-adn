package com.ceiba.usuario.servicio;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class UsuarioTest {

	 @Test
	    public void validarConstructorUsuario() {
	    	
	    	BasePrueba.assertThrows(() -> new Usuario(1l, null, "", LocalDateTime.now()), ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
	    	
	    }
}
