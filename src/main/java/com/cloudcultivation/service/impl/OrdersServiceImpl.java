package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.OrdersMapper;
import com.cloudcultivation.po.Orders;
import com.cloudcultivation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
