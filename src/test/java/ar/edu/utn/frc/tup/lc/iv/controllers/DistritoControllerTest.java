package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.Service.CargoService;
import ar.edu.utn.frc.tup.lc.iv.Service.DistritoService;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class DistritoControllerTest {

    @Mock
    private DistritoService service;

    @Mock(name = "modelMapper")
    private ModelMapper modelMapper;

    //es para mockear la api.Recorre tod0.
    private MockMvc mockMvc;

    //tiene injectMocks porque es el que vamos a hacer en serio.
    @InjectMocks
    private DistritoController controller;

    //se inicializan los mocks
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void getDistritosTest(){
        DistritoDTO dDTO = new DistritoDTO();
        dDTO.setDistritoId(1L);
        dDTO.setDistritoNombre("Test");

        List<DistritoDTO> dl = new ArrayList<>();
        dl.add(dDTO);

        when(service.getDistritoByName("Test")).thenReturn(dl);

        ResponseEntity<List<DistritoDTO>> response = controller.getDistritos("Test");

        assertEquals(response.getBody().size(), 1);
    }

}