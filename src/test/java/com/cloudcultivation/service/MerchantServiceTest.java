package com.cloudcultivation.service;

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
public class MerchantServiceTest extends TestCase {
    @Autowired
    private MerchantService merchantService;

    @Test
    public void testSelectMerchantById() {
        Merchant merchant = merchantService.selectMerchantById(10000);
        System.out.println(merchant);
        System.out.println(merchant.getName());
        System.out.println(merchant.getAccount());
        System.out.println(merchant.getDescription());
    }
    @Test
    public void testSelectAllMerchant() {
        List<Merchant> merchant = merchantService.selectAllMerchant();
        for (Merchant merchant1 : merchant){
            System.out.println(merchant1.getBalance());
            System.out.println(merchant1.getPromise());
        }

    }
    @Test
    public void testAddMerchant() {
        Merchant merchant = new Merchant();
        merchant.setId(10050);
        merchant.setAccount("aaa");
        merchant.setName("aaaa");
        merchant.setPassword("123");
        merchant.setContacts("1234");
        merchant.setPhone("123");
        merchant.setDescription("1232");
        merchant.setBalance(new BigDecimal("22.33"));

        int i = merchantService.addMerchant(merchant);
        if (i > 0){
            System.out.println("Insert Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Insert Failed!");
            System.out.println("Please Again!!!");
        }

    }
    @Test
    public void testUpdateMerchant() {
        Merchant merchant = new Merchant();
        merchant.setId(10050);
        merchant.setAccount("abb");
        merchant.setName("aaaa");
        merchant.setPassword("123");
        merchant.setContacts("1234");
        merchant.setPhone("123");
        merchant.setDescription("1232");
        merchant.setBalance(new BigDecimal("123"));

        int i = merchantService.updateMerchant(merchant);
        if (i > 0){
            System.out.println("Update Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Update Failed!");
            System.out.println("Please Again!!!");
        }
    }
    @Test
    public void testDeleteMerchantById() {
        int i = merchantService.deleteMerchantById(10050);
        if (i > 0){
            System.out.println("Delete Successful!");
            System.out.println("行数="+i);
        }else {
            System.out.println("Delete Failed!");
            System.out.println("Please Again!!!");
        }
    }
}