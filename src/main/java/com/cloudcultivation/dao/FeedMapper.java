package com.cloudcultivation.dao;
import com.cloudcultivation.po.Feed;

import java.util.List;


/**
 * @author lzx
 */
public interface FeedMapper {
    public Feed selectFeedById(int id);

    public Feed selectFeedByMerchantId(int merchantId);

    public List<Feed> selectAllFeed();

    public int addFeed(Feed feed);

    public int updateFeed(Feed feed);

    public int deleteFeedById(int id);
}
