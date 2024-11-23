package ar.edu.utn.frc.tup.lc.iv.Service.Impl;

import ar.edu.utn.frc.tup.lc.iv.clients.cargos.CargoDistrito;
import ar.edu.utn.frc.tup.lc.iv.clients.cargos.Cargos;
import ar.edu.utn.frc.tup.lc.iv.clients.cargos.CargosRestClient;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.DistritoRestClient;
import ar.edu.utn.frc.tup.lc.iv.clients.secciones.Seccion;
import ar.edu.utn.frc.tup.lc.iv.clients.secciones.SeccionRestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CargoServiceImplTest {
    @Mock
    private CargosRestClient cargosRestClient;

    @Mock
    private DistritoRestClient distritoRestClient;

    @InjectMocks
    private CargoServiceImpl cargoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getCargosByDistrictTest(){
        //hago los objetos que necesito
        Distrito distrito = new Distrito();
        distrito.setDistritoId(1L);
        distrito.setDistritoNombre("Test");

        Cargos c = new Cargos(1, "CargoTest", 1);

        Cargos[] cargoArray = new Cargos[]{c};

        when(distritoRestClient.getDistritoById(1))
                .thenReturn(ResponseEntity.ok(distrito));

        when(cargosRestClient.getCargosDistrito(1))
                .thenReturn(ResponseEntity.ok(cargoArray));


        CargoDistrito response = cargoService.cargosByDistrict(1);

        assertEquals(response.getCargos().size(), 1);
        assertEquals(response.getDistrito().getDistritoId(), 1);

    }

}