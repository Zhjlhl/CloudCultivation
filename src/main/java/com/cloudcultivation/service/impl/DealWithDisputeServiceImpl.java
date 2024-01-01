package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.*;
import com.cloudcultivation.po.Dispute;
import com.cloudcultivation.po.Harvest;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.User;
import com.cloudcultivation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author 陈宇豪
 */
@Service
public class DealWithDisputeServiceImpl implements DealWithDisputeService {
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
    public boolean DealWithDispute(int id) {
        Dispute dispute1=disputeMapper.selectDisputeById(id);
        User user1=userMapper.selectUserById(dispute1.getOrders().getUser().getId());
        Merchant merchant1=merchantMapper.selectMerchantById(dispute1.getOrders().getMerchant().getId());
        Harvest harvest1=harvestMapper.selectHarvestByOrdersId(dispute1.getOrders().getId());
        if(dispute1.getType().equals("中途死亡")) {
            if(dispute1.getOrders().getInsurance().equals("已买保险")){
                user1.setBalance(user1.getBalance().add(dispute1.getAmount()));
                userMapper.updateUser(user1);
                merchant1.setBalance(merchant1.getPromise().subtract(dispute1.getAmount()));
                merchantMapper.updateMerchant(merchant1);
                dispute1.setState("已解决");
                dispute1.setResult("用户已买保险，可全额退还！");
                dispute1.setCheck("已审核");
                dispute1.setDate(new Timestamp(System.currentTimeMillis()));
                disputeMapper.updateDispute(dispute1);
                return true;
                }
            else{
                user1.setBalance(user1.getBalance().add(dispute1.getAmount()));
                userMapper.updateUser(user1);
                merchant1.setBalance(merchant1.getPromise().subtract(dispute1.getAmount()));
                merchantMapper.updateMerchant(merchant1);
                dispute1.setState("已解决");
                dispute1.setResult("用户未买保险，可退还85%的订单金额！");
                dispute1.setCheck("已审核");
                dispute1.setDate(new Timestamp(System.currentTimeMillis()));
                disputeMapper.updateDispute(dispute1);
                return true;
            }
        }
        else if(dispute1.getType().equals("货不对板")){
            merchant1.setBalance(merchant1.getPromise().subtract(dispute1.getAmount()));
            merchantMapper.updateMerchant(merchant1);
            harvest1.setState("未发货");
            harvest1.setNumber(null);
            harvestMapper.updateHarvest(harvest1);
            dispute1.setState("初步处理");
            dispute1.setResult("已对商家进行罚款并要求其重新发货，用户无需将错误商品寄回");
            dispute1.setCheck("已审核");
            dispute1.setDate(new Timestamp(System.currentTimeMillis()));
            disputeMapper.updateDispute(dispute1);
            return true;
        }
        else if (dispute1.getType().equals("用户退出")){
            user1.setBalance(user1.getBalance().add(dispute1.getAmount()));
            userMapper.updateUser(user1);
            merchant1.setPromise(merchant1.getPromise().subtract(dispute1.getAmount()));
            merchantMapper.updateMerchant(merchant1);
            dispute1.setState("已解决");
            dispute1.setResult("已退还用户所支付的费用，感谢用户参与云养殖");
            dispute1.setCheck("已审核");
            dispute1.setDate(new Timestamp(System.currentTimeMillis()));
            disputeMapper.updateDispute(dispute1);
            return true;
        } else if (dispute1.getType().equals("少发货")) {
            merchant1.setBalance(merchant1.getPromise().subtract(dispute1.getAmount()));
            merchantMapper.updateMerchant(merchant1);
            harvest1.setState("未发货");
            harvest1.setNumber(null);
            harvestMapper.updateHarvest(harvest1);
            dispute1.setState("初步处理");
            dispute1.setResult("已对商家进行罚款并催促发货，很抱歉给您带来不便");
            dispute1.setCheck("已审核");
            dispute1.setDate(new Timestamp(System.currentTimeMillis()));
            disputeMapper.updateDispute(dispute1);
            return true;
        }
        return false;
    }
    public boolean DealWithDispute(int id, String disputeState, String disputeResult, String disputeCheck,
                                   BigDecimal disputeAmount, String harvestState, String harvestNumber) {
        AuditingService auditingService=new AuditingServiceImpl();
        if(auditingService.AuditingDispute(id, disputeState, disputeResult, disputeCheck, disputeAmount, harvestState, harvestNumber))
            return true;
        else return false;
    }
}
