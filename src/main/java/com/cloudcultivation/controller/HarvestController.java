package com.cloudcultivation.controller;


import com.cloudcultivation.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jiejie
 */
@Controller
public class HarvestController {

    @Autowired
    private HarvestService harvestService;


    /*
     * @description: 页面跳转
     */
    @RequestMapping("/toHarvestInformation")
    public String toHarvestInformation(){
        return "customer/harvestOngoingOrder.jsp";
    }

}
