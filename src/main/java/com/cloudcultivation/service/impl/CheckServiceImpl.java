package com.cloudcultivation.service.impl;

import com.cloudcultivation.po.Goods;
import com.cloudcultivation.service.CheckService;
import org.springframework.stereotype.Service;

/**
 * @author Jiejie
 */
@Service
public class CheckServiceImpl implements CheckService {


    @Override
    public boolean isGoodsChecked(Goods goods) {
        return "已审核".equals(goods.getCheck());
    }

}
