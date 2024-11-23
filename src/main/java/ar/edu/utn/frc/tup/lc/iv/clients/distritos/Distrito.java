package ar.edu.utn.frc.tup.lc.iv.clients.distritos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Distrito {
    Long distritoId;
    String distritoNombre;
}
