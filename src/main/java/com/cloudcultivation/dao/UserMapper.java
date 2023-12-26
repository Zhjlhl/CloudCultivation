package com.cloudcultivation.dao;

import com.cloudcultivation.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jiejie
 */
public interface UserMapper {

    public User selectUserById(int id);

    public User selectUserByAccount(String account);

    public List<User> selectAllUser();

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUserById(int id);
}
