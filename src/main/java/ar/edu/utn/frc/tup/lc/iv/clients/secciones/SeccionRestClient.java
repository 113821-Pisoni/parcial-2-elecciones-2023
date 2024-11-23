package ar.edu.utn.frc.tup.lc.iv.clients.secciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SeccionRestClient {
    @Autowired
    private RestTemplate restTemplate;

    String url = "http://localhost:8081/secciones";

    public ResponseEntity<Seccion[]> getSecciones() {
        return restTemplate.getForEntity(url, Seccion[].class);
    }

    public ResponseEntity<Seccion[]> getSeccionesByDistrito(Long distritoId) {
        String url1 = url + "?distritoId=" + distritoId;
        return restTemplate.getForEntity(url1, Seccion[].class);
    }

    public ResponseEntity<Seccion[]> getSeccionByDistritoAndId(Long distritoId, Long seccionId) {
        String url1 = url + "?distritoId=" + distritoId + "&seccionId=" + seccionId;
        return restTemplate.getForEntity(url1, Seccion[].class);
    }

}
