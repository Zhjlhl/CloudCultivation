package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.FeedingMapper;
import com.cloudcultivation.po.Feeding;
import com.cloudcultivation.service.FeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzx
 */
@Service
public class FeedingServiceImpl implements FeedingService {
    @Autowired
    private FeedingMapper feedingMapper;

    @Override
    public Feeding selectFeedingById(int id) {
        return feedingMapper.selectFeedingById(id);
    }

    @Override
    public List<Feeding> selectAllFeeding() {
        return feedingMapper.selectAllFeeding();
    }

    @Override
    public int addFeeding(Feeding feeding) {
        return feedingMapper.addFeeding(feeding);
    }

    @Override
    public int updateFeeding(Feeding feeding) {
        return feedingMapper.updateFeeding(feeding);
    }

    @Override
    public int deleteFeedingById(int id) {
        return feedingMapper.deleteFeedingById(id);
    }

}
