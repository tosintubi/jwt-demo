package com.example.jwtdemo;

import com.example.jwtdemo.entity.CustomUser;
import com.example.jwtdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtDemoApplication {

    @Autowired
    private  UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }

    @PostConstruct
    public void initUsers(){

        List<CustomUser> customUsers = Stream.of(
                new CustomUser(101, "user1", "password1", "user1@mail.co"),
                new CustomUser(102, "user2", "password2", "user2@mail.co"),
                new CustomUser(103, "user3", "password3", "user3@mail.co")
        ).collect(Collectors.toList());

        userRepository.saveAll(customUsers);
    }

}
