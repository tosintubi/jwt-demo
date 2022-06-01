package com.example.jwtdemo.controller;

import com.example.jwtdemo.dto.AuthRequest;
import com.example.jwtdemo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WelcomeController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;


    @GetMapping("/hi")
    public String welcome(){
        return "holla!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getUserName(),
                    authRequest.getPassword()));
        } catch (Exception ex){
            throw  new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
