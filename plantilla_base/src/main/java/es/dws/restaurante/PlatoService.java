package es.dws.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PlatoService {
    @Autowired
    PlatoRepository platoRepository;

    @Autowired
    RestauranteRepository restauranteRepository;

    public void save(Plato p) { platoRepository.save(p); }
    public List<Plato> getPlatos() { return platoRepository.findAll(); }
    public void deleteById(Long id) { platoRepository.deleteById(id); }
    @PostConstruct
    public void init()
    {
        Plato plato0 = new Plato("Bocata bacon y queso", 3.99,"/bocata.jpg");
        Plato plato1 = new Plato("Empanada", 2.00,"/empanada.jpg");

        platoRepository.save(plato0);
        platoRepository.save(plato1);

        Restaurante restaurante = new Restaurante("FoodTruck", "AlborCroft", "bocadillos");

        restaurante.getPlatoList().add(plato0);
        restaurante.getPlatoList().add(plato1);

        restauranteRepository.save(restaurante);

    }

}
