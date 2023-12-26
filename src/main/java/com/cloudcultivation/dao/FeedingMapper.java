package com.cloudcultivation.dao;

import com.cloudcultivation.po.Feeding;

import java.util.List;


/**
 * @author lzx
 */
public interface FeedingMapper {
    public Feeding selectFeedingById(int id);

    public Feeding selectFeedingByOrdersId(int ordersId);

    public List<Feeding> selectAllFeeding();

    public int addFeeding(Feeding feeding);

    public int updateFeeding(Feeding feeding);

    public int deleteFeedingById(int id);
}
