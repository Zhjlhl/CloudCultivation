package com.cloudcultivation.service;
import com.cloudcultivation.po.Buy;

import java.util.List;

/**
 * @author 陈宇豪
 */
public interface BuyService {

    /*通过id查询购买饲料的订单*/
    public Buy selectBuyById(int id);

    /*查询所有购买饲料的订单*/
    public List<Buy> selectAllBuy();

    /*新增购买饲料的订单*/
    public int addBuy(Buy buy);

    /*更新购买饲料的订单信息*/
    public int updateBuy(Buy buy);

    /*通过id删除购买饲料的订单*/
    public int deleteBuyById(int id);

}
