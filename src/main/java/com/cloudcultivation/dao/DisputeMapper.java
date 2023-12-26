package com.cloudcultivation.dao;

import com.cloudcultivation.po.Dispute;

import java.util.List;
/**
 * @author 陈宇豪
 */
public interface DisputeMapper {
    public Dispute selectDisputeById(int id);

    public Dispute selectDisputeByOrdersId(int ordersId);

    public Dispute selectDisputeByServiceId(int serviceId);

    public List<Dispute> selectAllDispute();

    public int addDispute(Dispute dispute);

    public int updateDispute(Dispute dispute);

    public int deleteDisputeById(int id);
}
