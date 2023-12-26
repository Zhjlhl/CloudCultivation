package com.cloudcultivation.service;


import com.cloudcultivation.po.Service;

import java.util.List;

/**
 * @author Jiejie
 */
public interface ServiceService {

    /*通过id查询客服*/
    public Service selectServiceById(int id);

    /*通过account查询客服*/
    public Service selectServiceByAccount(String account);

    /*查询所有客服*/
    public List<Service> selectAllService();

    /*新增客服*/
    public int addService(Service service);

    /*更新客服信息*/
    public int updateService(Service service);

    /*通过id删除客服*/
    public int deleteServiceById(int id);


}
