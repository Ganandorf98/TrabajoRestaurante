package es.dws.restaurante;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id_plato;
    String nombre;
    double precio;
    String imagenUrl;

    public Plato(String nombre, double precio, String imagenUrl)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
    }
}
