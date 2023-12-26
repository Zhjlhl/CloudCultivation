package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.BuyMapper;
import com.cloudcultivation.po.Buy;
import com.cloudcultivation.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈宇豪
 */

@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyMapper buyMapper;

    @Override
    public Buy selectBuyById(int id) {
        return buyMapper.selectBuyById(id);
    }

    @Override
    public List<Buy> selectAllBuy() {
        return buyMapper.selectAllBuy();
    }

    @Override
    public int addBuy(Buy buy) {
        return buyMapper.addBuy(buy);
    }

    @Override
    public int updateBuy(Buy buy) {
        return buyMapper.updateBuy(buy);
    }

    @Override
    public int deleteBuyById(int id) {
        return buyMapper.deleteBuyById(id);
    }
}
