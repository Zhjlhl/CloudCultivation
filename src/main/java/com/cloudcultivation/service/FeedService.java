package com.cloudcultivation.service;
import com.cloudcultivation.po.Feed;

import java.util.List;


//@author lzx
public interface FeedService {
    /*通过id查询饲料*/
    public Feed selectFeedById(int id);

    /*查询所有饲料*/
    public List<Feed> selectAllFeed();

    /*新增饲料*/
    public int addFeed(Feed feed);

    /*更新饲料
     * 有外键的约束，我们数据库设计采用级联更新和删除，这里只能更新外键以外的信息
     * 若需要更新外键，只能删除再加入
     * */
    public int updateFeed(Feed feed);

    /*通过id删除饲料*/
    public int deleteFeedById(int id);
}
