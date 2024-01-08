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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("service", service);
        return "/service/uncheckDispute.jsp";
    }

    /*
     * @description: 提交纠纷处理结果
     */
    @RequestMapping("/checkDispute")
    public String checkDispute(@RequestParam("serviceId") int serviceId,
                               RedirectAttributes attributes,
                               Model model){
        /*return "redirect:/toServiceUncheck";*/
        /*Service service = serviceService.selectServiceById(serviceId);
        model.addAttribute("service", service);*/
        attributes.addAttribute("serviceId", serviceId);
        return "redirect:/toServiceDisputeOngoing";
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
            if (checkService.isGoodsUnChecked(goods)) {
                goodsList.add(goods);
            }
        }
        model.addAttribute("goods", goodsList);
        return "/service/checkGoods.jsp";
    }

    /*
     * @description: 实现通过商品审核
     */
    @RequestMapping("/passGoodsCheck")
    public String passGoodsCheck(@RequestParam("checkState") String checkState,
                                 @RequestParam("goodsId") int goodsId,
                                 Model model){
        Goods goods = goodsService.selectGoodsById(goodsId);
        if ("pass".equals(checkState)){
            goods.setCheck("已审核");
        }else {
            goods.setCheck("不通过");
        }
        int i = goodsService.updateGoods(goods);
        if (i >0) {
            model.addAttribute("message", "更新成功");
        }else {
            model.addAttribute("message", "更新不成功");
        }
        List<Goods> goodsList = new ArrayList<>();
        for (Goods good : goodsService.selectAllGoods()){
            if (checkService.isGoodsUnChecked(good)) {
                goodsList.add(good);
            }
        }
        model.addAttribute("goods", goodsList);
        return "/service/checkGoods.jsp";
    }

    /*
    *  跳转审核饲料
    * */
    @GetMapping("/toCheckFeed")
    public String toCheckFeed(Model model){
        List<Feed> feedList = new ArrayList<>();
        for (Feed feed : feedService.selectAllFeed()){
            if (checkService.isFeedUnChecked(feed)){
                feedList.add(feed);
            }
        }
        model.addAttribute("feeds", feedList);
        return "/service/checkFeed.jsp";
    }

    /*
     * @description: 审核饲料
     */
    @RequestMapping("/passFeedCheck")
    public String passFeedCheck(@RequestParam("checkState") String checkState,
                                @RequestParam("feedId") int feedId,
                                Model model){
        Feed feed = feedService.selectFeedById(feedId);
        if ("pass".equals(checkState)){
            feed.setCheck("已审核");
        }else {
            feed.setCheck("不通过");
        }
        int i = feedService.updateFeed(feed);
        if (i >0) {
            model.addAttribute("message", "更新成功");
        }else {
            model.addAttribute("message", "更新不成功");
        }
        List<Feed> feedList = new ArrayList<>();
        for (Feed feeds : feedService.selectAllFeed()){
            if (checkService.isFeedUnChecked(feeds)){
                feedList.add(feeds);
            }
        }
        model.addAttribute("feeds", feedList);
        return "/service/checkFeed.jsp";
    }


    /*
     * @description: 跳转处理纠纷页面
     */
    @GetMapping("/toCheck")
    public String toCheck(@RequestParam("disputeId") int disputeId,
                          Model model){
        Dispute dispute = disputeService.selectDisputeById(disputeId);
        model.addAttribute("dispute", dispute);
        return "/service/checkDispute.jsp";
    }


    /*
     * @description: 继续反馈问题
     */
    /*@GetMapping("/")*/
}
