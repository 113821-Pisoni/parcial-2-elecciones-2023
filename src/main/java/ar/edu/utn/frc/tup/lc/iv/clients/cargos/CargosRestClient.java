package ar.edu.utn.frc.tup.lc.iv.clients.cargos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CargosRestClient {
    @Autowired
    private RestTemplate restTemplate;

    String url = "http://localhost:8081/cargos";

    public ResponseEntity<Cargos[]> getCargos(){
        return restTemplate.getForEntity(url, Cargos[].class);
    }

    public ResponseEntity<Cargos[]> getCargosDistrito(Integer id){
        return restTemplate.getForEntity(url +"?distritoId="+id, Cargos[].class);
    }

}
