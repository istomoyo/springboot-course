package com.example.experiment4.controller;



import com.example.experiment4.component.JWTComponent;
import com.example.experiment4.service.UserService;
import com.example.experiment4.dox.User;
import com.example.experiment4.exception.Code;
import com.example.experiment4.vo.ResultVO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JWTComponent jwtComponent;


    @PostMapping("/login")
    public ResultVO login(@RequestBody User u, HttpServletResponse response) {

       User user =  userService.getUserByAccount(u.getAccount());

       if(user == null || !passwordEncoder.matches(u.getPassword(), user.getPassword())) {
           return ResultVO.error(Code.LOGIN_ERROR);
       }


       String token =  jwtComponent.encode(Map.of("uid",user.getId(),"role",user.getRole()));
       response.setHeader("token",token);
       response.setHeader("role",user.getRole());
       return ResultVO.success(user);
    }
}
