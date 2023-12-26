package com.cloudcultivation.service;

import com.cloudcultivation.po.Goods;

import java.util.List;

/**
 * @author hyy
 */
public interface GoodsService {
    /*通过id查询商品*/
    public Goods selectGoodsById(int id);

    /*查询所有商品*/
    public List<Goods> selectAllGoods();

    /*新增商品*/
    public int addGoods(Goods goods);

    /*更新商品
     * 有外键的约束，我们数据库设计采用级联更新和删除，这里只能更新外键以外的信息
     * 若需要更新外键，只能删除再加入
     * */
    public int updateGoods(Goods goods);

    /*通过id删除商品*/
    public int deleteGoodsById(int id);
}
