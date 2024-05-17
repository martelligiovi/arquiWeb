package com.example.demo.DTO;

import com.example.demo.model.Gato;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
public class GatoDto {
    private Long id;
    private String nombre;
    private User dueño;

    public GatoDto(Gato gato) {
        this.id = gato.getIdGato();
        this.nombre = gato.getNombre();
        this.dueño = gato.getDueño();
    }
}
