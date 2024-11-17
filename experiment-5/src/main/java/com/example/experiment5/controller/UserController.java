package com.example.experiment5.controller;


import com.example.experiment5.dox.User;
import com.example.experiment5.service.UserService;
import com.example.experiment5.vo.ResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @PatchMapping("/password")
//    patch用于修改部分数据
    public ResultVO updatePassword(@RequestBody User user, @RequestAttribute("uid") String uid) {
        userService.updateUserPassword(uid,user.getPassword());
        return ResultVO.ok();
    }
}
