package com.cloudcultivation.controller;

import com.cloudcultivation.po.*;
import com.cloudcultivation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyy
 */
@Controller
public class UserController {

    @Autowired
    private AdoptService adoptService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    MerchantService merchantService;
    @Autowired
    FeedService feedService;
    @Autowired
    UserService userService;
    @Autowired
    BuyService buyService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    DisputeService disputeService;
    @Autowired
    ServiceService serviceService;

    //跳转到这个饲养中订单的详细信息页面
    @RequestMapping("/toCustomerFeedGoodsInfo")
    public String toCustomerFeedGoodsInfo(@RequestParam("ordersId") int ordersId, Model model) {
        Orders orders = ordersService.selectOrdersById(ordersId);
        List<Buy> buy = orders.getBuyList();
        List<Feeding> list = orders.getFeedingList();
        Feeding feeding = list.get(list.size() - 1);
        Merchant merchant = orders.getMerchant();
        model.addAttribute("orders", orders);
        model.addAttribute("feeds", buy);
        model.addAttribute("feeding", feeding);
        //返回这个id的order到model中
        return "/customer/feedGoodsInfo.jsp";
    }

    //购买饲料操作，跳转到购买饲料页面
    @RequestMapping("/toBuyFeed")
    public String toBuyFeed(@RequestParam("ordersId") int ordersId, Model model) {
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
    public String buyFeed(@RequestParam("ordersId") int ordersId, @RequestParam("feedId") int feedId, @RequestParam("quantity") int quantity, Model model, HttpSession httpSession) {
        //用户购买了feedId的饲料，quantity的数量，如果余额够,添加message=“购买成功”这个orderId的order，这个商家对应的饲料feeds到这个model中，并设置feeds的remain为用户拥有这个饲料的数量，对应的商家的余额增加，返回到"/customer/feedGoodsInfo.jsp";
        //如果余额不够，添加这个orderId对应的商家的所有种类饲料feeds到model中，和这个orderId对应的order添加到model中，生成待支付订单，添加message=“支付失败”到model中并返回到/customer/feedInfo.jsp
        Orders orders = ordersService.selectOrdersById(ordersId);
        User user = orders.getUser();
        Feed feeds = feedService.selectFeedById(feedId);
        Merchant merchant = orders.getMerchant();
        List<Feed> feed = merchant.getFeedList();
        BigDecimal temp = new BigDecimal(quantity);
        Buy buy = new Buy();
        buy.setFeed(feeds);
        buy.setRemain(quantity);
        buy.setAmount(quantity);
        buy.setDescription(feeds.getDescription());
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        buy.setDate(ts);
        buy.setPaymentState("已支付");
        buy.setPaymentAmount(feeds.getPrice().multiply(temp));
        buy.setOrders(orders);

        if (user.getBalance().compareTo(feeds.getPrice().multiply(temp)) < 0) {
            model.addAttribute("feeds", feed);
            model.addAttribute("message", "支付失败,余额不足！");
        } else {
            user.setBalance(user.getBalance().subtract(feeds.getPrice().multiply(temp)));
            feeds.setRemain(feeds.getRemain() - quantity);
            if (userService.updateUser(user) > 0 && feedService.updateFeed(feeds) > 0 && buyService.addBuy(buy) > 0) {
                User user2 = orders.getUser();
                httpSession.setAttribute("user", user2);
                Merchant merchant1 = orders.getMerchant();
                List<Feed> feed1 = merchant1.getFeedList();
                httpSession.setAttribute("feeds", feed1);
                model.addAttribute("feeds", feed1);
                model.addAttribute("message", "购买成功！");
            } else {
                model.addAttribute("feeds", feed);
                model.addAttribute("message", "支付失败,请稍后重试！");
            }
        }
        model.addAttribute("orders", orders);
        return "/customer/feedInfo.jsp";
    }


    //用于商城界面的小种类搜索功能
    @RequestMapping("/selectBySearch")
    public String selectBySearch(@RequestParam("name") String name,@RequestParam("userId") int userId, Model model) {
        //type=('植物'，‘动物’)其中之一用于挑选,返回goods的name==name的值的goods数组添加到model中
        //返回一个商品goods数组添加到Model中用于展示
        User user = userService.selectUserById(userId);
        List<Goods> goodsList = adoptService.selectGoodsByName(name);
        model.addAttribute("goods", goodsList);
        return "/customer/buy.jsp";
    }

    //用于商城界面的大种类挑选功能
    @RequestMapping("/selectByClassification")
    public String selectByClassification(@RequestParam("type") String type) {
        //type=('植物'，‘动物’)其中之一用于挑选,返回goods的type==type的值的goods数组添加到model中
        return "/customer/buy.jsp";
    }


    //投喂操作
    @RequestMapping("/feed")
    public String feed(@RequestParam("buyId") int buyId, @RequestParam("userId") int userId, Model model) {
        //用户用feedId的饲料对orderId这个order进行了投喂操作，这个order的今日状态应该是待投喂这个饲料，，用户拥有的这个饲料数量应该减1
        //添加message=“投喂申请发送成功！”到model中，已经更新这个
        Buy buy = buyService.selectBuyById(buyId);
        buy.setRemain(buy.getRemain() - 1);
        //添加这个orderId对应的商家的所有种类饲料feeds到model中，和这个orderId对应的order添加到model中

        if (buy.getRemain() == 0) {
            Orders orders1 = buy.getOrders();
            if (buyService.deleteBuyById(buyId) > 0) {
                String message = "投喂成功";
                model.addAttribute("message", message);
                Buy buy2 = orders1.getBuyList().get(0);
                Buy buy3 = buyService.selectBuyById(buy2.getId());
                Orders orders = buy3.getOrders();
                List<Buy> buys = orders.getBuyList();
                List<Feeding> list = orders.getFeedingList();
                Feeding feeding = new Feeding();
                if (list.isEmpty()){
                    feeding =null;
                }else {
                    feeding = list.get(list.size() - 1);
                }

                Merchant merchant = orders.getMerchant();
                model.addAttribute("orders", orders);
                model.addAttribute("feeds", buys);
                model.addAttribute("feeding", feeding);
                return "/customer/feedGoodsInfo.jsp";
            } else {
                String message = "投喂失败";
                model.addAttribute("message", message);
                return "/customer/feedGoodsInfo.jsp";
            }
        } else {

            if (buyService.updateBuy(buy) > 0) {
                String message = "投喂成功";
                model.addAttribute("message", message);
                Buy buy2 = buyService.selectBuyById(buyId);
                Orders orders = buy2.getOrders();
                List<Buy> buys = orders.getBuyList();
                List<Feeding> list = orders.getFeedingList();
                Feeding feeding = list.get(list.size() - 1);
                Merchant merchant = orders.getMerchant();
                model.addAttribute("orders", orders);
                model.addAttribute("feeds", buys);
                model.addAttribute("feeding", feeding);
            } else {
                String message = "投喂失败";
                model.addAttribute("message", message);
            }
            return "/customer/feedGoodsInfo.jsp";
        }


    }
    @RequestMapping("/toResolveDispute")
    public String resolveDispute(@RequestParam("orderId")int orderId,@RequestParam("radio") String type,@RequestParam("description") String description,Model model){
        Dispute dispute = new Dispute();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Service service = serviceService.selectServiceById(10000);
        dispute.setDate(ts);
        dispute.setService(service);
        dispute.setState("未处理");
        dispute.setType(type);
        dispute.setCheck("未审核");
        dispute.setMan("用户");
        Orders orders = ordersService.selectOrdersById(orderId);
        dispute.setOrders(orders);
        dispute.setDescription(description);
        if(disputeService.addDispute(dispute)>0){
            String message = "申请成功";
            model.addAttribute("message1", message);
        }else{
            String message = "申请失败";
            model.addAttribute("message1", message);
        }
        Orders orders1 = ordersService.selectOrdersById(orderId);
        User user = orders1.getUser();
        List<Harvest> harvestList = new ArrayList<>();
        for (Orders orders2 : user.getOrdersList()){
            harvestList.addAll(orders2.getHarvestList());
        }
        model.addAttribute("harvests", harvestList);
        return "customer/harvestOngoingOrder.jsp";
    }
    @RequestMapping("/toDispute")
    public String toDispute(@RequestParam("userId") int userId,Model model){
        User user = userService.selectUserById(userId);
        List<Orders> orders = user.getOrdersList();
        List<Dispute> disputeList = new ArrayList<>();
        for(Orders orders1 : orders){
            List<Dispute> disputeList1=orders1.getDisputeList();
            disputeList.addAll(disputeList1);
        }
        model.addAttribute("disputes",disputeList);
        return "customer/disputeOngoingOrder.jsp";
    }
    @GetMapping("/toApplyForAfterSaleService2")
    public String toApplyForAfterSaleService2(@RequestParam(name = "orderId") int orderId,
                                              Model model) {
        Orders orders = ordersService.selectOrdersById(orderId);
        model.addAttribute("orders", orders);
        return "/customer/applyForAfterSaleService2.jsp";
    }
    @RequestMapping("/toResolveDispute2")
    public String resolveDispute2(@RequestParam("orderId")int orderId,@RequestParam("radio") String type,@RequestParam("description") String description,Model model){
        Dispute dispute = new Dispute();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Service service = serviceService.selectServiceById(10000);
        dispute.setDate(ts);
        dispute.setService(service);
        dispute.setState("未处理");
        dispute.setType(type);
        dispute.setCheck("未审核");
        dispute.setMan("用户");
        Orders orders = ordersService.selectOrdersById(orderId);
        dispute.setOrders(orders);
        dispute.setDescription(description);
        if(disputeService.addDispute(dispute)>0){
            String message = "申请成功";
            model.addAttribute("message1", message);
        }else{
            String message = "申请失败";
            model.addAttribute("message1", message);
        }
        Orders orders1 = ordersService.selectOrdersById(orderId);
        User user = orders1.getUser();
        List<Orders> orders2 = user.getOrdersList();
        List<Dispute> disputeList = new ArrayList<>();
        for(Orders orders3 : orders2){
            List<Dispute> disputeList1=orders3.getDisputeList();
            disputeList.addAll(disputeList1);
        }
        model.addAttribute("disputes",disputeList);
        return "customer/disputeOngoingOrder.jsp";
    }
}
