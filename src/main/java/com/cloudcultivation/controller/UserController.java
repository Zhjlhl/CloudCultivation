package com.cloudcultivation.controller;

import com.cloudcultivation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Jiejie
 */
@Controller
public class UserController {

    @Autowired
    OrdersService ordersService;

    /*
    跳转到已完成订单
     */
    @RequestMapping("/toCustomerFinished")
    public String toCustomerFinished(){
        //用session中的user信息获取已完成订单数组，并返回已完成订单数组到model用于前端展示
        return "/customer/finishedOrder.jsp";
    }

    @RequestMapping("/submitEvaluation")
    public String submitEvaluation(@RequestParam("orderId") String orderId, @RequestParam("evaluateState") String evaluateState){
        //用orderId搜索order,并设置这个order的评价状态为evaluateState，并更新订单数组并返回一个新的订单数组到到model并跳转到已完成订单页面用于显示
        return "/customer/finishedOrder.jsp";
    }

    @RequestMapping("/toCustomerHome")
    public String toCustomerHome(){
        //用orderId搜索order,并设置这个order的评价状态为evaluateState，并更新订单数组并返回一个新的订单数组到model并跳转已完成订单页面用于显示
        return "/customer/home.jsp";
    }

    @RequestMapping("/toFeedOngoing")
    public String toFeedOngoing(){
        //用session中的user信息获取饲养中订单，并在model中返回一个饲养中订单数组到model用于前端展示
        return "/customer/feedOngoingOrder.jsp";
    }

    @RequestMapping("/applyForHarvest")
    public String applyForHarvest(@RequestParam("orderId1") String orderId,@RequestParam("harvestWay") String harvestWay){
        //harvestWay值是(0,25,50,75,100)代表换成收益的百分比，设置orderId的order的收获方式，并更新订单数组到model并返回一个新的订单数组在model中到已完成订单页面用于显示
        return "/customer/feedOngoingOrder.jsp";
    }

    @RequestMapping("/toCustomerFeedGoodsInfo")
    public String toCustomerFeedGoodsInfo(@RequestParam("orderId2") String orderId){
        //返回这个id的order到model中
        return "/customer/feedOngoingOrder.jsp";
    }

    @RequestMapping("/toHarvestOngoing")
    public String toHarvestOngoing(){
        //用session中的user信息获取饲养中订单，并返回一个这个用户对应的harvest数组到model中用于前端展示
        return "/customer/harvestOngoing.jsp";
    }

    //用于收获中订单界面到applyForAfterSaleService.jsp申请界面的跳转
    @RequestMapping("/applyForAfterSaleService")
    public String applyForAfterSaleService(@RequestParam("orderId1") String orderId){
        //返回这个id对应的order到model中

        return "/customer/applyForAfterSaleService.jsp";
    }
}
