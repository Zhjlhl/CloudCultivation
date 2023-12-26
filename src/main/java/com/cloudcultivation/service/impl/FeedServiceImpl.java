package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.FeedMapper;
import com.cloudcultivation.po.Feed;
import com.cloudcultivation.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzx
 */
@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    private FeedMapper feedMapper;

    @Override
    public Feed selectFeedById(int id) {
        return feedMapper.selectFeedById(id);
    }

    @Override
    public List<Feed> selectAllFeed() {
        return feedMapper.selectAllFeed();
    }

    @Override
    public int addFeed(Feed feed) {
        return feedMapper.addFeed(feed);
    }

    @Override
    public int updateFeed(Feed feed) {
        return feedMapper.updateFeed(feed);
    }

    @Override
    public int deleteFeedById(int id) {
        return feedMapper.deleteFeedById(id);
    }

}
