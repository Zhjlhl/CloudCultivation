package com.cloudcultivation.service;

import com.cloudcultivation.po.Goods;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.Orders;
import com.cloudcultivation.po.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/application-service.xml","classpath:/application-dao.xml"})
public class OrdersServiceTest extends TestCase {

    @Autowired
    private OrdersService ordersService;


    @Test
    public void testSelectOrdersById() {
        Orders orders = ordersService.selectOrdersById(10000);
        System.out.println(orders);
        System.out.println(orders.getUser());
        System.out.println(orders.getMerchant());
        System.out.println(orders.getGoods());
        System.out.println(orders.getDate());
        System.out.println(orders.getRemark());
    }

    @Test
    public void testSelectAllOrders() {
        List<Orders> orders = ordersService.selectAllOrders();
        for (Orders orders1 : orders){
            System.out.println(orders1);
        }
    }

    @Test
    public void testAddOrder() {
        Orders orders = new Orders();
        User user = new User();
        Merchant merchant = new Merchant();
        Goods goods = new Goods();
        user.setId(10000);
        merchant.setId(10000);
        goods.setId(10000);
        orders.setUser(user);
        orders.setMerchant(merchant);
        orders.setGoods(goods);
        orders.setDescription("zhj很牛逼");
        orders.setPaymentState("已支付");
        orders.setAmount(new BigDecimal("3000.00"));
        orders.setState("养殖中ing");

        int i = ordersService.addOrder(orders);
        if (i > 0){
            System.out.println("Insert Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Insert Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testUpdateOrder() {
        Orders orders = new Orders();
        User user = new User();
        Merchant merchant = new Merchant();
        Goods goods = new Goods();
        orders.setId(10100);
        user.setId(10000);
        merchant.setId(10000);
        goods.setId(10000);
        orders.setUser(user);
        orders.setMerchant(merchant);
        orders.setGoods(goods);
        orders.setDescription("zhj4353453453很牛逼");
        orders.setPaymentState("已支付");
        orders.setAmount(new BigDecimal("9990.00"));
        orders.setState("已结束");

        int i = ordersService.updateOrder(orders);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Update Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testDeleteOrderById() {
        int i = ordersService.deleteOrderById(10100);
        if (i > 0){
            System.out.println("Delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Delete Failed!");
            System.out.println("Please Again!!!");
        }
    }
}