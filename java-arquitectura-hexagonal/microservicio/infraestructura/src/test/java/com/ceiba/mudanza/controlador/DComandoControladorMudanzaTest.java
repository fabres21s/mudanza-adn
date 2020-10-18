package com.ceiba.mudanza.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.ceiba.mudanza.comando.ComandoMudanza;
import com.ceiba.mudanza.servicio.testdatabuilder.ComandoMudanzaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorMudanza.class)
public class DComandoControladorMudanzaTest {
	
	@Autowired
    private MockMvc mocMvc;
	
    @Autowired
    private ObjectMapper objectMapper;
	
	@Test
    public void crear() throws Exception{
        // arrange
        ComandoMudanza mudanza = new ComandoMudanzaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/mudanzas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mudanza)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

}
