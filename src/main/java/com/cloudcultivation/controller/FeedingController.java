package com.cloudcultivation.controller;

import com.cloudcultivation.po.Orders;
import com.cloudcultivation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author lzx
 */
@Controller
public class FeedingController {

    @Autowired
    private OrdersService ordersService;


    /*
     * 页面跳转，到购买饲料页面
     */
    /*@RequestMapping("/toBuyFeed")
    public String toBuyFeed(){return "/buyFeed.jsp";}*/

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

    /*
     * @description: 跳转到所有订单
     */

    /*
     * @description: 跳转上传饲养信息
     */
    @GetMapping("/toUpdateFeedOngoingInfo")
    public String toUpdateFeedOngoingInfo(@RequestParam("orderId") int orderId,
                                          Model model){
        Orders orders = ordersService.selectOrdersById(orderId);
        model.addAttribute("order", orders);
        return "/merchant/update/updateFeedOngoingInfo.jsp";
    }

}
