package com.cloudcultivation.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author lzx
 */
public class FeedingController {



    /*
     * 页面跳转，到购买饲料页面
     */
    @RequestMapping("/toBuyFeed")
    public String toBuyFeed(){return "/buyFeed.jsp";}

    /*
     * 页面跳转，到支付页面
     */
    @RequestMapping("/toPurchase")
    public String toPurchase(){
        return "/purchase.jsp";
    }

    /*查看饲养动物的图片*/
    @RequestMapping("/seeMore/{fileName}.{suffix}")
    public String seeMore(@PathVariable("fileName") String fileName,
                          @PathVariable("suffix") String suffix,
                          HttpServletResponse response){
        //File imgFile = new File(Constants)
        return "/customer/seePhotos.jsp";
    }


}
