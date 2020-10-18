package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.furgon.puerto.repositorio.RepositorioFurgon;
import com.ceiba.furgon.servicio.ServicioActualizarFurgon;
import com.ceiba.furgon.servicio.ServicioCrearFurgon;
import com.ceiba.mudanza.puerto.repositorio.RepositorioMudanza;
import com.ceiba.mudanza.servicio.ServicioCrearMudanza;

@Configuration
public class BeanServicio {

    
    @Bean
    public ServicioCrearFurgon servicioCrearFurgon(RepositorioFurgon repositorioFurgon) {
    	return new ServicioCrearFurgon(repositorioFurgon);
    }
	
    @Bean
    public ServicioActualizarFurgon servicioActualizarFurgon(RepositorioFurgon repositorioFurgon) {
    	return new ServicioActualizarFurgon(repositorioFurgon);
    }

    @Bean
    public ServicioCrearMudanza servicioCrearMudanza(RepositorioMudanza repositorioMudanza, RepositorioFurgon repositorioFurgon) {
    	return new ServicioCrearMudanza(repositorioMudanza, repositorioFurgon);
    }
}
