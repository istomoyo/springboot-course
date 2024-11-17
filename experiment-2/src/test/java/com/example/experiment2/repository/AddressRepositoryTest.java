package com.example.experiment2.repository;

import com.example.experiment2.dox.Address;
import com.example.experiment2.dto.AddressUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void findByUserId() {
        for(Address address : addressRepository.findByUserId("1305074481251905536")) {
            log.info("1305074481251905536是:{}",address);
        }
    }

    @Test
    void findByAId() {

         AddressUserDTO byAid =  addressRepository.findByAId("1");
         log.debug(" AddressUserDTO byAid :{}",byAid);

    }
}