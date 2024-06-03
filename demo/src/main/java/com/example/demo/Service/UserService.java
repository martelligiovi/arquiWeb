package com.example.demo.Service;


import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.reposirtoryDAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService<User> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public User find(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);

        if (existingUser != null) {
            if (user.getName() != null) {
                existingUser.setName(user.getName());
            }
            if (user.getPassword() != null) {
                existingUser.setPassword(user.getPassword());
            }

            userRepository.save(existingUser);
        }
        return existingUser;
    }

    public Boolean checkUser(String name, String password) {
        User user = userRepository.findByNameAndPassword(name, password);System.out.println(user);
        return user != null;
    }


}
