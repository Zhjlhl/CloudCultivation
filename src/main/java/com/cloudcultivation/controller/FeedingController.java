package com.cloudcultivation.controller;

import com.cloudcultivation.po.Feeding;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.Orders;
import com.cloudcultivation.service.FeedingService;
import com.cloudcultivation.service.MerchantService;
import com.cloudcultivation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lzx
 */
@Controller
public class FeedingController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private FeedingService feedingService;
    @Autowired
    private MerchantService merchantService;

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

    private final String uploadPath = "O:\\Files\\软件工程\\云养殖系统\\源代码\\CloudCultivation\\src\\main\\webapp\\photos\\";
    /*
     * @description: 上传饲养信息
     */
    @PostMapping("/updateFeedOngoingInfo")
    public String updateFeedOngoingInfo(@RequestParam("orderId") int orderId,
                                        @RequestParam("photos") MultipartFile photos,
                                        @RequestParam("weight") double weight,
                                        @RequestParam("state") String state,
                                        Model model){

        Orders orders = ordersService.selectOrdersById(orderId);
        Feeding feeding = new Feeding();
        feeding.setOrders(orders);
        feeding.setState(state);
        feeding.setCheck("未审核");
        feeding.setWeight(weight);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        feeding.setDate(ts);
        if (!photos.isEmpty()){
            try {
                String fileName = photos.getOriginalFilename();
                String savePath = uploadPath + fileName;
                feeding.setPhoto("photos/"+fileName);
                photos.transferTo(new File(savePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int i = feedingService.addFeeding(feeding);
        if (i >0) {
            model.addAttribute("message", "更新成功");
        }else {
            model.addAttribute("message", "更新不成功");
        }
        Merchant merchant=merchantService.selectMerchantById(orders.getMerchant().getId());
        List<Orders> ordersList=new ArrayList<>();
        for(Orders orders1:merchant.getOrdersList()){
            if("养殖中ing".equals(orders1.getState())){
                ordersList.add(orders1);
            }
            /*ordersList.add(orders);*/
        }
        model.addAttribute("orders",ordersList);
        return "/merchant/feedOngoingOrder.jsp";
    }

}
