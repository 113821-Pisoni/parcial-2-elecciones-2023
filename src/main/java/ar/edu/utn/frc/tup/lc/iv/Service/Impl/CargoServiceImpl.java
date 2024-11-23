package ar.edu.utn.frc.tup.lc.iv.Service.Impl;

import ar.edu.utn.frc.tup.lc.iv.Service.CargoService;
import ar.edu.utn.frc.tup.lc.iv.clients.cargos.CargoDistrito;
import ar.edu.utn.frc.tup.lc.iv.clients.cargos.Cargos;
import ar.edu.utn.frc.tup.lc.iv.clients.cargos.CargosRestClient;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.DistritoRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    CargosRestClient cargosRestClient;

    @Autowired
    DistritoRestClient distritoRestClient;


    @Override
    public CargoDistrito cargosByDistrict(Integer id) {

        ResponseEntity<Distrito> distritoResponseEntity = distritoRestClient.getDistritoById(id);

        Distrito d= distritoResponseEntity.getBody();
        if(d == null){
            return null;
        }

        ResponseEntity<Cargos[]> response = cargosRestClient.getCargosDistrito(id);

        List<Cargos> cargosList = response.getBody() != null ? Arrays.asList(response.getBody()) : List.of();


        return new CargoDistrito(d, cargosList);
    }
}
