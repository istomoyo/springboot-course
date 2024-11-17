package com.example.experiment4.service;



import com.example.experiment4.dox.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private static List<User> USERS = create();


    private static List<User> create() {
        User u = User.builder()
                .id("1")
                .name("tomoyo")
                .role("tomoyo")
                .account("1001")
                .password("$2a$10$XPz7Kp1kF8NU3vewqqPGn.feT7UPvhoZolvJ1JRi57s16XKMWz9OW")
                .build();
        User u2 = User.builder()
                .id("1")
                .name("tomoyo")
                .role("sakagami")
                .account("8008")
                .password("$2a$10$XPz7Kp1kF8NU3vewqqPGn.feT7UPvhoZolvJ1JRi57s16XKMWz9OW")
                .build();
        return List.of(u,u2);
    }

    public List<User> listUsers() {
        return USERS;
    }




    public User getUserByAccount(String account) {
        return USERS.stream()
                .filter(u -> u.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }


}
