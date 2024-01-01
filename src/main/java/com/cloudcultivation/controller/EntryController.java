package com.cloudcultivation.controller;


import com.cloudcultivation.po.*;
import com.cloudcultivation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiejie
 */
@Controller
public class EntryController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private ServiceService serviceService;

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


    /*
     * @description: 用户的跳转
     */
    /*
     * @description: 页面跳转到用户主界面
     */
    @GetMapping("/toUserHome")
    public String toUserHome(){
        return "/customer/home.jsp";
    }

    /*
    跳转到用户已完成订单
     */
    @GetMapping ("/toUserFinished")
    public String toUserFinished(@RequestParam("userId") int userId,
                                 Model model){
        User user = userService.selectUserById(userId);
        model.addAttribute("orders", user.getOrdersList());
        return "/customer/finishedOrder.jsp";
    }

    //跳转到饲养中订单页面
    @GetMapping("/toUserFeedOngoing")
    public String toUserFeedOngoing(){
        //用session中的user信息获取饲养中订单，并在model中返回一个饲养中订单数组到model用于前端展示
        return "/customer/feedOngoingOrder.jsp";
    }

    /*
     * @description: 用户页面跳转
     */
    @RequestMapping("/toUserHarvestInformation")
    public String toUserHarvestInformation(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        List<Harvest> harvestList = new ArrayList<>();
        for (Orders orders : user.getOrdersList()){
            harvestList.addAll(orders.getHarvestList());
        }
        httpSession.setAttribute("harvests", harvestList);
        return "customer/harvestOngoingOrder.jsp";
    }

    /*
     * @description: 页面跳转到商家主界面
     */
    @GetMapping("/toMerchantHome")
    public String toMerchantHome(){
        return "/merchant/home.jsp";
    }

    /*
     * @description: 页面跳转到客服主界面
     */
    @GetMapping("/toServiceHome")
    public String toServiceHome(){
        return "/service/home.jsp";
    }

    /*
     * @description: 页面跳转到管理员主界面
     */
    @GetMapping("/toAdministratorHome")
    public String toAdministratorHome(){
        return "/administrator/home.jsp";
    }

    /*用户登录判断*/
    @RequestMapping("/login")
    public String login(String account, String password, String type, HttpSession httpSession) {
        boolean isRight = loginService.loginByAccountAndPassword(account, password, type);
        if (isRight) {
            if ("user".equals(type)) {
                User user = userService.selectUserByAccount(account);
                httpSession.setAttribute("user", user);
                return "/customer/home.jsp";
            } else if ("merchant".equals(type)) {
                Merchant merchant = merchantService.selectMerchantByAccount(account);
                httpSession.setAttribute("merchant", merchant);
                return "/merchant/home.jsp";
            } else if ("service".equals(type)) {
                Service service = serviceService.selectServiceByAccount(account);
                httpSession.setAttribute("service", service);
                return "/service/home.jsp";
            } else if ("administrator".equals(type)) {
                Administrator administrator = administratorService.selectAdministratorByAccount(account);
                httpSession.setAttribute("administrator", administrator);
                return "/administrator/home.jsp";
            }
        }
        return "/enter/login.jsp";
    }
}
