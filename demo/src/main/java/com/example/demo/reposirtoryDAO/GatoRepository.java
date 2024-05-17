package com.example.demo.reposirtoryDAO;

import com.example.demo.model.Gato;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GatoRepository extends JpaRepository<Gato, Long> {
    List<Gato> findByDueño_Id(Long id);
}
