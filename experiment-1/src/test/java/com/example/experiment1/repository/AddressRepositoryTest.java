package com.example.experiment1.repository;

import com.example.experiment1.dox.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    void findByUserId() {
        for(Address address : addressRepository.findByUserId("1305074481251905536")) {
            log.debug("address: {}",address);
        }
    }
}