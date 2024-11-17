package com.example.experiment4.interceptor;

import com.example.experiment4.dox.User;
import com.example.experiment4.exception.Code;
import com.example.experiment4.exception.XException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(User.ADMIN.equals(request.getAttribute("role"))){
            return true;
        }else{
            throw XException.builder().code(Code.FORBIDDEN).build();
        }
    }

}
