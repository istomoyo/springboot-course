package com.example.experiment6.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.FunctionMode;
import org.redisson.api.FunctionResult;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.IntegerCodec;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExpireService {
    private final RedissonClient client;

    public boolean expire(String key, int expire, int count) {
        return client.getFunction(IntegerCodec.INSTANCE)
                .call(FunctionMode.WRITE, "expirAPI_0", FunctionResult.BOOLEAN, List.of(key), expire, count);
    }
}
