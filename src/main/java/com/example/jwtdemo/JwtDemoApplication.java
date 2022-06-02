package com.example.jwtdemo;

import com.example.jwtdemo.entity.Role;
import com.example.jwtdemo.entity.User;
import com.example.jwtdemo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public String getString(){
        return new String();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"Adam Rassinger","adam","1234", new ArrayList<>()));
            userService.saveUser(new User(null,"Will Topp","will","1234", new ArrayList<>()));
            userService.saveUser(new User(null,"Michael Koemann","mike","1234", new ArrayList<>()));
            userService.saveUser(new User(null,"Andrea Artur","andrea","1234", new ArrayList<>()));

            userService.addRoleToUser("adam", "ROLE_USER");
            userService.addRoleToUser("will", "ROLE_MANAGER");
            userService.addRoleToUser("mike", "ROLE_ADMIN");
            userService.addRoleToUser("andrea", "ROLE_USER");
            userService.addRoleToUser("andrea", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("andrea", "ROLE_ADMIN");
        };
    }
}
