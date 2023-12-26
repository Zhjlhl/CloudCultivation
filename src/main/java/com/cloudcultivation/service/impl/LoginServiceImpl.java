package com.cloudcultivation.service.impl;

import com.cloudcultivation.dao.AdministratorMapper;
import com.cloudcultivation.dao.MerchantMapper;
import com.cloudcultivation.dao.ServiceMapper;
import com.cloudcultivation.dao.UserMapper;
import com.cloudcultivation.po.Administrator;
import com.cloudcultivation.po.Merchant;
import com.cloudcultivation.po.Service;
import com.cloudcultivation.po.User;
import com.cloudcultivation.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Jiejie
 */
@org.springframework.stereotype.Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private ServiceMapper serviceMapper;

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public boolean loginByAccountAndPassword(String account, String password, String type) {
        if ("user".equals(type)){
            User user = userMapper.selectUserByAccount(account);
            return user.getPassword().equals(password);
        } else if ("merchant".equals(type)) {
            Merchant merchant = merchantMapper.selectMerchantByAccount(account);
            return merchant.getPassword().equals(password);
        } else if ("service".equals(type)) {
            Service service = serviceMapper.selectServiceByAccount(account);
            return service.getPassword().equals(password);
        } else if ("administrator".equals(type)) {
            Administrator administrator = administratorMapper.selectAdministratorByAccount(account);
            return administrator.getPassword().equals(password);
        }
        return false;
    }

    @Override
    public boolean accountNonexistence(String account, String type) {
        if ("user".equals(type)){
            User user = userMapper.selectUserByAccount(account);
            return user == null;
        } else if ("merchant".equals(type)) {
            Merchant merchant = merchantMapper.selectMerchantByAccount(account);
            return merchant ==null;
        } else if ("service".equals(type)) {
            Service service = serviceMapper.selectServiceByAccount(account);
            return service == null;
        } else if ("administrator".equals(type)) {
            Administrator administrator = administratorMapper.selectAdministratorByAccount(account);
            return administrator == null;
        }
        return false;
    }

    @Override
    public boolean registerUser(User user) {
        if (this.accountNonexistence(user.getAccount(), "user")){
            if (user.getPassword().equals(user.getRepassword())){
                int i = userMapper.addUser(user);
                return i > 0;
            }
        }
        return false;
    }

    @Override
    public boolean registerMerchant(Merchant merchant) {
        if (this.accountNonexistence(merchant.getAccount(), "merchant")){
            if (merchant.getPassword().equals(merchant.getRepassword())){
                int i = merchantMapper.addMerchant(merchant);
                return i > 0;
            }
        }
        return false;
    }

    @Override
    public boolean registerService(Service service) {
        if (this.accountNonexistence(service.getAccount(), "service")){
            if (service.getPassword().equals(service.getRepassword())){
                int i = serviceMapper.addService(service);
                return i > 0;
            }
        }
        return false;
    }

    @Override
    public boolean registerAdministrator(Administrator administrator) {
        if (this.accountNonexistence(administrator.getAccount(), "administrator")){
            if (administrator.getPassword().equals(administrator.getRepassword())){
                int i = administratorMapper.addAdministrator(administrator);
                return i > 0;
            }
        }
        return false;
    }
}
