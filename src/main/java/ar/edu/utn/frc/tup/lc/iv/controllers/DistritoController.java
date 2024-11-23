package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.Service.DistritoService;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/distritos")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public ResponseEntity<List<DistritoDTO>> getDistritos(@RequestParam(required = false,
                                                name="distrito_nombre") String nombre){
        List<DistritoDTO> districts = distritoService.getDistritoByName(nombre);
        return ResponseEntity.ok(districts);
    }

}
