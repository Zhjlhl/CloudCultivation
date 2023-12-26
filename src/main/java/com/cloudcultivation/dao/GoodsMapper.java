package com.cloudcultivation.dao;

import com.cloudcultivation.po.Goods;

import java.util.List;

/**
 * @author Jiejie
 */
public interface GoodsMapper {

    public Goods selectGoodsById(int id);

    public Goods selectGoodsByMerchantId(int merchantId);

    public List<Goods> selectAllGoods();

    public int addGoods(Goods goods);

    public int updateGoods(Goods goods);

    public int deleteGoodsById(int id);
}
