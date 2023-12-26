package com.cloudcultivation.dao;

import com.cloudcultivation.po.Administrator;

import java.util.List;
/**
 * @author 陈宇豪
 */
public interface AdministratorMapper {
    public Administrator selectAdministratorById(int id);

    public Administrator selectAdministratorByAccount(String account);

    public List<Administrator> selectAllAdministrator();

    public int addAdministrator(Administrator administrator);

    public int updateAdministrator(Administrator administrator);

    public int deleteAdministratorById(int id);
}
