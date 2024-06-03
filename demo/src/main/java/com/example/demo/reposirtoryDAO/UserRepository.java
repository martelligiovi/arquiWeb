package com.example.demo.reposirtoryDAO;


import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndPassword(String name, String password);
}
