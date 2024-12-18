package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistritoDTO {

    @JsonProperty(value="id")
    private Long distritoId;

    @JsonProperty(value="nombre")
    private String distritoNombre;
}
