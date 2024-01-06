package com.cloudcultivation.service.impl;

import com.cloudcultivation.po.Feed;
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

    @Override
    public boolean isGoodsUnChecked(Goods goods) {
        return "未审核".equals(goods.getCheck());
    }

    @Override
    public boolean isFeedChecked(Feed feed) {
        return "已审核".equals(feed.getCheck());
    }

    @Override
    public boolean isFeedUnChecked(Feed feed) {
        return "未审核".equals(feed.getCheck());
    }
}
