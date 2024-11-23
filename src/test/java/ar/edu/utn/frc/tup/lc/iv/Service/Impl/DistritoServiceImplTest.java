package ar.edu.utn.frc.tup.lc.iv.Service.Impl;
import ar.edu.utn.frc.tup.lc.iv.Service.DistritoService;
import ar.edu.utn.frc.tup.lc.iv.Service.Impl.DistritoServiceImpl;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.DistritoRestClient;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class DistritoServiceImplTest {

    @Mock
    private DistritoRestClient distritoRestClient;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private DistritoService distritoService = new DistritoServiceImpl();

    @Test
    void emptyListTest() {
        when(distritoRestClient.getDistritos()).thenReturn(ResponseEntity.ok(new Distrito[]{}));

        List<DistritoDTO> resultado = distritoService.getDistritoByName("Test");

        assertTrue(resultado.isEmpty());
        verify(distritoRestClient, times(1)).getDistritos();
    }


}