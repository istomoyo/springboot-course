package com.example.experiment6.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RFunction;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class LuaScriptListener {

    private final RedissonClient client;

    // 直接从编译后的classpath路径下读取文件
    @Value("mylib.lua")
    private Resource resource;

    @EventListener(ApplicationReadyEvent.class)
    public void loadRedisScript() throws IOException {
        // 读取脚本内容
        String contentAsString = resource.getContentAsString(Charset.defaultCharset());
        client.getFunction().loadAndReplace("mylib_13",contentAsString);
    }
}