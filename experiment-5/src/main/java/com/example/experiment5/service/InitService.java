package com.example.experiment5.service;

import com.example.experiment5.dox.User;
import com.example.experiment5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class InitService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        String account = "admin";
        long count = userRepository.count();
        if (count > 0) {
            return;
        }

        User user = User.builder()
                .name(account)
                .account(account)
                .password(passwordEncoder.encode(account))
                .role(User.ADMIN)
                .build();


        userRepository.save(user);

    }
}
