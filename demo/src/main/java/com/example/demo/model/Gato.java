package com.example.demo.model;

import com.example.demo.DTO.GatoDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idGato;
    private String nombre;
    @ManyToOne
    @JsonBackReference
    private User dueño;

    public Gato (GatoDto gatoDto) {
        this.idGato = gatoDto.getId();
        this.nombre = gatoDto.getNombre();
        this.dueño = gatoDto.getDueño();
    }
    @Override
    public String toString() {
        return "Gato{" +
                "idGato=" + idGato +
                ", nombre='" + nombre + '\'' +
                ", dueñoId=" + (dueño != null ? dueño.getId() : "null") +
                '}';
    }

}
