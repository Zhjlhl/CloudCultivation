package com.cloudcultivation.dao;

import com.cloudcultivation.po.Orders;

import java.util.List;

/**
 * @author Jiejie
 */
public interface OrdersMapper {

    public Orders selectOrdersById(int id);

    public Orders selectOrdersByUserId(int userId);

    public Orders selectOrdersByMerchantId(int merchantId);

    public Orders selectOrdersByGoodsId(int goodsId);

    public List<Orders> selectAllOrders();

    public int addOrder(Orders orders);

    public int updateOrder(Orders orders);

    public int deleteOrderById(int id);
}
