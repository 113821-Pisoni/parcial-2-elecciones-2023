package ar.edu.utn.frc.tup.lc.iv.Service;

import ar.edu.utn.frc.tup.lc.iv.clients.secciones.Seccion;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeccionService {
    List<SeccionDTO> getSeccionesByDistrito(Long distritoId, Long seccionId);
}
