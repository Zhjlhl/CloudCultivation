package com.cloudcultivation.service;

import com.cloudcultivation.po.Harvest;

import java.util.List;

/**
 * @author hyy
 */
public interface HarvestService {
    /*通过id查询收获信息*/
    public Harvest selectHarvestById(int id);

    /*查询所有收获信息*/
    public List<Harvest> selectAllHarvest();

    /*新增收获信息*/
    public int addHarvest(Harvest harvest);

    /*更新收获信息
     * 有外键的约束，我们数据库设计采用级联更新和删除，这里只能更新外键以外的信息
     * 若需要更新外键，只能删除再加入
     * */
    public int updateHarvest(Harvest harvest);

    /*通过id删除收获信息*/
    public int deleteHarvestById(int id);


    /*更新快递状态状态参数*/
    public Harvest getDeliveryState(Harvest harvest);


}
