package com.example.experiment2.repository;

import com.example.experiment2.dox.Address;
import com.example.experiment2.dto.UserAddressDTO;
import com.example.experiment2.dto.UserCountDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void findByUId() {
        UserAddressDTO byUserId = userRepository.findByUId("1305074481251905536");
        for(Address address : byUserId.getAddresses()) {
            log.info("address: {}", address);
        }
    }


    @Test
    void findAllAddresses() {
        for(UserCountDTO u:userRepository.findAllAddresses()) {
            log.info("u: {}", u);
        }
    }
}