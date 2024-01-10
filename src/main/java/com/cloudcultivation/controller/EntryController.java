package com.cloudcultivation.controller;


import com.cloudcultivation.po.*;
import com.cloudcultivation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiejie
 */
@Controller
public class EntryController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private HarvestService harvestService;

    /*
    * 页面跳转，到登录页面
    */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/enter/login.jsp";
    }

    /*
     * 页面跳转，到服务协议网页
     */
    @RequestMapping("/toInformation")
    public String toInformation(){
        return "/enter/information.jsp";
    }
    /*
     * 页面跳转，到注册页面
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "/enter/register.jsp";
    }


    /*
     * @description: 用户的跳转
     */
    /*
     * @description: 页面跳转到用户主界面
     */
    @GetMapping("/toUserHome")
    public String toUserHome(){
        return "/customer/home.jsp";
    }

    //跳转到商城页面
    @RequestMapping("/toBuy")
    public String toBuy(@RequestParam("userId") int userId,
                        Model model){
        //返回一个商品goods数组添加到Model中用于展示
        User user = userService.selectUserById(userId);
        List<Goods> goodsList = goodsService.selectAllGoods();
        /*尝试图片显示*/
        String filePath = "O:\\Files\\图片";

        model.addAttribute("goods", goodsList);
        return "/customer/buy.jsp";
    }
    /*
    跳转到用户已完成订单
     */
    @GetMapping ("/toUserFinished")
    public String toUserFinished(@RequestParam("userId") int userId,
                                 Model model){
        User user = userService.selectUserById(userId);
        model.addAttribute("orders", user.getOrdersList());
        return "/customer/finishedOrder.jsp";
    }

    //跳转到饲养中订单页面
    @GetMapping("/toUserFeedOngoing")
    public String toUserFeedOngoing(@RequestParam("userId") int userId,
                                    Model model){
        //并在model中返回一个饲养中订单数组到model用于前端展示
        User user = userService.selectUserById(userId);
        List<Orders> ordersList = new ArrayList<>();
        for (Orders orders : user.getOrdersList()){
            if (ordersService.isOnGoing(orders)){
                orders.setRemainDay(ordersService.setRemainDay(orders));
                ordersList.add(orders);
            }
        }
        model.addAttribute("orders", ordersList);
        return "/customer/feedOngoingOrder.jsp";
    }

    /*
     * @description: 用户页面跳转
     */
    @RequestMapping("/toUserHarvestInformation")
    public String toUserHarvestInformation(@RequestParam("userId") int userId,
                                           Model model){
        User user = userService.selectUserById(userId);
        List<Harvest> harvestList = new ArrayList<>();
        for (Orders orders : user.getOrdersList()){
            harvestList.addAll(orders.getHarvestList());
        }
        model.addAttribute("harvests", harvestList);
        return "customer/harvestOngoingOrder.jsp";
    }

    //跳转到用户售后中页面
    @RequestMapping("/toDisputeOngoing")
    public String toDisputeOngoing(@RequestParam("userId") int userId,
                                   Model model){
        //根据session中的user信息，找到售后中disputes数组存到model中，并返回
        User user = userService.selectUserById(userId);
        List<Orders> ordersList = user.getOrdersList();
        List<Dispute> disputeList = new ArrayList<>();
        for (Orders orders : ordersList){
            disputeList.addAll(orders.getDisputeList());
        }
        model.addAttribute("disputes", disputeList);
        return "/customer/disputeOngoingOrder.jsp";
    }

    //跳转到待支付订单
    @RequestMapping("/toWaitingPaid")
    public String toWaitingPaid(@RequestParam("userId") int userId,
                                Model model){
        //根据session中的user信息，找到待支付订单orders数组存到model中，并返回
        User user = userService.selectUserById(userId);
        List<Orders> ordersList = new ArrayList<>();
        for (Orders orders:user.getOrdersList()){
            if (ordersService.isReadyForPaid(orders)){
                ordersList.add(orders);
            }
        }
        model.addAttribute("orders", ordersList);
        model.addAttribute("user", user);
        return "/customer/waitingPaid.jsp";
    }

    /*
     * @description: 页面跳转到商家主界面
     */
    @GetMapping("/toMerchantHome")
    public String toMerchantHome(){
        return "/merchant/home.jsp";
    }

    /*
     * @description: 页面跳转到客服主界面
     */
    @GetMapping("/toServiceHome")
    public String toServiceHome(){
        return "/service/home.jsp";
    }

    /*
     * @lzx: 页面跳转到修改个人信息
     */
    @GetMapping("/toMerchantUpdateSelfInfo")
    public String toMerchantUpdateSelfInfo(){
        return "/merchant/update/updateSelfInfo.jsp";
    }

    /*
     * @lzx: 页面跳转到所有售后订单
     */
    @GetMapping("/toMerchantDisputeOrder")
    public String toMerchantDisputeOrder(@RequestParam("merchantId") int merchantId,
                                         Model model){
        Merchant merchant=merchantService.selectMerchantById(merchantId);
        List<Orders> ordersList = merchant.getOrdersList();
        List<Dispute> disputeList = new ArrayList<>();
        for (Orders orders : ordersList){
            disputeList.addAll(orders.getDisputeList());
        }
        model.addAttribute("disputes", disputeList);
        //System.out.println(model);
        return "/merchant/allDisputeOrder.jsp";
    }

    /*
     * @lzx: 页面跳转到饲养中订单
     */
    @GetMapping("/toMerchantFeedOngoingOrder")
    public String toMerchantFeedOngoingOrder(@RequestParam("merchantId") int merchantId,
                                             Model model){
        Merchant merchant=merchantService.selectMerchantById(merchantId);
        List<Orders> ordersList=new ArrayList<>();
        for(Orders orders:merchant.getOrdersList()){
            if("养殖中ing".equals(orders.getState())){
                ordersList.add(orders);
            }
            /*ordersList.add(orders);*/
        }
        model.addAttribute("orders",ordersList);
        return "/merchant/feedOngoingOrder.jsp";
    }

    /*
     * @lzx: 页面跳转到所有审核中饲料
     */
    @GetMapping("/toMerchantFeedCheck")
    public String toMerchantFeedCheck(@RequestParam("merchantId") int merchantId,
                                      Model model){
        Merchant merchant=merchantService.selectMerchantById(merchantId);
        model.addAttribute("feeds",merchant.getFeedList());
        return "/merchant/feedCheck.jsp";

    }

    /*
     * @lzx: 页面跳转到上传饲料
     */
    @GetMapping("/toMerchantUpdateFeed")
    public String toMerchantUpdateFeed(@RequestParam("merchantId") int merchantId,
                                       Model model){
        return "/merchant/update/updateFeed.jsp";

    }



    /*
     * @商家主页面跳转到已结束订单界面
     * 陈宇豪
     */
    @GetMapping("/toMerchantFinished")
    public String toMerchantFinished(@RequestParam("merchantId") int merchantId,
                                     Model model){
        Merchant merchant = merchantService.selectMerchantById(merchantId);
        List<Orders> ordersList=new ArrayList<>();
        for(Orders orders:merchant.getOrdersList()){
            if("已结束".equals(orders.getState())) {
                ordersList.add(orders);
            }
        }
        model.addAttribute("orders", ordersList);
        return "/merchant/finishedOngoingOrder.jsp";
    }
    /*
     * @商家主页面跳转到收获中订单界面
     * 陈宇豪
     */
    @GetMapping("/toMerchantHarvestOngoingOrder")
    public String toMerchantHarvestOngoingOrder(@RequestParam("merchantId") int merchantId,
                                                Model model){
        Merchant merchant = merchantService.selectMerchantById(merchantId);
        List<Orders> ordersList=merchant.getOrdersList();
        List<Harvest>harvestList=new ArrayList<>();
        for (Orders order:ordersList){
            /*Harvest harvest = new Harvest();
            if(harvestService.selectHarvestByOrdersId(order.getId())!=null) {
                harvest=harvestService.selectHarvestByOrdersId(order.getId());
            } else {
                continue;
            }
            if(!"已结束".equals(harvest.getState())){
                harvestList.add(harvest);
            }*/
            for (Harvest harvest:order.getHarvestList()){
                if (!"已结束".equals(harvest.getState())){
                    harvestList.add(harvest);
                }
            }
        }
        model.addAttribute("harvests", harvestList);

        return "/merchant/harvestOngoingOrder.jsp";
    }
    /*
     * @商家主页面跳转到所有审核中的商品界面
     * 陈宇豪
     */
    @GetMapping("/toMerchantGoodsCheck")
    public String toMerchantGoodsCheck(@RequestParam("merchantId") int merchantId,
                                       Model model){
        Merchant merchant = merchantService.selectMerchantById(merchantId);
        List<Goods> goodsList=new ArrayList<>();
        for(Goods good:merchant.getGoodsList()) {
            if("审核中".equals(good.getCheck())) {
                goodsList.add(good);
            }
        }
        model.addAttribute("goods", goodsList);
        return "/merchant/goodsCheck.jsp";
    }
    /*
     * @商家主页面跳转到上传商品界面
     * 陈宇豪
     */
    @GetMapping("/toMerchantUpdateGoods")
    public String toMerchantUpdateGoods(@RequestParam("merchantId") int merchantId,
                                        Model model){
        return "/merchant/update/updateGoods.jsp";
    }

    /*
     * @description: 客服跳转自己的纠纷
     */
    @GetMapping("/toServiceDisputeOngoing")
    public String toServiceDisputeOngoing(@RequestParam("serviceId") int serviceId,
                                          Model model){
        Service service = serviceService.selectServiceById(serviceId);
        model.addAttribute("disputes", service.getDisputeList());
        model.addAttribute("service", service);
        return "/service/disputeOngoing.jsp";
    }

    /*
     * @description: 页面跳转到管理员主界面
     */
    @GetMapping("/toAdministratorHome")
    public String toAdministratorHome(){
        return "/administrator/home.jsp";
    }

    /*用户登录判断*/
    @RequestMapping("/login")
    public String login(String account, String password, String type,
                        HttpSession httpSession,
                        Model model) {
        boolean isRight = loginService.loginByAccountAndPassword(account, password, type);
        if (isRight) {
            if ("user".equals(type)) {
                User user = userService.selectUserByAccount(account);
                httpSession.setAttribute("user", user);
                return "/customer/home.jsp";
            } else if ("merchant".equals(type)) {
                Merchant merchant = merchantService.selectMerchantByAccount(account);
                httpSession.setAttribute("merchant", merchant);
                return "/merchant/home.jsp";
            } else if ("service".equals(type)) {
                Service service = serviceService.selectServiceByAccount(account);
                httpSession.setAttribute("service", service);
                return "/service/home.jsp";
            } else if ("administrator".equals(type)) {
                Administrator administrator = administratorService.selectAdministratorByAccount(account);
                httpSession.setAttribute("administrator", administrator);
                return "/administrator/home.jsp";
            }
        }else {
            model.addAttribute("message", "登录失败");
            return "/enter/login.jsp";
        }
        return "/enter/login.jsp";
    }


    /*
     * @description: 注册
     */
    @RequestMapping("/register")
    public String register(@RequestParam("account") String account,
                           @RequestParam("password") String password,
                           @RequestParam("type") String type,
                           @RequestParam("rePassword") String rePassword,
                           Model model){
        if (!password.equals(rePassword)){
            model.addAttribute("message", "两次密码不一样！");
            return "/enter/register.jsp";
        }
        if ("user".equals(type)){
            User user = new User();
            user.setAccount(account);
            user.setPassword(password);
            user.setRepassword(rePassword);
            if (loginService.registerUser(user)){
                model.addAttribute("account", user.getAccount());
                return "/enter/login.jsp";
            }else {
                model.addAttribute("message", "账号重复！");
                return "/enter/register.jsp";
            }
        }else if ("merchant".equals(type)){
            Merchant merchant = new Merchant();
            merchant.setAccount(account);
            merchant.setPassword(password);
            merchant.setRepassword(rePassword);
            if (loginService.registerMerchant(merchant)){
                model.addAttribute("account", merchant.getAccount());
                return "/enter/login.jsp";
            }else {
                model.addAttribute("message", "账号重复！");
                return "/enter/register.jsp";
            }
        }else {
            model.addAttribute("message", "请选择类别！");
            return "/enter/register.jsp";
        }
        /*return "/enter/login.jsp";*/
    }

    /*跳转更新个人信息*/
    @RequestMapping("/updateSelf")
    public String updateSelf(@RequestParam("userId") int userId,Model model){
        User user = userService.selectUserById(userId);
        model.addAttribute("user",user);
        return "/customer/updateSelfInfo.jsp";
    }

    /*实现更新功能*/
    @RequestMapping("/updateSelfInfo")
    public String updateSelfInfo(@RequestParam("userId") int userId,@RequestParam("name") String name,
                                  @RequestParam("phone") String phone,@RequestParam("gender") String gender,
                                  @RequestParam("zipcode") String zipcode,@RequestParam("password") String password,
                                  @RequestParam("rePassword") String rePassword,HttpSession httpSession) {
        User user = userService.selectUserById(userId);
        user.setName(name);
        user.setPhone(phone);
        user.setGender(gender);
        user.setZipcode(zipcode);
        user.setPassword(password);
        user.setRepassword(rePassword);
        if (userService.updateUser(user) == 0) {
            return "/customer/updateSelfInfoFail.jsp";
        } else {
            User user2 = userService.selectUserById(userId);
            httpSession.setAttribute("user", user2);
            return "/customer/updateSelfInfoSuccess.jsp";
        }
    }
}
