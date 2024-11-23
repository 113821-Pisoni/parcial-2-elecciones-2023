package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.Service.SeccionService;
import ar.edu.utn.frc.tup.lc.iv.clients.secciones.Seccion;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secciones")
public class SeccionController {

    @Autowired
    private SeccionService seccionService;

    @GetMapping
    public ResponseEntity<List<SeccionDTO>> getSecciones(
            @RequestParam("distrito_id") Long distritoId,
            @RequestParam(required = false) Long seccion_id) {

        List<SeccionDTO> secciones = seccionService.getSeccionesByDistrito(distritoId, seccion_id);
        return ResponseEntity.ok(secciones);
    }
}
