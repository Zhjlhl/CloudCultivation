package com.cloudcultivation.controller;


import com.cloudcultivation.po.Harvest;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.Orders;
import com.cloudcultivation.po.User;
import com.cloudcultivation.service.HarvestService;
import com.cloudcultivation.service.OrdersService;
import com.cloudcultivation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiejie
 */
@Controller
public class HarvestController {

    @Autowired
    private HarvestService harvestService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService ordersService;


    /**
     * @description: 页面跳转 回到商家页面
     */
    @RequestMapping("/toMerchantHome")
    public String toMerchantHome(){
        return "/merchant/home.jsp";
    }

    /*
     * @description: 跳转填写快递单号
     */
    @RequestMapping("/toMerchantUpdateDelivery")
    public String toMerchantUpdateDelivery(){
        return  "/merchant/update/updateDelivery.jsp";
    }

    /*
     * @description: 跳转到申请售后
     */
    @GetMapping("/toApplyForAfterSaleService")
    public String toApplyForAfterSaleService(@RequestParam(name = "harvestId") int harvestId,
                                             Model model) {
        Harvest harvest = harvestService.selectHarvestById(harvestId);
        model.addAttribute("orders", harvest.getOrders());
        return "/customer/applyForAfterSaleService.jsp";
    }


    /*
     * @description: 商家信息 页面跳转
     */
    @RequestMapping("/toMerchantHarvestInformation")
    public String toMerchantHarvestInformation(HttpSession httpSession){
        Merchant merchant = (Merchant) httpSession.getAttribute("merchant");
        List<Harvest> harvestList = new ArrayList<>();
        for (Orders orders : merchant.getOrdersList()){
            harvestList.addAll(orders.getHarvestList());
        }
        httpSession.setAttribute("harvests", harvestList);
        return "merchant/harvestOngoingOrder.jsp";
    }

    //用于已完成订单页面中的提交评价跳转到已完成订单页面
    @RequestMapping("/submitEvaluation")
    public String submitEvaluation(@RequestParam("orderId") int orderId,
                                   @RequestParam("evaluateState") String evaluateState,
                                   Model model){
        Orders orders = ordersService.selectOrdersById(orderId);
        orders.setRemark(evaluateState);
        ordersService.updateOrder(orders);
        User user = userService.selectUserById(orders.getUser().getId());
        model.addAttribute("orders", user.getOrdersList());
        return "/customer/finishedOrder.jsp";
    }



}
