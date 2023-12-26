package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.GoodsMapper;
import com.cloudcultivation.po.Goods;
import com.cloudcultivation.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyy
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods selectGoodsById(int id) {
        return goodsMapper.selectGoodsById(id);
    }

    @Override
    public List<Goods> selectAllGoods() {
        return goodsMapper.selectAllGoods();
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int deleteGoodsById(int id) {
        return goodsMapper.deleteGoodsById(id);
    }

}
