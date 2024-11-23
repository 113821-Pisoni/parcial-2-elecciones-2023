package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.Service.CargoService;
import ar.edu.utn.frc.tup.lc.iv.clients.cargos.CargoDistrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargos")
public class CargoController {
    @Autowired
    CargoService cargoService;

    @GetMapping
    public ResponseEntity<CargoDistrito> getCargoDistrito(@RequestParam(required = false, name="distrito_id") Integer id){
        CargoDistrito cd = cargoService.cargosByDistrict(id);
        return ResponseEntity.ok(cd);
    }
}
