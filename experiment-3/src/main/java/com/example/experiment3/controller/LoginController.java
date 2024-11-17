package com.example.experiment3.controller;


import com.example.experiment3.UserService;
import com.example.experiment3.dox.User;
import com.example.experiment3.exception.Code;
import com.example.experiment3.vo.ResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {


    private final UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody User u) {

       User user =  userService.getUserByAccount(u.getAccount(), u.getPassword());
       if(user == null) {
           return ResultVO.error(Code.LOGIN_ERROR);
       }
       return ResultVO.success(user);
    }
}
