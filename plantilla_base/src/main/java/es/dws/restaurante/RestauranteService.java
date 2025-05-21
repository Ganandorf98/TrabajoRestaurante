package es.dws.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    @Autowired
    RestauranteRepository restauranteRepository;

    public void save(Restaurante r) { restauranteRepository.save(r); }
    public Restaurante getRestaurante() { return restauranteRepository.findAll().stream().findFirst().orElse(new Restaurante()); }
    public void deleteById(Long id) {
        restauranteRepository.deleteById(id);
    }
}
