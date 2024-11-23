package ar.edu.utn.frc.tup.lc.iv.clients.secciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seccion {
    private Long seccionId;
    private String seccionNombre;
    private Long distritoId;
}
