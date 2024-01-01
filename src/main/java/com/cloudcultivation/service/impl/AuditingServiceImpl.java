package com.cloudcultivation.service.impl;
import com.cloudcultivation.dao.*;
import com.cloudcultivation.po.Dispute;
import com.cloudcultivation.po.Harvest;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.User;
import com.cloudcultivation.service.AuditingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author Jiejie
 */
@Service
public class AuditingServiceImpl implements AuditingService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MerchantMapper merchantMapper;
    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private DisputeMapper disputeMapper;
    @Autowired
    private HarvestMapper harvestMapper;
    @Override
    public boolean AuditingDispute(int id, String disputeState, String disputeResult, String disputeCheck,
                                   BigDecimal disputeAmount,String harvestState,String harvestNumber) {
        Dispute dispute=disputeMapper.selectDisputeById(id);
        User user=userMapper.selectUserById(dispute.getOrders().getUser().getId());
        Merchant merchant=merchantMapper.selectMerchantById(dispute.getOrders().getMerchant().getId());
        Harvest harvest=harvestMapper.selectHarvestByOrdersId(dispute.getOrders().getId());
        if(harvestNumber==null&&harvestState==null){
            user.setBalance(user.getBalance().add(disputeAmount));
            merchant.setPromise(merchant.getPromise().subtract(disputeAmount));
            userMapper.updateUser(user);
            merchantMapper.updateMerchant(merchant);
            dispute.setCheck(disputeCheck);
            dispute.setState(disputeState);
            dispute.setDate(new Timestamp(System.currentTimeMillis()));
            dispute.setResult(disputeResult);
            disputeMapper.updateDispute(dispute);
            return true;
        }
        else if(harvestNumber!=null||harvestState!=null){
            user.setBalance(user.getBalance().add(disputeAmount));
            userMapper.updateUser(user);
            merchant.setPromise(merchant.getPromise().subtract(disputeAmount));
            merchantMapper.updateMerchant(merchant);
            dispute.setCheck(disputeCheck);
            dispute.setState(disputeState);
            dispute.setDate(new Timestamp(System.currentTimeMillis()));
            dispute.setResult(disputeResult);
            disputeMapper.updateDispute(dispute);
            harvest.setState(harvestState);
            harvest.setNumber(harvestNumber);
            harvestMapper.updateHarvest(harvest);
            return true;
        }
        return false;
    }
}
