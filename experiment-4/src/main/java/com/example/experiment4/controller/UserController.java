package com.example.experiment4.controller;


import com.example.experiment4.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/info")
    public ResultVO getInfo(@RequestAttribute("uid") String uid){
        log.info("uid:{}",uid);
        return ResultVO.success(Map.of("uid",uid));
    }


}