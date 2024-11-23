package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.Service.CargoService;
import ar.edu.utn.frc.tup.lc.iv.clients.cargos.CargoDistrito;
import ar.edu.utn.frc.tup.lc.iv.clients.cargos.Cargos;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
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
class CargoControllerTest {

    @Mock
    private CargoService service;

    @Mock(name = "modelMapper")
    private ModelMapper modelMapper;

    //es para mockear la api.Recorre tod0.
    private MockMvc mockMvc;

    //tiene injectMocks porque es el que vamos a hacer en serio.
    @InjectMocks
    private CargoController controller;

    //se inicializan los mocks
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void getCargoDistritoTest(){
        CargoDistrito cd = new CargoDistrito();
        Distrito d = new Distrito();
        Cargos c = new Cargos(2, "test", 1);
        List<Cargos> lc = new ArrayList<>();
        lc.add(c);
        cd.setDistrito(d);
        cd.setCargos(lc);

        when(service.cargosByDistrict(1)).thenReturn(cd);

        ResponseEntity<CargoDistrito> respuesta = controller.getCargoDistrito(1);

        assertEquals(respuesta.getBody().getCargos().size(), 1);
    }



}
