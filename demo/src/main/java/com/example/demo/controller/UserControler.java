package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.IService;
import com.example.demo.Service.TokenSecionService;
import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserControler {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenSecionService tokenService;


    @GetMapping("/User/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = new UserDTO((User) userService.find(id));
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/User")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        Boolean check = userService.checkUser(userDTO.getName(), userDTO.getPassword());
        System.out.println(check);
        if (check==false) {
            String token = tokenService.generateAndSaveToken();
            new UserDTO((User) userService.save(new User(userDTO)));
            return new ResponseEntity<>(token, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("FAIL", HttpStatus.UNAUTHORIZED);
        }

    }

    @PatchMapping("/User/edit")
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

    @PostMapping("/user/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
        if (userService.checkUser(userDTO.getName(), userDTO.getPassword())) {
            String token = tokenService.generateAndSaveToken();
            System.out.println(token);

            return new ResponseEntity<>(token, HttpStatus.OK);

        } else {
            System.out.println("FAIL");
            return new ResponseEntity<>("FAIL", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/user/checkToken")
    public ResponseEntity<String> checkToken(@RequestBody String token) {
        System.out.println(token);
        token = tokenService.tokenClean(token);
        System.out.println(token);
        if (tokenService.checkToken(token)) {
            System.out.println("------------------OK-------------------");
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            System.out.println("------------------fail-------------------");
            return new ResponseEntity<>("FAIL", HttpStatus.UNAUTHORIZED);
        }
    }
}
