package ar.edu.utn.frc.tup.lc.iv.clients.distritos;

import ar.edu.utn.frc.tup.lc.iv.configs.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistritoRestClient {

    @Autowired
    private RestTemplate restTemplate;

    String url = "http://localhost:8081/distritos";

    public ResponseEntity<Distrito[]> getDistritos(){
        return restTemplate.getForEntity(url, Distrito[].class);
    }

    public ResponseEntity<Distrito[]> getDistrito(String nombre){
        return restTemplate.getForEntity(url+"?distrito_nombre="+nombre, Distrito[].class);
    }

    public ResponseEntity<Distrito> getDistritoById(int id){
        ResponseEntity<Distrito[]> response = restTemplate.getForEntity(url+"?distritoId="+id, Distrito[].class);
        return ResponseEntity.ok(response.getBody()[0]);

    }

}
