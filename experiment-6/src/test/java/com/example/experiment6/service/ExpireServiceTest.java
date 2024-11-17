package com.example.experiment6.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ExpireServiceTest {

    @Autowired
    private ExpireService expireService;

    @Test
    void expire() throws InterruptedException {
        for (int i = 0; i < 11; i++) {
            boolean expire = expireService.expire("api:522", 10, 2);
            log.debug("{}", expire);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}