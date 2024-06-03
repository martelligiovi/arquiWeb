package com.example.demo.reposirtoryDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TokenSecion;

public interface TokenSecionRepository extends JpaRepository<TokenSecion, Long> {
    TokenSecion findByToken(String token);
}
