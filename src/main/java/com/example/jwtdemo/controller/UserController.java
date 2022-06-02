package com.example.jwtdemo.controller;


import com.example.jwtdemo.entity.Role;
import com.example.jwtdemo.entity.RoleToUserForm;
import com.example.jwtdemo.entity.User;
import com.example.jwtdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> allUsers = userService.getUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri  = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        // return new ResponseEntity<>(userService.saveRole(role), HttpStatus.CREATED);
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm roleToUserForm){
        userService.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRoleName());
        return new ResponseEntity<RoleToUserForm>(HttpStatus.CREATED);
    }
}
