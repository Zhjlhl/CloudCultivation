package com.cloudcultivation.service;

import com.cloudcultivation.po.Feed;
import com.cloudcultivation.po.Goods;
import org.springframework.stereotype.Service;

/**
 * @author Jiejie
 */
@Service
public interface CheckService {

    /*
     * @description: 判断商品审核通过
     */
    public boolean isGoodsChecked(Goods goods);

    /*
     * @description: 判断商品 未审核
     */
    public boolean isGoodsUnChecked(Goods goods);

    /*
     * @description: 判断饲料审核通过
     */
    public boolean isFeedChecked(Feed feed);

    /*
     * @description: 判断饲料 未审核
     */
    public boolean isFeedUnChecked(Feed feed);
}
