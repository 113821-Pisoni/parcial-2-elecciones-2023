package ar.edu.utn.frc.tup.lc.iv.Service;

import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistritoService {
    List<DistritoDTO> getDistritoByName(String nombre);
}
