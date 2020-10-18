package com.ceiba.furgon.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorFurgon.class)
public class ConsultaControladorFurgonTest {
	
	@Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/furgones")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].placa", is("ABC-123")));
    }
    
    @Test
    public void listarDisponiblesNoEncuentra() throws Exception {
        // arrange
    	Long tarifaHorarioId = 1l;
    	String fecha = "2020-10-31";
    	
    	
        // act - assert
        mocMvc.perform(get("/furgones/disponibles/{id}/{fecha}", tarifaHorarioId, fecha)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)))
               ;
    }
    
    @Test
    public void listarDisponiblesSiEncuentra() throws Exception {
        // arrange
    	Long tarifaHorarioId = 1l;
    	String fecha = "2020-10-30";
        // act - assert
        mocMvc.perform(get("/furgones/disponibles/{id}/{fecha}", tarifaHorarioId, fecha)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].placa", is("ABC-123")));
    }


}
