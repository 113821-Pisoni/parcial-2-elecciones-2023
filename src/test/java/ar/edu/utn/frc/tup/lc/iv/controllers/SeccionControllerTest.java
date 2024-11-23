package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.Service.SeccionService;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionDTO;
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
class SeccionControllerTest {
    @Mock
    private SeccionService service;

    @Mock(name = "modelMapper")
    private ModelMapper modelMapper;

    //es para mockear la api.Recorre tod0.
    private MockMvc mockMvc;

    //tiene injectMocks porque es el que vamos a hacer en serio.
    @InjectMocks
    private SeccionController controller;

    //se inicializan los mocks
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void getSeccionesTest(){
        //Arrange
        SeccionDTO sDTO = new SeccionDTO();
        sDTO.setId(1L);
        sDTO.setNombre("Test");


        List<SeccionDTO> seccionDTOList = new ArrayList<>();
        seccionDTOList.add(sDTO);

        //Act
        when(service.getSeccionesByDistrito(1L, 1L)).thenReturn(seccionDTOList);
        ResponseEntity<List<SeccionDTO>> response = controller.getSecciones(1L, 1L);
        //Assert
        assertEquals(response.getBody().size(), 1);

    }

    @Test
    public void getSeccionesTest2(){
        //Arrange
        SeccionDTO sDTO = new SeccionDTO();
        sDTO.setId(1L);
        sDTO.setNombre("Test");


        List<SeccionDTO> seccionDTOList = new ArrayList<>();
        seccionDTOList.add(sDTO);

        //Act
        when(service.getSeccionesByDistrito(1L, null)).thenReturn(seccionDTOList);
        ResponseEntity<List<SeccionDTO>> response = controller.getSecciones(1L, null);
        //Assert
        assertEquals(response.getBody().size(), 1);

    }
}