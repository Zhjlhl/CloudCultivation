package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.MerchantMapper;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyy
 */
@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Merchant selectMerchantById(int id) {
        return merchantMapper.selectMerchantById(id);
    }

    @Override
    public Merchant selectMerchantByAccount(String account) {
        return merchantMapper.selectMerchantByAccount(account);
    }

    @Override
    public List<Merchant> selectAllMerchant() {
        return merchantMapper.selectAllMerchant();
    }

    @Override
    public int addMerchant(Merchant merchant) {
        return merchantMapper.addMerchant(merchant);
    }

    @Override
    public int updateMerchant(Merchant merchant) {
        return merchantMapper.updateMerchant(merchant);
    }

    @Override
    public int deleteMerchantById(int id) {
        return merchantMapper.deleteMerchantById(id);
    }
}
