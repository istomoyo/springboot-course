package com.example.experiment1.repository;

import com.example.experiment1.dox.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    //增
    @Test
    void save() {
        User user = User.builder().name("tomoyo").build();
        userRepository.save(user);
    }

    //改
    @Test
    void updateAddress() {
        userRepository.updateUserById("sakagami_tomoyo", "1305074481251905536");
    }

    //删
    @Test
    void deleteById() {
        userRepository.deleteById("1305496337515704320");
    }
    //查
    @Test
    void findByUserId() {

        for(User user : userRepository.findByUserId("1305074481251905536")) {
            log.info("1305074481251905536有:{}",user);
        }
    }

}