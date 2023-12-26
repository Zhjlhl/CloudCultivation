package com.cloudcultivation.dao;

import com.cloudcultivation.po.Service;

import java.util.List;

/**
 * @author Jiejie
 */
public interface ServiceMapper {

    public Service selectServiceById(int id);

    public Service selectServiceByAccount(String account);

    public List<Service> selectAllService();

    public int addService(Service service);

    public int updateService(Service service);

    public int deleteServiceById(int id);
}
