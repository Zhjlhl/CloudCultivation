package com.cloudcultivation.controller;


import com.cloudcultivation.po.Harvest;
import com.cloudcultivation.po.Orders;
import com.cloudcultivation.po.User;
import com.cloudcultivation.service.HarvestService;
import com.cloudcultivation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


    /*
     * @description: 页面跳转
     */
    @RequestMapping("/toHarvestInformation")
    public String toHarvestInformation(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        List<Harvest> harvestList = new ArrayList<>();
        for (Orders orders : user.getOrdersList()){
            harvestList.addAll(orders.getHarvestList());
        }
        httpSession.setAttribute("harvests", harvestList);
        return "customer/harvestOngoingOrder.jsp";
    }

}
