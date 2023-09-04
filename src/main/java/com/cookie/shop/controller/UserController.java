package com.cookie.shop.controller;

import com.cookie.shop.pojo.User;
import com.cookie.shop.service.CartService;
import com.cookie.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    @Resource
    private CartService cartService;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @ModelAttribute
    public void bindRequest(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
    }

    @GetMapping(path = "/login")
    public String login(HttpServletRequest request) throws IOException {
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
            if (user.getIsadmin()){
                session.setAttribute("admin", "true");
            }

            Cookie cookie = new Cookie("user", user.getName());
            cookie.setPath(request.getServletPath());
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            return request.getContextPath() + "/index";
        }
        return "false";
    }

    @RequestMapping("/logout")
    public String logout(){
        // 删除登录token
        Cookie cookie = new Cookie("user", null);
        cookie.setPath(request.getServletPath());
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        // 删除session
        request.getSession().invalidate();

        return "index";
    }

    @RequestMapping("/closing")
    public String closing(){
        User user = (User) request.getSession().getAttribute("user");
        Integer id = user.getId();
        cartService.selectAll(id);

        return "/index";
    }

    @GetMapping("/register")
    public String registerPage(){
        // 不允许登陆后再注册
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            return "redirect:/index";
        }
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(String tel, String username, String password, String replace, String address, String email){


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(tel);

        try {
            request.setCharacterEncoding("UTF-8");
            address = request.getParameter("address");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        user.setName(username);
        System.out.println("提交数据"+address);
        user.setAddress(address);
        user.setIsadmin(false);

        int register = userService.register(user);
        if (register == 1){
            return "zhuceSucc";
        }
        return "register";
    }

}
