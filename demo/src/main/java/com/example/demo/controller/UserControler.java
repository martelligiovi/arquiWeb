package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.IService;
import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControler {

    @Autowired
    private UserService userService;

    @GetMapping("/User/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = new UserDTO((User) userService.find(id));
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/User")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(new UserDTO((User) userService.save(new User(userDTO))), HttpStatus.CREATED);
    }

    @PutMapping("/User/edit")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(new UserDTO((User) userService.update(new User(userDTO))), HttpStatus.OK);
    }

    @DeleteMapping("/User/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @GetMapping("/User")
    public ResponseEntity<List<UserDTO>> getUsers() {
        ArrayList<User> userList = new ArrayList<>(userService.get());
        ArrayList<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(new UserDTO(user));
        }
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }
}
