package com.cloudcultivation.controller;


import com.cloudcultivation.po.User;
import com.cloudcultivation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jiejie
 */
@Controller
public class EntryController {

    @Autowired
    private UserService userService;

    /*
    * 页面跳转，到登录页面
    */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/enter/login.jsp";
    }

    /*
     * 页面跳转，到服务协议网页
     */
    @RequestMapping("/toInformation")
    public String toInformation(){
        return "/enter/information.jsp";
    }
    /*
     * 页面跳转，到注册页面
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "/enter/register.jsp";
    }

    /*用户登录判断*/
    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        if (userService.loginByAccountAndPassword(username, password)){
            User user = userService.selectUserByAccount(username);
            model.addAttribute("user", user);
            return "/enter/userDetails.jsp";
        }else {
            return "/enter/login.jsp";
        }
    }
}
