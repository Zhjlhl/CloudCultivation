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

/**
 * create by Su on 2023/12/30
 **/
@Controller
public class MerchantController {
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
    private FeedService feedService;
    @Autowired
    private HarvestService harvestService;

    /*
     * 页面跳转，到所有饲养订单页面
     */
    @RequestMapping("/toFeedOngoing")
    public String toFeedOngoingOrder(@RequestParam("merchantId") int merchantId,
                                     Model model){
        Merchant merchant=merchantService.selectMerchantById(merchantId);
        List<Orders> ordersList=merchant.getOrdersList();
        model.addAttribute("orders",ordersList);
        return "/merchant/feedOngoing.jsp";
    }

    /*
     * @lzx 页面跳转，到所有售后中订单
     */
    @RequestMapping("/toMerchantDisputeOngoingOrder")
    public String toMerchantDisputeOngoingOrder(@RequestParam("merchantId") int merchantId,
                                                Model model){
        Merchant merchant=merchantService.selectMerchantById(merchantId);
        List<Orders> ordersList = merchant.getOrdersList();
        List<Dispute> disputeList = new ArrayList<>();
        for (Orders orders : ordersList){
            for (Dispute dispute:orders.getDisputeList())
                if(!dispute.getState().equals("已解决")){
                    disputeList.add(dispute);
                }
        }
        model.addAttribute("disputes", disputeList);
        System.out.println(model);
        return "/merchant/disputeOngoingOrder.jsp";
    }

    /*
     *@lzx 实现修改商家个人信息
     */
    @RequestMapping("/updateMerchant")
    public String updateMerchant(int merchantId ,String name, String contacts, String description, String phone ,String password) {
        Merchant merchant=merchantService.selectMerchantById(merchantId);
        if (!merchant.getPassword().equals(password)){
            return "/merchant/updateFail.jsp";
        }
        else {
            merchant.setName(name);
            merchant.setContacts(contacts);
            merchant.setDescription(description);
            merchant.setPhone(phone);
            if(merchantService.updateMerchant(merchant)>0){
                return "/merchant/updateSuccess.jsp";
            }
            else {
                return "/merchant/updateFail.jsp";
            }
        }
    }

    @RequestMapping("/addFeed")
    public String addFeed(int merchantId, @RequestParam String name, @RequestParam int amount, @RequestParam BigDecimal price, @RequestParam String description) {
        Merchant merchant=merchantService.selectMerchantById(merchantId);
        Feed feed=new Feed();
        feed.setName(name);
        feed.setAmount(amount);
        feed.setPrice(price);
        feed.setRemain(amount);
        feed.setCheck("审核中");
        feed.setDescription(description);
        feed.setMerchant(merchant);
        if(feedService.addFeed(feed)>0){
            return "/merchant/updateSuccess.jsp";
        }
        else return "/merchant/updateFail.jsp";

    }

    /*
       @description:商家上传商品界面跳转商家主界面
       陈宇豪
        */
    @RequestMapping("/updateGoods")
    public String updateGoods(@RequestParam("name") String name,@RequestParam("type") String type,int merchantId,
                              @RequestParam("growth") String growth,@RequestParam("yield") String yield,
                              @RequestParam("amount") int amount,@RequestParam("price") BigDecimal price,
                              @RequestParam("description") String description){
        Goods good=new Goods();
        good.setName(name);
        good.setType(type);
        Merchant merchant=merchantService.selectMerchantById(merchantId);
        good.setMerchant(merchant);
        good.setPrice(price);
        good.setDescription(description);
        good.setGrowth(growth);
        good.setYield(yield);
        good.setAmount(amount);
        good.setRemain(amount);
        good.setCheck("审核中");
        goodsService.addGoods(good);
        return "/merchant/home.jsp";
    }
    /*
    @description:商家填写物流信息界面跳转商家收获中界面
    陈宇豪
     */
    @RequestMapping("/updateDelivery")
    public String updateDelivery(int harvestId,
                                 @RequestParam("number") String number,
                                 @RequestParam("delivery") String delivery,
                                 Model model){
        Harvest harvest=harvestService.selectHarvestById(harvestId);
        System.out.println(harvest.getDelivery());
        harvest.setNumber(number);
        harvest.setDelivery(delivery);
        harvest.setState("已发货");
        harvestService.updateHarvest(harvest);
        return "/merchant/home.jsp";
    }


}
