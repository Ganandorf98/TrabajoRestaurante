package es.dws.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")

@RestController
public class RestauranteRESTController {

    @Autowired
    RestauranteService restauranteService;

    @Autowired
    PlatoService platoService;

    @GetMapping("/")
    public ResponseEntity<List<Restaurante>> getRestaurantes()
    {
        return new ResponseEntity<>(restauranteService.restauranteRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Restaurante> createRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante savedRestaurante = restauranteService.restauranteRepository.save(restaurante);
        return new ResponseEntity<>(savedRestaurante, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPlato(@PathVariable Long id) {
        restauranteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}




