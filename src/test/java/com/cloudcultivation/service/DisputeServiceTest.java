package com.cloudcultivation.service;

import com.cloudcultivation.po.Dispute;
import com.cloudcultivation.po.Orders;
import com.cloudcultivation.po.Service;
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
public class DisputeServiceTest extends TestCase {

    @Autowired
    private DisputeService disputeService;
    @Test
    public void testSelectDisputeById() {
        Dispute dispute=disputeService.selectDisputeById(10000);
        System.out.println(dispute);
        System.out.println(dispute.getDate());
    }
    @Test
    public void testSelectAllDispute() {
        List<Dispute> disputes=disputeService.selectAllDispute();
        for(Dispute dispute:disputes)
        {
            System.out.println(dispute);
        }
    }
    @Test
    public void testAddDispute() {
        Dispute dispute=new Dispute();
        Orders orders=new Orders();
        orders.setId(10005);
        dispute.setOrders(orders);
        Service service=new Service();
        service.setId(10001);
        dispute.setService(service);
        dispute.setDescription("hgfgyrdfctr");
        dispute.setState("协商ing");
        dispute.setResult("asuygduyats");
        dispute.setAmount(new BigDecimal(99.8));
        dispute.setType("货不对板");
        int i=disputeService.addDispute(dispute);
        if (i > 0){
            System.out.println("add Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("add Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testUpdateDispute() {
        Dispute dispute=new Dispute();
        dispute.setId(10020);
        Orders orders=new Orders();
        orders.setId(10005);
        dispute.setOrders(orders);
        Service service=new Service();
        service.setId(10001);
        dispute.setService(service);
        dispute.setDescription("商家发的这是啥？");
        dispute.setState("协商ing");
        dispute.setResult("等待仲裁");
        dispute.setAmount(new BigDecimal(99.8));
        dispute.setType("货不对板");
        int i=disputeService.updateDispute(dispute);
        if (i > 0){
            System.out.println("update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("update Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testDeleteDisputeById() {
        int i = disputeService.deleteDisputeById(10020);
        if (i > 0){
            System.out.println("delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("delete Failed!");
            System.out.println("Please Again!!!");
        }
    }
}