package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.OrdersMapper;
import com.cloudcultivation.po.Orders;
import com.cloudcultivation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author Jiejie
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Orders selectOrdersById(int id) {
        return ordersMapper.selectOrdersById(id);
    }

    @Override
    public List<Orders> selectAllOrders() {
        return ordersMapper.selectAllOrders();
    }

    @Override
    public int addOrder(Orders orders) {
        return ordersMapper.addOrder(orders);
    }

    @Override
    public int updateOrder(Orders orders) {
        return ordersMapper.updateOrder(orders);
    }

    @Override
    public int deleteOrderById(int id) {
        return ordersMapper.deleteOrderById(id);
    }

    @Override
    public Orders selectOrdersByUserMerchantGoodsId(int userId, int merchantId , int goodsId){
        return ordersMapper.selectOrdersByUserMerchantGoodsId(userId,merchantId,goodsId);
    }

    @Override
    public boolean isOnGoing(Orders orders) {
        return "养殖中ing".equals(orders.getState());
    }

    @Override
    public int setRemainDay(Orders orders) {

        int totalDays = Integer.parseInt(orders.getGoods().getGrowth());
        LocalDate startDate = orders.getDate().toLocalDateTime().toLocalDate();

        // Calculate the remaining days
        long daysPassed = ChronoUnit.DAYS.between(startDate, LocalDate.now());
        return Math.max(totalDays - (int)daysPassed, 0);
    }

    @Override
    public boolean isReadyForPaid(Orders orders) {
        return "待支付".equals(orders.getPaymentState());
    }
}
