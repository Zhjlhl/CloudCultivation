package com.cloudcultivation.service;
import com.cloudcultivation.po.Feeding;

import java.util.List;

/**
 * @author lzx
 */
public interface FeedingService {
    /*通过id查询饲养信息*/
    public Feeding selectFeedingById(int id);

    /*查询所有饲养信息*/
    public List<Feeding> selectAllFeeding();

    /*新增饲养信息*/
    public int addFeeding(Feeding feeding);

    /*更新饲养信息
     * 有外键的约束，我们数据库设计采用级联更新和删除，这里只能更新外键以外的信息
     * 若需要更新外键，只能删除再加入
     * */
    public int updateFeeding(Feeding feeding);

    /*通过id删除饲养信息*/
    public int deleteFeedingById(int id);
}
