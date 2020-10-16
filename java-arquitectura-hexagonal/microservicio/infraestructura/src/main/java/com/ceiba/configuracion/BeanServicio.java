package com.ceiba.configuracion;

import com.ceiba.furgon.puerto.repositorio.RepositorioFurgon;
import com.ceiba.furgon.servicio.ServicioActualizarFurgon;
import com.ceiba.furgon.servicio.ServicioCrearFurgon;
import com.ceiba.mudanza.puerto.repositorio.RepositorioMudanza;
import com.ceiba.mudanza.servicio.ServicioCrearMudanza;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
    
    @Bean
    public ServicioCrearFurgon servicioCrearFurgon(RepositorioFurgon repositorioFurgon) {
    	return new ServicioCrearFurgon(repositorioFurgon);
    }
	
    @Bean
    public ServicioActualizarFurgon servicioActualizarFurgon(RepositorioFurgon repositorioFurgon) {
    	return new ServicioActualizarFurgon(repositorioFurgon);
    }

    @Bean
    public ServicioCrearMudanza servicioCrearMudanza(RepositorioMudanza repositorioMudanza) {
    	return new ServicioCrearMudanza(repositorioMudanza);
    }
}
