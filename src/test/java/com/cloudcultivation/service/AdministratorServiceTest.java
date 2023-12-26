package com.cloudcultivation.service;

import com.cloudcultivation.po.Administrator;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/application-service.xml","classpath:/application-dao.xml"})
public class AdministratorServiceTest extends TestCase {

    @Autowired
    private AdministratorService administratorService;

    @Test
    public void testSelectAdministratorById() {
        Administrator administrator = administratorService.selectAdministratorById(10002);
        System.out.println(administrator);
    }
    @Test
    public void testSelectAllAdministrator() {
        List<Administrator> administrators = administratorService.selectAllAdministrator();
        for (Administrator administrator: administrators){
            System.out.println(administrator);
        }
    }
    @Test
    public void testAddAdministrator() {
        Administrator administrator=new Administrator();
        administrator.setAccount("2");
        administrator.setPassword("1231312");
        administrator.setDescription("56456");
        administrator.setType("1");
        administrator.setRepassword("1231312");
        administrator.setDescription("jayzugdyauysfgdsuy");
        administratorService.addAdministrator(administrator);
    }
    @Test
    public void testUpdateAdministrator() {
        Administrator administrator=new Administrator();
        administrator.setId(10010);
        administrator.setAccount("2");
        administrator.setPassword("1231312");
        administrator.setDescription("56456");
        administrator.setPhone("231875561415");
        administrator.setType("1");
        administrator.setRepassword("1231312");
        administrator.setDescription("jayzugdyauysfgdsuy");

        int i = administratorService.updateAdministrator(administrator);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("update Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testDeleteAdministratorById()
    {
        int i = administratorService.deleteAdministratorById(10010);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("update Failed!");
            System.out.println("Please Again!!!");
        }
    }
}