package com.tushar.springbootrest.repo;

import com.tushar.springbootrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    com.tushar.springbootrest.model.User findByUsername(String username);
}
