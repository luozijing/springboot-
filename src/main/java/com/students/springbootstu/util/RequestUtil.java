package com.students.springbootstu.util;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    /**
     * 判断是否是ajax请求
     */
    public static boolean isAjaxRequest(HttpServletRequest httpServletRequest){
        String xReq = httpServletRequest.getHeader("x-request-with");
        return StringUtils.isNotBlank(xReq) && "XMLHttpRequest".equalsIgnoreCase(xReq);
    }
}
