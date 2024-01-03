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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author lzx
 */
@Controller
public class AdoptController {
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
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private AdoptService adoptService;

    /*
     * 页面跳转，到购认养面
     */
    @RequestMapping("/toAdopt")
    public String toAdopt(@RequestParam("userId") int userId,@RequestParam("goodsId") int goodsId,
                          Model model){
        User user = userService.selectUserById(userId);
        Goods goods = goodsService.selectGoodsById(goodsId);
        model.addAttribute("user",user);
        model.addAttribute("goods",goods);

        if(user.getBalance().compareTo(goods.getPrice()) < 0){
            return "/customer/pay.jsp";
        }else {
            return "/customer/viewDetails.jsp";}
    }


    /*
     * 页面跳转，到支付页面
     */
    @RequestMapping("/toBuyGoods")
    public String toPay(@RequestParam("userId") int userId,@RequestParam("goodsId") int goodsId,
                        Model model, HttpSession httpSession){
        User user = userService.selectUserById(userId);
        Goods goods = goodsService.selectGoodsById(goodsId);
        model.addAttribute("user",user);
        model.addAttribute("goods",goods);
        if(adoptService.paymentGoodsByPassword(userId,goodsId)){
            User user2 = userService.selectUserById(userId);
            Goods goods2 = goodsService.selectGoodsById(goodsId);
            httpSession.setAttribute("user", user2);
            httpSession.setAttribute("goods", goods2);
            return "/customer/adoptSuccess.jsp";
        }else{
            User user2 = userService.selectUserById(userId);
            Goods goods2 = goodsService.selectGoodsById(goodsId);
            httpSession.setAttribute("user", user2);
            httpSession.setAttribute("goods", goods2);
            return "/customer/adoptFail.jsp";
        }

    }

    @RequestMapping("/toCharge")
    public String toCharge(@RequestParam("userId") int userId,@RequestParam("operate")String operate, @RequestParam("amount")int number,Model model,HttpSession httpSession){
        if(Objects.equals(operate, "我已完成支付")){
        User user = userService.selectUserById(userId);
        BigDecimal temp = user.getBalance();
        BigDecimal temp2 = new BigDecimal(number);
        user.setBalance(temp.add(temp2));
        if(userService.updateUser(user)==0){
            User user2 = userService.selectUserById(userId);
            httpSession.setAttribute("user", user2);
            return "/customer/chargeFail.jsp";
        }
        User user2 = userService.selectUserById(userId);
        httpSession.setAttribute("user", user2);
        model.addAttribute(user);
        return "/customer/chargeSuccess.jsp";
    }else{
            return "/toUserHome";
        }
    }





}
