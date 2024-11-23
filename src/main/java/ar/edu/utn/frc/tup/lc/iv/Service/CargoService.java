package ar.edu.utn.frc.tup.lc.iv.Service;

import ar.edu.utn.frc.tup.lc.iv.clients.cargos.CargoDistrito;
import ar.edu.utn.frc.tup.lc.iv.clients.cargos.Cargos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CargoService {
    CargoDistrito cargosByDistrict(Integer id);
}
