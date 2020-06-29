package com.students.springbootstu.security.handler;

import com.students.springbootstu.common.ResponseResult;
import com.students.springbootstu.util.RequestUtil;
import com.students.springbootstu.util.ResponseUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    /**
     * 登录成功处理器
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        // 判断是否是ajax请求，因为ajax请求不能跳转页面，所以要单独判断
        if (RequestUtil.isAjaxRequest(request)) {
            ResponseUtil.printJson(response,  ResponseResult.success());
        } else {
            response.sendRedirect("/");
        }
    }
}
