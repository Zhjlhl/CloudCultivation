package com.cloudcultivation.service;

import com.cloudcultivation.po.Feeding;
import com.cloudcultivation.po.Orders;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/application-service.xml","classpath:/application-dao.xml"})
public class FeedingServiceTest extends TestCase {
    @Autowired
    private FeedingService feedingService;

    @Test
    public void testSelectFeedingById() {
        Feeding feeding = feedingService.selectFeedingById(10000);
        System.out.println(feeding);
        System.out.println(feeding.getState());
        System.out.println(feeding.getId());
        System.out.println(feeding.getDate());
        System.out.println(feeding.getPhoto());
        System.out.println(feeding.getVideo());
        System.out.println(feeding.getWeight());


    }
    @Test
    public void testSelectAllFeeding() {
        List<Feeding> feeding = feedingService.selectAllFeeding();
        for (Feeding feeding1 : feeding){
            System.out.println(feeding1);
        }
    }
    @Test
    public void testAddFeeding() {
        Feeding feeding = new Feeding();
        Orders orders = new Orders();
        orders.setId(10000);
        feeding.setId(11111);
        feeding.setOrders(orders);

        //feeding.setDate("2025-3-3 12:12:12");


        feeding.setPhoto("1110");
        feeding.setVideo("10000000");
        feeding.setState("健康");
        int i = feedingService.addFeeding(feeding);
        if (i > 0){
            System.out.println("Insert Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Insert Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testUpdateFeeding() {
        Feeding feeding = new Feeding();
        Orders orders = new Orders();
        orders.setId(10000);
        feeding.setId(11111);
        feeding.setOrders(orders);

        //feeding.setDate("2025-3-3 12:12:12");


        feeding.setPhoto("1110");
        feeding.setVideo("888888888");
        feeding.setState("健康");

        int i = feedingService.updateFeeding(feeding);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Update Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testDeleteFeedingById() {
        int i = feedingService.deleteFeedingById(11111);
        if (i > 0){
            System.out.println("Delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Delete Failed!");
            System.out.println("Please Again!!!");
        }
    }
}