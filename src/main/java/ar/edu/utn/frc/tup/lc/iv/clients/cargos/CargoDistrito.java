package ar.edu.utn.frc.tup.lc.iv.clients.cargos;

import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoDistrito {

    private Distrito distrito;
    private List<Cargos> cargos;

}
