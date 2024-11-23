package ar.edu.utn.frc.tup.lc.iv.Service.Impl;

import ar.edu.utn.frc.tup.lc.iv.Service.DistritoService;
import ar.edu.utn.frc.tup.lc.iv.Service.SeccionService;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.DistritoRestClient;
import ar.edu.utn.frc.tup.lc.iv.clients.secciones.Seccion;
import ar.edu.utn.frc.tup.lc.iv.clients.secciones.SeccionRestClient;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeccionServiceImpl implements SeccionService {

    @Autowired
    private SeccionRestClient seccionRestClient;

    @Override
    public List<SeccionDTO> getSeccionesByDistrito(Long distritoId, Long seccionId) {
        List<Seccion> secciones;
        List<SeccionDTO> seccionesDTO = new ArrayList<>();

        if (seccionId != null) {
            ResponseEntity<Seccion[]> response = seccionRestClient.getSeccionByDistritoAndId(distritoId, seccionId);
            secciones = Arrays.asList(response.getBody());
        } else {
            ResponseEntity<Seccion[]> response = seccionRestClient.getSeccionesByDistrito(distritoId);
            secciones = Arrays.asList(response.getBody());
        }

        for (Seccion seccion : secciones) {
            seccionesDTO.add(new SeccionDTO(seccion.getSeccionId(), seccion.getSeccionNombre()));
        }

        return seccionesDTO;
    }
}
