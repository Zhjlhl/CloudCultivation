package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.*;
import com.cloudcultivation.po.*;
import com.cloudcultivation.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyy
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private FeedingMapper feedingMapper;
    @Autowired
    private FeedMapper feedMapper;
    @Autowired
    private HarvestMapper harvestMapper;
    @Autowired
    private BuyMapper buyMapper;

    @Override
    public Merchant selectMerchantById(int id) {
        return merchantMapper.selectMerchantById(id);
    }

    @Override
    public Merchant selectMerchantByAccount(String account) {
        return merchantMapper.selectMerchantByAccount(account);
    }

    @Override
    public List<Merchant> selectAllMerchant() {
        return merchantMapper.selectAllMerchant();
    }

    @Override
    public int addMerchant(Merchant merchant) {
        return merchantMapper.addMerchant(merchant);
    }

    @Override
    public int updateMerchant(Merchant merchant) {
        return merchantMapper.updateMerchant(merchant);
    }

    @Override
    public int deleteMerchantById(int id) {
        return merchantMapper.deleteMerchantById(id);
    }

    @Override
    public boolean loginByAccountAndPassword(String account, String password){
        Merchant merchant = merchantMapper.selectMerchantByAccount(account);
        return merchant.getPassword().equals(password);
    }

    @Override
    public boolean accountExist(String account){
        if(merchantMapper.selectMerchantByAccount(account)!=null) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean register(Merchant merchant){
        if (this.accountExist(merchant.getAccount())){
            return false;
        }
        if (merchant.getPassword().equals(merchant.getRepassword())){
            return this.addMerchant(merchant)>0;
        }
        return false;
    }

    @Override
    public boolean updatePassword(String password,int id){
        Merchant merchant = merchantMapper.selectMerchantById(id);
        merchant.setPassword(password);
        return merchantMapper.updateMerchant(merchant)>0;
    }

    @Override
    public List<Orders> selectAllOrdersByMerchantId(int id){
        List<Orders> list = ordersMapper.selectAllOrders();
        List<Orders> result = new ArrayList<>();
        for(Orders orders : list){
            if(orders.getMerchant().getId() == id){
                result.add(orders);
            }
        }
        return result;
    }

    @Override
    public List<Goods> selectAllGoodsByMerchantId(int id){
        List<Goods> list = goodsMapper.selectAllGoods();
        List<Goods> result = new ArrayList<>();
        for(Goods goods : list){
            if(goods.getMerchant().getId() == id){
                result.add(goods);
            }
        }
        return result;
    }

    @Override
    public List<Feed> selectAllFeedByMerchantId(int id){
        List<Feed> list = feedMapper.selectAllFeed();
        List<Feed> result = new ArrayList<>();
        for( Feed feed : list){
            if(feed.getMerchant().getId() == id){
                result.add(feed);
            }
        }
        return result;
    }

    @Override
    public List<Feeding> selectAllFeedingByMerchantId(int id){
        List<Feeding> list = feedingMapper.selectAllFeeding();
        List<Feeding> result = new ArrayList<>();
        for(Feeding feeding : list){
            if(feeding.getOrders().getMerchant().getId() == id){
                result.add(feeding);
            }
        }
        return result;
    }

    @Override
    public List<Buy> selectAllBuyByMerchantId(int id){
        List<Buy> list = buyMapper.selectAllBuy();
        List<Buy> result = new ArrayList<>();
        for(Buy buy : list){
            if(buy.getOrders().getMerchant().getId() == id){
                result.add(buy);
            }
        }
        return result;
    }

    @Override
    public List<Buy> selectBuyByOrderId(int id){
        List<Buy> list = buyMapper.selectAllBuy();
        List<Buy> result = new ArrayList<>();
        for(Buy buy : list){
            if(buy.getOrders().getId() == id){
                result.add(buy);
            }
        }
        return result;
    }

    @Override
    public boolean addGoodsByMerchant(Goods goods) {
        return goodsMapper.addGoods(goods)>0;
    }

    @Override
    public boolean deleteGoodsByMerchant(int id) {
        return goodsMapper.deleteGoodsById(id)>0;
    }

    @Override
    public boolean addFeedingByMerchant(Feeding feeding) {
        return feedingMapper.addFeeding(feeding)>0;
    }

    @Override
    public boolean deleteFeedingByMerchant(int id) {
        return feedingMapper.deleteFeedingById(id)>0;
    }

    @Override
    public boolean addFeedByMerchant(Feed feed) {
        return feedMapper.addFeed(feed)>0;
    }

    @Override
    public boolean deleteFeedByMerchant(int id) {
        return feedMapper.deleteFeedById(id)>0;
    }
    @Override
    public boolean addHarvestByMerchant(Harvest harvest) {
        return harvestMapper.addHarvest(harvest)>0;
    }

    @Override
    public boolean useBuy(int orderId,int feedId,int number){
        List<Buy> list = this.selectBuyByOrderId(orderId);
        Buy result = new Buy();
        for(Buy buy : list){
            if(buy.getFeed().getId() == feedId){
                result = buy;
            }
        }
        int i = result.getRemain() - number;
        result.setRemain(i);
        return buyMapper.updateBuy(result)>0;
    }

    @Override
    public boolean addPromise(int id, BigDecimal number, String password){
        Merchant merchant = merchantMapper.selectMerchantById(id);
        BigDecimal temp = merchant.getPromise();
        temp = temp.add(number);
        if(merchant.getPassword().equals(password)){
            merchant.setPromise(temp);
            return merchantMapper.updateMerchant(merchant)>0;
        }else{
            return false;
        }
    }
}
