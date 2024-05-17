package com.example.demo.DTO;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;

// este tendra los datos que creo que quiere el usuario, hastta convinado clases
@lombok.Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String password;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
    }
}
