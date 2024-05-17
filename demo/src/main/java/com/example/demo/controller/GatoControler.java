package com.example.demo.controller;

import com.example.demo.DTO.GatoDto;
import com.example.demo.Service.GatoService;
import com.example.demo.model.Gato;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GatoControler {

    @Autowired
    private GatoService gatoService;

    @GetMapping("User/{idUser}/Gato/{idGato}")
    public ResponseEntity<Gato> getGato(@PathVariable Long  idUser, @PathVariable Long idGato) {
        Gato gato = gatoService.find(idGato);
        return new ResponseEntity<>(gato, HttpStatus.OK);
    }

    @PostMapping("User/{idUser}/Gato")
    public ResponseEntity<Gato> createGato(@PathVariable Long idUser ,@RequestBody GatoDto gatoDto) {
        Gato gato= new Gato(gatoDto);
        gato.setDueño(new User(idUser));
        return new ResponseEntity<>(gatoService.save(gato), HttpStatus.CREATED);
    }

    @PutMapping("User/{idUser}/Gato/edit")
    public ResponseEntity<Gato> updateGato(@RequestBody Gato gato) {
        return new ResponseEntity<>(gatoService.update(gato), HttpStatus.OK);
    }

    @DeleteMapping("User/{idUser}/Gato/{idGato}")
    public ResponseEntity<String> deleteGato(@PathVariable Long idGato) {
        gatoService.delete(idGato);
        return new ResponseEntity<>("Gato deleted", HttpStatus.OK);
    }

    @GetMapping("User/{idUser}/Gato")
    public ResponseEntity<List<Gato>> getGatos(@PathVariable Long idUser) {
        List<Gato> gatos = gatoService.getGatosByDueño(idUser);
        return new ResponseEntity<>(gatos, HttpStatus.OK);
    }
}
