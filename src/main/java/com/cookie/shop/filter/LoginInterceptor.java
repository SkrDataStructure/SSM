package com.cookie.shop.filter;

/*
 * @author:             HONOR
 * @date:               2023/8/31 10:44
 * @project_name:       SSM
 * @class_description:
 */

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null){
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        return true;
    }
}
