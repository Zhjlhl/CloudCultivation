package com.cloudcultivation.service.impl;

import com.cloudcultivation.po.Goods;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.Orders;
import com.cloudcultivation.po.User;
import com.cloudcultivation.service.AdoptService;
import com.cloudcultivation.service.GoodsService;
import com.cloudcultivation.service.OrdersService;
import com.cloudcultivation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * @author lzx
 */
@org.springframework.stereotype.Service
public class AdoptServiceImpl implements AdoptService {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrdersService ordersService;



    /*通过密码购买货物*/
    @Override
    public boolean paymentGoodsByPassword(int userId , int goodsId){

        User user = userService.selectUserById(userId);
        Goods goods = goodsService.selectGoodsById(goodsId);
        Orders orders=new Orders();
        int x=user.getBalance().compareTo(goods.getPrice());
            user.setBalance(user.getBalance().subtract(goods.getPrice()));
            if(userService.updateUser(user)==0) {  //更新用户余额
                return false;
            }
            goods.setAmount(goods.getAmount()-1);
            if(goodsService.updateGoods(goods)==0) {//更新货物数量
                return false;
            }
            orders.setUser(user);
            orders.setGoods(goods);
            Merchant merchant = goods.getMerchant();
            orders.setMerchant(merchant);
            orders.setPaymentState("已支付");
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            orders.setDate(ts);
            if(ordersService.addOrder(orders)==0){//添加订单表
                return false;
            }
            return true;

    }







}
