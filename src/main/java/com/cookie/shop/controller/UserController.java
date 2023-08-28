package com.cookie.shop.controller;

import com.cookie.shop.pojo.User;
import com.cookie.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * @author:             HONOR
 * @date:               2023/7/26 22:03
 * @project_name:       SSM
 * @class_description:
 */
@Controller
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @GetMapping(path = "/login")
    public String login(HttpServletRequest request) throws IOException {
        String requestType = request.getMethod();
        return "login";
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public Object checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName() != null && cookie.equals("user")){
                // token验证
                return request.getContextPath() + "/index";
            }
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.login(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);


            Cookie cookie = new Cookie("user", user.getName());
            cookie.setPath(request.getServletPath());
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            return request.getContextPath() + "/index";
        }
        return "false";
    }

}
