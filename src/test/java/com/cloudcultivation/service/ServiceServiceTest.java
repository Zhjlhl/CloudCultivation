package com.cloudcultivation.service;

import com.cloudcultivation.po.Service;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/application-service.xml","classpath:/application-dao.xml"})
public class ServiceServiceTest extends TestCase {

    @Autowired
    private ServiceService serviceService;

    @Test
    public void testSelectServiceById() {
        Service service = serviceService.selectServiceById(10023);
        System.out.println(service);
    }

    @Test
    public void testSelectAllService() {
        List<Service> services = serviceService.selectAllService();
        for (Service service : services){
            System.out.println(service);
        }
    }

    @Test
    public void testAddService() {
        Service service = new Service();
        service.setAccount("lhlzhj");
        service.setName("张浩洁");
        service.setNickname("Jiejie");
        service.setGender("男");
        service.setPhone("13868373437");
        service.setDescription("zhj很牛逼！");
        service.setPassword("zhjzhj1314");

        int i = serviceService.addService(service);
        if (i > 0){
            System.out.println("Insert Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Insert Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testUpdateService() {
        Service service = new Service();
        service.setId(10030);
        service.setAccount("lhl2222zhj");
        service.setName("张浩--洁");
        service.setNickname("Jie-jie");
        service.setGender("男");
        service.setPhone("----8373437");
        service.setDescription("zhj----------------------------------很牛逼！");
        service.setPassword("zhjzhj---1314");

        int i = serviceService.updateService(service);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Update Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testDeleteService() {
        int i = serviceService.deleteServiceById(10030);
        if (i > 0){
            System.out.println("Delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Delete Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testSelectServiceByAccount() {
        Service service = serviceService.selectServiceByAccount("eOdu");
        System.out.println(service);
    }
}