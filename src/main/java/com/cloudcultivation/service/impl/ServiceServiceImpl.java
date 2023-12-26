package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.ServiceMapper;
import com.cloudcultivation.po.Service;
import com.cloudcultivation.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


/**
 * @author Jiejie
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public Service selectServiceById(int id) {
        return serviceMapper.selectServiceById(id);
    }

    @Override
    public Service selectServiceByAccount(String account) {
        return serviceMapper.selectServiceByAccount(account);
    }

    @Override
    public List<Service> selectAllService() {
        return serviceMapper.selectAllService();
    }

    @Override
    public int addService(Service service) {
        return serviceMapper.addService(service);
    }

    @Override
    public int updateService(Service service) {
        return serviceMapper.updateService(service);
    }

    @Override
    public int deleteServiceById(int id) {
        return serviceMapper.deleteServiceById(id);
    }
}
