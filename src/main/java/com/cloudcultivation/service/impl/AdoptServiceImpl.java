package com.cloudcultivation.service.impl;

import com.cloudcultivation.po.Goods;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.Orders;
import com.cloudcultivation.po.User;
import com.cloudcultivation.service.GoodsService;
import com.cloudcultivation.service.OrdersService;
import com.cloudcultivation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * @author lzx
 */
@org.springframework.stereotype.Service
public class AdoptServiceImpl {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrdersService ordersService;



    /*通过密码购买货物*/
    public boolean paymentGoodsByPassword(User user , Merchant merchant , Goods goods ,String password){

        Orders orders=new Orders();
        int x=user.getBalance().compareTo(goods.getPrice());
        if(user.getPassword().equals(password)&&x>=0&&goods.getAmount()>0){
            user.setBalance(user.getBalance().subtract(goods.getPrice()));
            userService.updateUser(user);  //更新用户余额

            goods.setAmount(goods.getAmount()-1);
            goodsService.updateGoods(goods);  //更新货物数量

            orders.setUser(user);
            orders.setGoods(goods);
            orders.setMerchant(merchant);
            orders.setPaymentState("已支付");
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            orders.setDate(ts);
            ordersService.addOrder(orders);  //添加订单表

            return true;

        }
        else return false;
    }







}
