package com.cloudcultivation.controller;

import com.cloudcultivation.po.*;
import com.cloudcultivation.service.FeedService;
import com.cloudcultivation.service.MerchantService;
import com.cloudcultivation.service.OrdersService;
import com.cloudcultivation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiejie
 */
@Controller
public class UserController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private FeedService feedService;
    @Autowired
    private UserService userService;

    //跳转到这个饲养中订单的详细信息页面
    @RequestMapping("/toCustomerFeedGoodsInfo")
    public String toCustomerFeedGoodsInfo(@RequestParam("ordersId") int ordersId, Model model) {
        Orders orders = ordersService.selectOrdersById(ordersId);
        List<Feeding> list = orders.getFeedingList();
        Feeding feeding = list.get(list.size() - 1);
        Merchant merchant = orders.getMerchant();
        List<Feed> feeds = merchant.getFeedList();
        model.addAttribute("orders", orders);
        model.addAttribute("feeds", feeds);
        model.addAttribute("feeding", feeding);
        //返回这个id的order到model中
        return "/customer/feedGoodsInfo.jsp";
    }

    //购买饲料操作，跳转到购买饲料页面
    @RequestMapping("/toBuyFeed")
    public String toBuyFeed(@RequestParam("ordersId")int ordersId,Model model){
        //添加这个orderId对应的商家的所有种类饲料feeds到model中，和这个orderId对应的order添加到model中
        Orders orders = ordersService.selectOrdersById(ordersId);
        List<Feeding> list = orders.getFeedingList();
        Feeding feeding = list.get(list.size() - 1);
        Merchant merchant = orders.getMerchant();
        List<Feed> feeds = merchant.getFeedList();
        model.addAttribute("orders", orders);
        model.addAttribute("feeds", feeds);
        model.addAttribute("feeding", feeding);
        return "/customer/feedInfo.jsp";
    }
    //购买饲料操作，跳转到这个id对应的饲养宠物信息
    @RequestMapping("/buyFeed")
    public String buyFeed(@RequestParam("ordersId")int ordersId, @RequestParam("feedId")int feedId, @RequestParam("quantity")int quantity, Model model, HttpSession httpSession){
        //用户购买了feedId的饲料，quantity的数量，如果余额够,添加message=“购买成功”这个orderId的order，这个商家对应的饲料feeds到这个model中，并设置feeds的remain为用户拥有这个饲料的数量，对应的商家的余额增加，返回到"/customer/feedGoodsInfo.jsp";
        //如果余额不够，添加这个orderId对应的商家的所有种类饲料feeds到model中，和这个orderId对应的order添加到model中，生成待支付订单，添加message=“支付失败”到model中并返回到/customer/feedInfo.jsp
        Orders orders = ordersService.selectOrdersById(ordersId);
        User user = orders.getUser();
        Feed feeds = feedService.selectFeedById(feedId);
        Merchant merchant = orders.getMerchant();
        List<Feed> feed = merchant.getFeedList();
        BigDecimal temp = new BigDecimal(quantity);

        if(user.getBalance().compareTo(feeds.getPrice().multiply(temp)) < 0){
            model.addAttribute("feeds", feed);
            model.addAttribute("message","支付失败,余额不足！");
        }else{
            user.setBalance(user.getBalance().subtract(feeds.getPrice().multiply(temp)));
            feeds.setRemain(feeds.getRemain()-quantity);
            if(userService.updateUser(user)>0&&feedService.updateFeed(feeds)>0){
                User user2 = orders.getUser();
                httpSession.setAttribute("user", user2);
                Merchant merchant1 = orders.getMerchant();
                List<Feed> feed1 = merchant1.getFeedList();
                httpSession.setAttribute("feeds", feed1);
                model.addAttribute("feeds", feed1);
                model.addAttribute("message","购买成功！");
            }else{
                model.addAttribute("feeds", feed);
                model.addAttribute("message","支付失败,请稍后重试！");
            }
        }
        model.addAttribute("orders", orders);
        return "/customer/feedInfo.jsp";
    }










    //用于商城界面的小种类搜索功能
    @RequestMapping("/selectBySearch")
    public String selectBySearch(@RequestParam("name") String name){
        //type=('植物'，‘动物’)其中之一用于挑选,返回goods的name==name的值的goods数组添加到model中
        return "/customer/buy.jsp";
    }
    //用于商城界面的大种类挑选功能
    @RequestMapping("/selectByClassification")
    public String selectByClassification(@RequestParam("type") String type){
        //type=('植物'，‘动物’)其中之一用于挑选,返回goods的type==type的值的goods数组添加到model中
        return "/customer/buy.jsp";
    }




    //投喂操作
    @RequestMapping("/feed")
    public String feed(@RequestParam("feedId")String feedId,@RequestParam("orderId")String orderId){
        //用户用feedId的饲料对orderId这个order进行了投喂操作，这个order的今日状态应该是待投喂这个饲料，，用户拥有的这个饲料数量应该减1
        //添加message=“投喂申请发送成功！”到model中，已经更新这个
        return "/customer/feedGoodsInfo.jsp";
    }

}
