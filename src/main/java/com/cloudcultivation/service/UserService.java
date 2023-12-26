package com.cloudcultivation.service;


import com.cloudcultivation.po.User;

import java.util.List;

/**
 * @author Jiejie
 */
public interface UserService {

    /*通过id查询用户*/
    public User selectUserById(int id);

    /*通过account查询用户*/
    public User selectUserByAccount(String account);

    /*查询所有的用户*/
    public List<User> selectAllUser();

    /*插入新用户*/
    public int addUser(User user);

    /*更新用户信息*/
    public int updateUser(User user);

    /*通过id删除用户*/
    public int deleteUserById(int id);

    /*通过account和password判断用户登录*/
    public boolean loginByAccountAndPassword(String account, String password);

    /*判断用户account是否重复*/
    public boolean accountExist(String account);

    /*用户注册*/
    public boolean register(User user);
}
