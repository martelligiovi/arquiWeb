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
        Gato gatoDto1 = gatoService.save(gato);
        System.out.println(gatoDto1);
        return new ResponseEntity<>(gatoDto1, HttpStatus.CREATED);
    }

    @PatchMapping("User/{idUser}/Gato/edit")
    public ResponseEntity<?> updateGato(@RequestBody Gato gato) {
        System.out.println(gato);
        System.out.println("------------");
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
        //System.out.println(gatos);
        return new ResponseEntity<>(gatos, HttpStatus.OK);
    }
}
