package com.cloudcultivation.dao;

import com.cloudcultivation.po.Merchant;

import java.util.List;

/**
 * @author Jiejie
 */
public interface MerchantMapper {

    public Merchant selectMerchantById(int id);

    public Merchant selectMerchantByAccount(String account);

    public List<Merchant> selectAllMerchant();

    public int addMerchant(Merchant merchant);

    public int updateMerchant(Merchant merchant);

    public int deleteMerchantById(int id);
}
