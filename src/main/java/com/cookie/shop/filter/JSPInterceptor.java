package com.cookie.shop.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author:             HONOR
 * @date:               2023/9/4 16:58
 * @project_name:       SSM
 * @class_description:
 */
public class JSPInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求路径"+request.getRequestURI());
        request.getRequestDispatcher(request.getRequestURI() + ".jsp").forward(request, response);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
