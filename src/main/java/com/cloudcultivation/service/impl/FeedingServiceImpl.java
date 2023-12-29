package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.FeedingMapper;
import com.cloudcultivation.po.*;
import com.cloudcultivation.service.FeedService;
import com.cloudcultivation.service.FeedingService;
import com.cloudcultivation.service.OrdersService;
import com.cloudcultivation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzx
 */
@Service
public class FeedingServiceImpl implements FeedingService {
    @Autowired
    private FeedingMapper feedingMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private FeedService feedService;

    @Override
    public Feeding selectFeedingById(int id) {
        return feedingMapper.selectFeedingById(id);
    }

    @Override
    public List<Feeding> selectAllFeeding() {
        return feedingMapper.selectAllFeeding();
    }

    @Override
    public int addFeeding(Feeding feeding) {
        return feedingMapper.addFeeding(feeding);
    }

    @Override
    public int updateFeeding(Feeding feeding) {
        return feedingMapper.updateFeeding(feeding);
    }

    @Override
    public int deleteFeedingById(int id) {
        return feedingMapper.deleteFeedingById(id);
    }

    /*通过密码支付购买饲料*/
    @Override
    public boolean paymentFeedByPassword(User user , Merchant merchant , Goods goods , Feed feed, String password){
        Orders orders = new Orders();
        int userId=user.getId();
        int merchantId=merchant.getId();
        int goodsId=goods.getId();
        int x=user.getBalance().compareTo(feed.getPrice());
        if(user.getPassword().equals(password)&&x>=0&&feed.getAmount()>0){
            user.setBalance(user.getBalance().subtract(feed.getPrice()));
            userService.updateUser(user);   //更新用户余额

            feed.setAmount(feed.getAmount()-1);
            feedService.updateFeed(feed);   //更新饲料数量

            orders=ordersService.selectOrdersByUserMerchantGoodsId(userId,merchantId,goodsId);
            orders.setFeed(feed.getName());
            ordersService.updateOrder(orders);  //更新订单
            return true;
        }
        else {
            return false;
        }
    }
}
