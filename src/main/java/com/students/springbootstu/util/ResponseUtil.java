package com.students.springbootstu.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ResponseUtil {
    public static void printJson(HttpServletResponse httpServletResponse, Object data){
        httpServletResponse.setContentType("application/json;charset=utf-8");//设置返回内容格式
        try{
            PrintWriter out = httpServletResponse.getWriter();
            out.print(JSONUtil.toJsonString(data));
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error("响应异常");
        }
    }
}
