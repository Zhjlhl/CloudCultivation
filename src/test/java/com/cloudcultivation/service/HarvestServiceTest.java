package com.cloudcultivation.service;

import com.cloudcultivation.po.Harvest;
import com.cloudcultivation.po.Orders;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author hyy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/application-service.xml","classpath:/application-dao.xml"})
public class HarvestServiceTest extends TestCase {
    @Autowired
    private HarvestService harvestService;

    @Test
    public void testSelectHarvestById() {
        Harvest harvest;
        harvest = harvestService.selectHarvestById(10000);
        System.out.println(harvest);
        System.out.println(harvest.getId());
        System.out.println(harvest.getDate());
        System.out.println(harvest.getWay());
    }
    @Test
    public void testSelectAllHarvest() {
        List<Harvest> harvests = harvestService.selectAllHarvest();
        for (Harvest harvest1 : harvests){
            System.out.println(harvest1);
        }

    }
    @Test
    public void testAddHarvest() {
        Harvest harvest = new Harvest();
        Orders orders = new Orders();
        Date date = new Date();
        harvest.setId(10051);
        harvest.setDate(new Timestamp(date.getTime()));
        harvest.setDelivery("京东");
        harvest.setWay("全部寄回家");
        harvest.setEarnings(new BigDecimal("999.00"));
        harvest.setState("已结束");
        orders.setId(10000);
        harvest.setOrders(orders);

        int i = harvestService.addHarvest(harvest);
        if (i > 0){
            System.out.println("Insert Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Insert Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testUpdateHarvest() {
        Harvest harvest = new Harvest();
        Orders orders = new Orders();
        Date date = new Date();
        harvest.setId(10051);
        harvest.setDate(new Timestamp(date.getTime()));
        harvest.setDelivery("京东");
        harvest.setWay("全部寄回家");
        harvest.setEarnings(new BigDecimal("999.00"));
        harvest.setState("已结束");
        orders.setId(10000);
        harvest.setOrders(orders);

        int i = harvestService.updateHarvest(harvest);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Update Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testDeleteHarvestById() {
        int i = harvestService.deleteHarvestById(10051);
        if (i > 0){
            System.out.println("Delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Delete Failed!");
            System.out.println("Please Again!!!");
        }
    }
}