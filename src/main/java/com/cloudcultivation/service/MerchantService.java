package com.cloudcultivation.service;

import com.cloudcultivation.po.Merchant;

import java.util.List;

/**
 * @author hyy
 */
public interface MerchantService {
    /*通过id查询商家信息*/
    public Merchant selectMerchantById(int id);

    /*通过account查询商家信息*/
    public Merchant selectMerchantByAccount(String account);

    /*查询所有商家信息*/
    public List<Merchant> selectAllMerchant();

    /*新增商家信息*/
    public int addMerchant(Merchant merchant);

    /*更新商商家信息
     * */
    public int updateMerchant(Merchant merchant);

    /*通过id删除商家信息*/
    public int deleteMerchantById(int id);
}
