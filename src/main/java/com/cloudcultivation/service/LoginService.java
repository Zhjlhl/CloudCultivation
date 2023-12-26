package com.cloudcultivation.service;


import com.cloudcultivation.po.Administrator;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.Service;
import com.cloudcultivation.po.User;

/**
 * @author Jiejie
 */
public interface LoginService {
    
    /*
     * @description: 登录账号
     * @param account 账号
     * @param password 密码
     * @param type 登录人类别
     * @author Jiejie
     */
    public boolean loginByAccountAndPassword(String account, String password, String type);

    /*
     * @description: 判断用户account是否不存在
     * @param account 账号
     * @param type 类别
     * @author: Jiejie
     */
    public boolean accountNonexistence(String account, String type);
    
    /*
     * @description: 用户注册
     * @param user 用户
     * @author: Jiejie
     */
    public boolean registerUser(User user);

    /*
     * @description: 商家注册
     * @param merchant 商家信息
     * @author: Jiejie
     */
    public boolean registerMerchant(Merchant merchant);

    /*
     * @description: 客服注册
     * @param service 客服信息
     * @author: Jiejie
     */
    public boolean registerService(Service service);

    /*
     * @description: 管理员注册
     * @param administrator 管理员信息
     * @author: Jiejie
     */
    public boolean registerAdministrator(Administrator administrator);
}
