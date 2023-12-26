package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.AdministratorMapper;
import com.cloudcultivation.po.Administrator;
import com.cloudcultivation.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈宇豪
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator selectAdministratorById(int id) {
        return administratorMapper.selectAdministratorById(id);
    }

    @Override
    public Administrator selectAdministratorByAccount(String account) {
        return administratorMapper.selectAdministratorByAccount(account);
    }

    @Override
    public List<Administrator> selectAllAdministrator() {
        return administratorMapper.selectAllAdministrator();
    }

    @Override
    public int addAdministrator(Administrator administrator) {
        return administratorMapper.addAdministrator(administrator);
    }

    @Override
    public int updateAdministrator(Administrator administrator) {
        return administratorMapper.updateAdministrator(administrator);
    }

    @Override
    public int deleteAdministratorById(int id) {
        return administratorMapper.deleteAdministratorById(id);
    }
}
