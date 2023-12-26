package com.cloudcultivation.service;
import com.cloudcultivation.po.Dispute;

import java.util.List;

/**
 * @author 陈宇豪
 */
public interface DisputeService {

    /*通过id查询纠纷*/
    public Dispute selectDisputeById(int id);

    /*查询所有纠纷*/
    public List<Dispute> selectAllDispute();

    /*新增纠纷*/
    public int addDispute(Dispute dispute);

    /*更新就纠纷信息*/
    public int updateDispute(Dispute dispute);

    /*通过id删除纠纷*/
    public int deleteDisputeById(int id);

}

