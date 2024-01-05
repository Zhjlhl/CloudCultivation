package com.cloudcultivation.controller;

import com.cloudcultivation.po.Dispute;
import com.cloudcultivation.po.Feed;
import com.cloudcultivation.po.Goods;
import com.cloudcultivation.po.Service;
import com.cloudcultivation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiejie
 */
@Controller
public class DisputeController {

    @Autowired
    private DisputeService disputeService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private FeedService feedService;
    @Autowired
    private CheckService checkService;

    /*
     * @description: 跳转未审核订单
     */
    @GetMapping("/toServiceUncheck")
    public String toServiceUncheck(@RequestParam("serviceId") int serviceId,
                                   Model model){
        Service service = serviceService.selectServiceById(serviceId);
        List<Dispute> disputeList = new ArrayList<>();
        for (Dispute dispute: service.getDisputeList()){
            if (!disputeService.isDisputeResolve(dispute)){
                disputeList.add(dispute);
            }
        }
        model.addAttribute("disputes", disputeList);
        return "/service/uncheckDispute.jsp";
    }

    /*
     * @description: 跳转审核商品
     */
    @GetMapping("/toCheckGoods")
    public String toCheckGoods(@RequestParam("serviceId") int serviceId,
                               Model model){
        Service service = serviceService.selectServiceById(serviceId);
        List<Goods> goodsList = new ArrayList<>();
        for (Goods goods : goodsService.selectAllGoods()){
            if (!checkService.isGoodsChecked(goods)) {
                goodsList.add(goods);
            }
        }
        model.addAttribute("goods", goodsList);
        return "/service/checkGoods.jsp";
    }

    /*
     * @description: 实现通过商品审核
     */


    /*
    *  跳转审核饲料
    * */
    @GetMapping("/toCheckFeed")
    public String toCheckFeed(@RequestParam("serviceId") int serviceId,
                              Model model){
        Service service = serviceService.selectServiceById(serviceId);
        List<Feed> feedList = feedService.selectAllFeed();
        model.addAttribute("feeds", feedList);
        return "/service/checkFeed.jsp";
    }

}
