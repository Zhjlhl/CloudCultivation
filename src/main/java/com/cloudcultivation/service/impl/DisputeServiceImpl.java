package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.DisputeMapper;
import com.cloudcultivation.po.Dispute;
import com.cloudcultivation.service.DisputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈宇豪
 */
@Service
public class DisputeServiceImpl implements DisputeService {

    @Autowired
    private DisputeMapper disputeMapper;

    @Override
    public Dispute selectDisputeById(int id) {
        return disputeMapper.selectDisputeById(id);
    }

    @Override
    public List<Dispute> selectAllDispute() {
        return disputeMapper.selectAllDispute();
    }

    @Override
    public int addDispute(Dispute dispute) {
        return disputeMapper.addDispute(dispute);
    }

    @Override
    public int updateDispute(Dispute dispute) {
        return disputeMapper.updateDispute(dispute);
    }

    @Override
    public int deleteDisputeById(int id) {
        return disputeMapper.deleteDisputeById(id);
    }
}
