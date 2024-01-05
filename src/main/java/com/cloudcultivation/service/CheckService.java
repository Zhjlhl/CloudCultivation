package com.cloudcultivation.service;

import com.cloudcultivation.po.Goods;
import org.springframework.stereotype.Service;

@Service
public interface CheckService {

    /*
     * @description: 判断商品审核通过
     */
    public boolean isGoodsChecked(Goods goods);
}
