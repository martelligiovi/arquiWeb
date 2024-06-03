package com.example.demo.Service;

import com.example.demo.model.TokenSecion;
import com.example.demo.reposirtoryDAO.TokenSecionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class TokenSecionService {

    private final TokenSecionRepository tokenSecionRepository;

    @Autowired
    public TokenSecionService(TokenSecionRepository tokenSecionRepository) {
        this.tokenSecionRepository = tokenSecionRepository;
    }

    public String generateAndSaveToken() {
        TokenSecion tokenSecion = new TokenSecion(UUID.randomUUID().toString());
        return tokenSecionRepository.save(tokenSecion).getToken();
    }

    public Boolean checkToken(String token) {
        return tokenSecionRepository.findByToken(token) != null;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteAllSessions() {
        tokenSecionRepository.deleteAll();
    }

    public String tokenClean(String tokenJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(tokenJson, Map.class);
            return map.get("token");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
