package com.cloudcultivation.service.impl;


import com.cloudcultivation.dao.HarvestMapper;
import com.cloudcultivation.po.Harvest;
import com.cloudcultivation.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyy
 */
@Service
public class HarvestServiceImpl implements HarvestService {
    @Autowired
    private HarvestMapper harvestMapper;

    @Override
    public Harvest selectHarvestById(int id) {
        return harvestMapper.selectHarvestById(id);
    }

    @Override
    public List<Harvest> selectAllHarvest() {
        return harvestMapper.selectAllHarvest();
    }

    @Override
    public int addHarvest(Harvest harvest) {
        return harvestMapper.addHarvest(harvest);
    }

    @Override
    public int updateHarvest(Harvest harvest) {
        return harvestMapper.updateHarvest(harvest);
    }

    @Override
    public int deleteHarvestById(int id) {
        return harvestMapper.deleteHarvestById(id);
    }

    @Override
    public Harvest getDeliveryState(Harvest harvest) {
        String number = harvest.getNumber();
        if (number.isEmpty()){
            harvest.setState("未发货");
        }else {
            harvest.setState("已发货");
        }
        return harvest;
    }

}
