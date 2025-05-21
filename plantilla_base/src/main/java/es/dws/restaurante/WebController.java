package es.dws.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private PlatoRepository platoRepository;

    @GetMapping("/")
    public String mostrarRestaurantes(Model model) {
        model.addAttribute("restaurantes", restauranteRepository.findAll());
        return "index";
    }

}
