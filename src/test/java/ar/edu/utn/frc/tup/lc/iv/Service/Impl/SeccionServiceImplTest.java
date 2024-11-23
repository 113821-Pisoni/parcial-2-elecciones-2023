package ar.edu.utn.frc.tup.lc.iv.Service.Impl;

import ar.edu.utn.frc.tup.lc.iv.clients.secciones.Seccion;
import ar.edu.utn.frc.tup.lc.iv.clients.secciones.SeccionRestClient;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class SeccionServiceImplTest {
    @Mock
    private SeccionRestClient seccionRestClient;

    @InjectMocks
    private SeccionServiceImpl seccionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getSeccionesByDistritoTest(){

        Seccion s = new Seccion();
        s.setDistritoId(1L);
        s.setSeccionId(1L);
        s.setSeccionNombre("Test");

        Seccion[] seccion = new Seccion[]{s};

        when(seccionRestClient.getSeccionByDistritoAndId(1L, 1L))
                .thenReturn(ResponseEntity.ok(seccion));

        List<SeccionDTO> response = seccionService.getSeccionesByDistrito(1L, 1L);

        assertEquals(response.size(), 1);
        assertEquals(response.get(0).getId(), 1L);

    }


}