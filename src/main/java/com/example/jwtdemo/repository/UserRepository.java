package com.example.jwtdemo.repository;

import com.example.jwtdemo.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Integer> {
    CustomUser findByUserName(String username);
}
