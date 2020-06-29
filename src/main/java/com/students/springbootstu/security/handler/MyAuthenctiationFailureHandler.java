package com.students.springbootstu.security.handler;

import com.students.springbootstu.common.ResponseResult;
import com.students.springbootstu.util.RequestUtil;
import com.students.springbootstu.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理
 */
public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public MyAuthenctiationFailureHandler(String loginFormUrl){
        super(loginFormUrl);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println(exception.getMessage());
        System.out.println(exception.getStackTrace());
       if(RequestUtil.isAjaxRequest(request)){
           ResponseUtil.printJson(response, ResponseResult.error("用户名和密码不匹配，请重新登录"));
       }else{
           super.onAuthenticationFailure(request, response, exception);
       }
    }
}
