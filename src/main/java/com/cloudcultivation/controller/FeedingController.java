package com.cloudcultivation.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzx
 */
public class FeedingController {
    /*
     * 页面跳转，到购认养面
     */
    @RequestMapping("/toFeeding")
    public String toFeeding(){
        return "/feeding.jsp";
    }

    /*
     * 页面跳转，到购买饲料页面
     */
    @RequestMapping("/toBuyFeed")
    public String toBuyFeed(){return "/buyFeed.jsp";}

    /*
     * 页面跳转，到支付页面
     */
    @RequestMapping("/toPurchase")
    public String toPurchase(){return "/purchase.jsp";}


}
