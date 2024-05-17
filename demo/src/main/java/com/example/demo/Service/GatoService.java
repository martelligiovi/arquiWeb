package com.example.demo.Service;

import com.example.demo.model.Gato;
import com.example.demo.model.User;
import com.example.demo.reposirtoryDAO.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatoService implements IService<Gato>{
    @Autowired
    private GatoRepository gatoRepository;
    @Override
    public Gato save(Gato gato) {
        return gatoRepository.save(gato);
    }

    @Override
    public List<Gato> get() {
        return gatoRepository.findAll();
    }

    public List<Gato> getGatosByDueño(Long id){
        return gatoRepository.findByDueño_Id(id);
    }

    @Override
    public void delete(Long id) {
        gatoRepository.deleteById(id);
    }

    @Override
    public Gato find(Long id) {
        return gatoRepository.findById(id).orElse(null);
    }

    @Override
    public Gato update(Gato gato) {
        Gato existingGato = gatoRepository.findById(gato.getIdGato()).orElse(null);
        if(existingGato != null){
            existingGato.setNombre(gato.getNombre());
            gatoRepository.save(existingGato);
        }
        return existingGato;
    }
}
