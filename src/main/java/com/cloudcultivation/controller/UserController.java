package com.cloudcultivation.controller;

import com.cloudcultivation.po.Orders;
import com.cloudcultivation.service.OrdersService;
import com.cloudcultivation.service.UserService;
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

    //收获方式选择操作
    @RequestMapping("/applyForHarvest")
    public String applyForHarvest(@RequestParam("orderId") String orderId,@RequestParam("harvestWay") String harvestWay){
        //harvestWay值是(0,25,50,75,100)代表换成收益的百分比，设置orderId的order的收获方式，并更新订单数组到model并返回一个新的订单数组在model中到已完成订单页面用于显示
        return "/customer/feedOngoingOrder.jsp";
    }
    //跳转到这个饲养中订单的详细信息页面
    @RequestMapping("/toCustomerFeedGoodsInfo")
    public String toCustomerFeedGoodsInfo(@RequestParam("orderId") String orderId){
        //返回这个id的order到model中
        return "/customer/feedOngoingOrder.jsp";
    }
    //跳转到收获中订单
    @RequestMapping("/toHarvestOngoing")
    public String toHarvestOngoing(){
        //用session中的user信息获取收获中订单，并返回一个这个用户对应的harvest数组到model中用于前端展示
        return "/customer/harvestOngoing.jsp";
    }
    //用于收获中订单界面到applyForAfterSaleService.jsp申请界面的跳转
    @RequestMapping("/applyForAfterSaleService")
    public String applyForAfterSaleService(@RequestParam("orderId") String orderId){
        //返回这个id对应的order到model中
        return "/customer/applyForAfterSaleService.jsp";
    }
    //申请售后操作
    @RequestMapping("/resolveDispute")
    public String resolveDispute(@RequestParam("type") String type,@RequestParam("orderId") String orderId,@RequestParam("description") String description){
        //这个order要进行售后，type是(animalDeath,merchantMissing,userExitsMidway,merchantDefault,refundWithinSevenDaysWithoutReason,otherIssues)中的其中一个
        return "/customer/home.jsp";
    }
    //跳转到售后中页面
    @RequestMapping("/toDisputeOngoing")
    public String toDisputeOngoing(){
        //根据session中的user信息，找到售后中disputes数组存到model中，并返回
        return "/customer/disputeOngoing.jsp";
    }
    //根据orderId跳转到与客服聊天界面
    @RequestMapping("/toChatWithService")
    public String toChatWithService(@RequestParam("orderId") String orderId){
        return "/customer/chatWithService.jsp";
    }
    //跳转到待支付订单
    @RequestMapping("/toWaitingPaid")
    public String toWaitingPaid(){
        //根据session中的user信息，找到待支付订单orders数组存到model中，并返回
        return "/customer/waitingPaid.jsp";
    }
    //跳转到付款界面
    @RequestMapping("/pay")
    public String pay(@RequestParam("orderId") String orderId){
        //将session中的user的account减去这个order的goods的price，并返回一个更新后的待支付order数组到model中
        return "/customer/waitingPaid.jsp";
    }
    //跳转到待评价订单页面
    @RequestMapping("/toWaitingEvaluate")
    public String toWaitingEvaluation(){
        //根据session中的user信息，找到待评价订单orders数组存到model中，并返回
        return "/customer/WatingEvaluate.jsp";
    }
    //用于待评价订单页面提交订单并返回到待评价订单中
    @RequestMapping("/submitEvaluation2")
    public String submitEvaluation2(@RequestParam("orderId") String[] orderId,@RequestParam("evaluateState") String[] evaluateState){
        //多个订单的评价提交，每个状态对于这个orderid的order，设置remark为evaluateState，返回一个新的待评价order数组到model中
        return "/customer/waitingEvaluate.jsp";
    }
    //跳转到商城页面
    @RequestMapping("/toBuy")
    public String toBuy(){
        //返回一个商品goods数组添加到Model中用于展示
        return "/customer/buy.jsp";
    }

}
