package ar.edu.utn.frc.tup.lc.iv.Service.Impl;

import ar.edu.utn.frc.tup.lc.iv.Service.DistritoService;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.Distrito;
import ar.edu.utn.frc.tup.lc.iv.clients.distritos.DistritoRestClient;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class DistritoServiceImpl implements DistritoService {
    @Autowired
    private DistritoRestClient distritoRestClient;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(DistritoServiceImpl.class);

    @Override
    public List<DistritoDTO> getDistritoByName(String nombre) {
        ResponseEntity<Distrito[]> response = distritoRestClient.getDistritos();
        List<Distrito> districtList = response.getBody() != null ? Arrays.asList(response.getBody()) : List.of();


        List<DistritoDTO> distritoDTOS = new ArrayList<>();
        for (Distrito distrito : districtList){
            distritoDTOS.add(
                    modelMapper.map(distrito, DistritoDTO.class)
            );
        }

        List<DistritoDTO> filteredDistrito = new ArrayList<>();
        if (nombre != null && !nombre.isEmpty()) {

//            return distritoDTOS.stream()
//                    .filter(district -> district.getDistritoNombre().toLowerCase().contains(nombre.toLowerCase()))
//                    .collect(Collectors.toList());

            for(DistritoDTO distritoDto: distritoDTOS ){
                if(distritoDto.getDistritoNombre().toLowerCase().contains(nombre.toLowerCase())){
                    filteredDistrito.add(distritoDto);
                }

            }
        }
        //ejemplos de logs!
        logger.trace("Soy trace");
        logger.error("Soy error");

        return filteredDistrito;
    }
}
