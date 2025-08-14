package com.tushar.springbootrest.service;

import com.tushar.springbootrest.model.User;
import com.tushar.springbootrest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return repo.findByUsername(user.getUsername());
    }
}
