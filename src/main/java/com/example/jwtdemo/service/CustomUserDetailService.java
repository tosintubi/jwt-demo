package com.example.jwtdemo.service;


import com.example.jwtdemo.entity.CustomUser;
import com.example.jwtdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService  implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser customUser  = userRepository.findByUserName(username);

        // Maps customUser to spring's userdetails User
        User userDetails = new User(customUser.getUserName(), customUser.getPassword(), new ArrayList<>());
        return userDetails;
    }
}
