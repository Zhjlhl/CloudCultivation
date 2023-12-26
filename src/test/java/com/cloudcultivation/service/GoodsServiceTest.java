package com.cloudcultivation.service;

import com.cloudcultivation.po.Goods;
import com.cloudcultivation.po.Merchant;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hyy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/application-service.xml","classpath:/application-dao.xml"})
public class GoodsServiceTest extends TestCase {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void testSelectGoodsById() {
        Goods goods = goodsService.selectGoodsById(10000);
        System.out.println(goods);
        System.out.println(goods.getName());
        System.out.println(goods.getMerchant());
        System.out.println(goods.getType());
    }

    @Test
    public void testSelectAllGoods() {
        List<Goods> goods = goodsService.selectAllGoods();
        for (Goods goods1 : goods){
            System.out.println(goods1);
        }
    }

    @Test
    public void testAddGoods() {
        Goods goods=new Goods();
        Merchant merchant = new Merchant();
        merchant.setId(10000);
        goods.setId(10020);
        goods.setName("牛");
        goods.setType("动物");
        goods.setPrice(BigDecimal.valueOf(123));
        goods.setDescription("好牛");
        goods.setGrowth("100天");
        goods.setYield("111");
        goods.setAmount(100);
        goods.setMerchant(merchant);

        int i = goodsService.addGoods(goods);
        if (i > 0){
            System.out.println("Insert Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Insert Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testUpdateGoods() {
        Goods goods=new Goods();
        Merchant merchant = new Merchant();
        merchant.setId(10000);
        goods.setId(10020);
        goods.setName("羊");
        goods.setType("动物");
        goods.setPrice(BigDecimal.valueOf(123));
        goods.setDescription("好");
        goods.setGrowth("100天");
        goods.setYield("111");
        goods.setAmount(100);
        goods.setMerchant(merchant);

        int i = goodsService.updateGoods(goods);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Update Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testDeleteGoodsById() {
        int i = goodsService.deleteGoodsById(10020);
        if (i > 0){
            System.out.println("Delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Delete Failed!");
            System.out.println("Please Again!!!");
        }
    }
}