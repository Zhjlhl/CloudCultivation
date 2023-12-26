package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.UserMapper;
import com.cloudcultivation.po.User;
import com.cloudcultivation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiejie
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public User selectUserByAccount(String account) {
        return userMapper.selectUserByAccount(account);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public boolean loginByAccountAndPassword(String account, String password) {
        User selected = userMapper.selectUserByAccount(account);
        return selected.getPassword().equals(password);
    }

    @Override
    public boolean accountExist(String account) {
        if (userMapper.selectUserByAccount(account) != null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean register(User user) {
        /*account存在不能register*/
        if (this.accountExist(user.getAccount())) {
            return false;
        }
        /*密码和重复密码应该相同才能注册*/
        if (user.getPassword().equals(user.getRepassword())){
            int i = this.addUser(user);
            return i > 0;
        }
        return false;
    }
}
