package com.cloudcultivation.service;

import com.cloudcultivation.po.Buy;
import com.cloudcultivation.po.Feed;
import com.cloudcultivation.po.Orders;
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
public class BuyServiceTest extends TestCase {

    @Autowired
    private BuyService buyService;
    @Test
    public void testSelectBuyById() {
        Buy buy =buyService.selectBuyById(10000);
        System.out.println(buy);
    }
    @Test
    public void testSelectAllBuy() {
        List<Buy> buys = buyService.selectAllBuy();
        for (Buy buy: buys)
            System.out.println(buy);
    }
    @Test
    public void testAddBuy()
    {
        Buy buy=new Buy();
        Orders orders=new Orders();
        orders.setId(10005);
        buy.setOrders(orders);
        Feed feed=new Feed();
        feed.setId(10014);
        buy.setFeed(feed);
        buy.setAmount(5);
        buy.setDescription("asduiohfiuya");
        buy.setPaymentState("已支付");
        buy.setPaymentAmount(new BigDecimal(3));
        //buy.setDate("2023-03-02 13:12:11");
        buy.setRemain(new BigDecimal(buy.getFeed().getRemain()).subtract(buy.getPaymentAmount()).intValue());
        int i = buyService.addBuy(buy);
        if (i > 0){
            System.out.println("add Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("add Failed!");
            System.out.println("Please Again!!!");
        }
    }
@Test
    public void testUpdateBuy()
    {
        Buy buy=new Buy();
        buy.setId(10050);
        Orders orders=new Orders();
        orders.setId(10005);
        buy.setOrders(orders);
        Feed feed=new Feed();
        feed.setId(10014);
        buy.setFeed(feed);
        buy.setAmount(5);
        buy.setDescription("asduiohfiuya");
        buy.setPaymentState("已支付");
        buy.setPaymentAmount(new BigDecimal(3));
        //buy.setDate("2023-03-02 13:12:11");
        buy.setRemain(new BigDecimal(buy.getFeed().getRemain()).subtract(buy.getPaymentAmount()).intValue());
        System.out.println(new BigDecimal(buy.getFeed().getRemain()));
        int i = buyService.updateBuy(buy);
        if (i > 0){
            System.out.println("update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("update Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testDeleteBuyById() {
        int i = buyService.deleteBuyById(10050);
        if (i > 0){
            System.out.println("delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("delete Failed!");
            System.out.println("Please Again!!!");
        }
    }
}
