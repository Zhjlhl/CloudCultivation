package com.cloudcultivation.service;

import com.cloudcultivation.po.Goods;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lzx
 */
public interface AdoptService {

    /*通过密码购买货物*/
    public boolean paymentGoodsByPassword(int userId , int goodsId);

    List<Goods> selectGoodsByName(String name);
}
