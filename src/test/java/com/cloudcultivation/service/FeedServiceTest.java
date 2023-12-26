package com.cloudcultivation.service;

import com.cloudcultivation.po.Feed;
import com.cloudcultivation.po.Merchant;
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
public class FeedServiceTest extends TestCase {
    @Autowired
    private FeedService feedService;

    @Test
    public void testSelectFeedById() {
        Feed feed = feedService.selectFeedById(10000);
        System.out.println(feed);
        System.out.println(feed.getAmount());
        System.out.println(feed.getId());
        System.out.println(feed.getDescription());
        System.out.println(feed.getName());
        System.out.println(feed.getRemain());


    }
    @Test
    public void testSelectAllFeed() {
        List<Feed> feed = feedService.selectAllFeed();
        for (Feed feed1 : feed){
            System.out.println(feed1);
        }
    }
    @Test
    public void testAddFeed() {
        Feed feed = new Feed();
        Merchant merchant = new Merchant();
        merchant.setId(10000);
        feed.setId(11111);
        feed.setAmount(123);

        feed.setDescription("1001212121012212102101");


        feed.setMerchant(merchant);

        feed.setPrice(new BigDecimal("999.00"));
        feed.setName("羊");
        feed.setRemain(111);
        int i = feedService.addFeed(feed);
        if (i > 0){
            System.out.println("Insert Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Insert Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testUpdateFeed() {
        Feed feed = new Feed();
        Merchant merchant = new Merchant();
        merchant.setId(10000);
        feed.setId(11111);
        feed.setAmount(123);

        feed.setDescription("1001212121012212102101");


        feed.setMerchant(merchant);

        feed.setPrice(new BigDecimal("999.00"));
        feed.setName("羊");
        feed.setRemain(666);

        int i = feedService.updateFeed(feed);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Update Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testDeleteFeedById() {
        int i = feedService.deleteFeedById(11111);
        if (i > 0){
            System.out.println("Delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Delete Failed!");
            System.out.println("Please Again!!!");
        }
    }
}