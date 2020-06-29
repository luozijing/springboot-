package com.students.springbootstu.security.handler;

import com.students.springbootstu.common.ResponseResult;
import com.students.springbootstu.util.RequestUtil;
import com.students.springbootstu.util.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    public MyLoginUrlAuthenticationEntryPoint(String loginFormUrl){
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if(RequestUtil.isAjaxRequest(request)){
            ResponseUtil.printJson(response, ResponseResult.unLogin());
        }else{
            super.commence(request, response, authException);
        }
    }
}
