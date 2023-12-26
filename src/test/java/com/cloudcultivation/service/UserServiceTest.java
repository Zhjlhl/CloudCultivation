package com.cloudcultivation.service;

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
public class UserServiceTest extends TestCase {

    @Autowired
    private UserService userService;



    @Test
    public void testSelectUserById() {
        User user = userService.selectUserById(10000);
        System.out.println(user.getOrdersList().get(0).getId());
        System.out.println(user.getOrdersList().get(1).getId());
        System.out.println(user.getOrdersList().get(2).getId());
    }

    @Test
    public void testSelectAllUser() {
        List<User> users = userService.selectAllUser();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("张浩洁");
        user.setAccount("lhlzhj");
        user.setGender("男");
        user.setPassword("lhlzhj-1314");
        user.setPhone("13868373437");
        user.setZipcode("325600");
        user.setBalance(new BigDecimal("500.11"));

        int i = userService.addUser(user);
        if (i > 0){
            System.out.println("Insert Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Insert Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(10052);
        user.setName("张浩---洁");
        user.setAccount("lhl---zhj");
        user.setGender("男");
        user.setPassword("lhlzh---j-1314");
        user.setPhone("00000000000");
        user.setZipcode("325611");
        user.setBalance(new BigDecimal("340.11"));

        int i = userService.updateUser(user);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Update Failed!");
            System.out.println("Please Again!!!");
        }
    }

    @Test
    public void testDeleteUserById() {

        int i = userService.deleteUserById(10052);
        if (i > 0){
            System.out.println("Delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Delete Failed!");
            System.out.println("Please Again!!!");
        }
    }
}