package com.example.experiment4.controller;

import com.example.experiment4.exception.Code;
import com.example.experiment4.exception.XException;
import com.example.experiment4.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@Slf4j
@RestControllerAdvice
public class ExceptionController {


    @ExceptionHandler(XException.class)
    public ResultVO handleXException(XException e) {
        if(e.getCode() !=null){
            return ResultVO.error(e.getCode());
        }
        return ResultVO.error(e.getNumber(),e.getMessage());
    }





    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e) {
        return ResultVO.error(Code.ERROR,e.getMessage());
    }
}
