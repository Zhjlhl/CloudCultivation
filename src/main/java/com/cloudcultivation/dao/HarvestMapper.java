package com.cloudcultivation.dao;


import com.cloudcultivation.po.Harvest;

import java.util.List;

/**
 * @author hyy
 */
public interface HarvestMapper {

    public Harvest selectHarvestById(int id);

    public Harvest selectHarvestByOrdersId(int ordersId);

    public List<Harvest> selectAllHarvest();

    public int addHarvest(Harvest harvest);

    public int updateHarvest(Harvest harvest);

    public int deleteHarvestById(int id);

}
