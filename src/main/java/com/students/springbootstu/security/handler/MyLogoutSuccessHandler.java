package com.students.springbootstu.security.handler;

import com.students.springbootstu.common.ResponseResult;
import com.students.springbootstu.util.RequestUtil;
import com.students.springbootstu.util.ResponseUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyLogoutSuccessHandler  implements LogoutSuccessHandler{

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException{
        //ajax登出
        if(RequestUtil.isAjaxRequest(httpServletRequest)){
            ResponseUtil.printJson(httpServletResponse, ResponseResult.success());
        }else{
            httpServletResponse.sendRedirect("/");
        }
    }
}
