package com.cloudcultivation.dao;

import com.cloudcultivation.po.Buy;

import java.util.List;
/**
 * @author 陈宇豪
 */
public interface BuyMapper {
    public Buy selectBuyById(int id);

    public Buy selectBuyByFeedId(int feedId);

    public Buy selectBuyByOrdersId(int ordersId);

    public List<Buy> selectAllBuy();

    public int addBuy(Buy buy);

    public int updateBuy(Buy buy);

    public int deleteBuyById(int id);
}
