package com.example.demo.model;

import com.example.demo.DTO.UserDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String password;
    @OneToMany(mappedBy = "dueño", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Gato> gatos;

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.password = userDTO.getPassword();
    }

    public User(Long idUser) {
        this.id = idUser;
    }
}
