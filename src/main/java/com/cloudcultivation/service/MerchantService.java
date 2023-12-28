package com.cloudcultivation.service;

import com.cloudcultivation.po.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hyy
 */
public interface MerchantService {
    /*通过id查询商家信息*/
    public Merchant selectMerchantById(int id);

    /*通过account查询商家信息*/
    public Merchant selectMerchantByAccount(String account);

    /*查询所有商家信息*/
    public List<Merchant> selectAllMerchant();

    /*新增商家信息*/
    public int addMerchant(Merchant merchant);

    /*更新商商家信息
     * */
    public int updateMerchant(Merchant merchant);

    /*通过id删除商家信息*/
    public int deleteMerchantById(int id);

    /*通过account和password判断商家登录*/
    public boolean loginByAccountAndPassword(String account, String password);

    /*判断商家account是否重复*/
    public boolean accountExist(String account);

    /*商家注册*/
    public boolean register(Merchant merchant);

    /*商家修改密码*/
    public boolean updatePassword(String password,int id);

    /* 商家查询所有订单
       根据商家id查询订单*/
    public List<Orders> selectAllOrdersByMerchantId(int id);

    /*商家查询自己上传的所有商品*/
    public List<Goods> selectAllGoodsByMerchantId(int id);

    /*商家查询所有自己上传的饲料种类*/
    public List<Feed> selectAllFeedByMerchantId(int id);

    /*商家查询上传的饲养信息*/
    public List<Feeding> selectAllFeedingByMerchantId(int id);

    /*商家查询用户购买的饲料*/
    /*方式一：查询该商家所有订单购买的饲料*/
    public List<Buy> selectAllBuyByMerchantId(int id);
    /*方式二：查询指定订单购买的饲料*/
    public List<Buy> selectBuyByOrderId(int id);


    /*商家上传商品*/
    public boolean addGoodsByMerchant(Goods goods);

    /*商家根据商品号删除上传的商品*/
    public boolean deleteGoodsByMerchant(int id);

    /*商家上传饲养信息*/
    public boolean addFeedingByMerchant(Feeding feeding);

    /*商家根据饲养信息号删除上传的饲养信息*/
    public boolean deleteFeedingByMerchant(int id);

    /*商家上传饲料种类*/
    public boolean addFeedByMerchant(Feed feed);

    /*商家根据饲料种类号删除饲料种类*/
    public boolean deleteFeedByMerchant(int id);

    /*商家上传收获信息*/
    public boolean addHarvestByMerchant(Harvest harvest);

    /*商家使用饲料*/
    public boolean useBuy(int orderId,int feedId,int number);

    /*商家缴纳保证金*/
    public boolean addPromise(int id, BigDecimal number, String password);
}
