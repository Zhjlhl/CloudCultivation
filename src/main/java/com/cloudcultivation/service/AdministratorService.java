package com.cloudcultivation.service;

import com.cloudcultivation.po.Administrator;

import java.util.List;


/**
 * @author 陈宇豪
 */
public interface AdministratorService {

    /*通过id查询管理员*/
    public Administrator selectAdministratorById(int id);

    /*通过account查询管理员*/
    public Administrator selectAdministratorByAccount(String account);


    /*查询所有管理员*/
    public List<Administrator> selectAllAdministrator();

    /*新增管理员*/
    public int addAdministrator(Administrator administrator);

    /*更新管理员*/
    public int updateAdministrator(Administrator administrator);

    /*通过id删除管理员*/
    public int deleteAdministratorById(int id);
}
