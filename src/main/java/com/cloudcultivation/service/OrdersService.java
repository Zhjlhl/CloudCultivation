package com.cloudcultivation.service;

import com.cloudcultivation.po.Orders;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Jiejie
 */
public interface OrdersService {

    /*通过id查询订单*/
    public Orders selectOrdersById(int id);

    /*查询所有订单*/
    public List<Orders> selectAllOrders();

    /*新增订单*/
    public int addOrder(Orders orders);

    /*更新订单
    * 有外键的约束，我们数据库设计采用级联更新和删除，这里只能更新外键以外的信息
     * 若需要更新外键，只能删除再加入
    * */
    public int updateOrder(Orders orders);

    /*通过id删除订单*/
    public int deleteOrderById(int id);

    /*通过用户，商家，货物id查询订单*/
    public Orders selectOrdersByUserMerchantGoodsId(int userId, int merchantId , int goodsId);

    /*
     * @description: 通过判断订单还在进行中
     */
    public boolean isOnGoing(Orders orders);

    /*
     * @description: 填写orders里面的剩余天数
     */
    public int setRemainDay(Orders orders);

    /*
     * @description: 判断订单是不是已经支付
     */
    public boolean isReadyForPaid(Orders orders);
}
