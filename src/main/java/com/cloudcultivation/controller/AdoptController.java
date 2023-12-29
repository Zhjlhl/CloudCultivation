package com.cloudcultivation.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzx
 */
public class AdoptController {
    /*
     * 页面跳转，到购认养面
     */
    @RequestMapping("/toAdopt")
    public String toAdopt(){
        return "/adopt.jsp";
    }

    /*
     * 页面跳转，到购买商品页面
     */
    @RequestMapping("/toBuyGoods")
    public String toBuyGoods(){return "/buyGoods.jsp";}

    /*
     * 页面跳转，到支付页面
     */
    @RequestMapping("/toPurchase")
    public String toPurchase(){return "/purchase.jsp";}


}
