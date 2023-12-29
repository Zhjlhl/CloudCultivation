package com.cloudcultivation.service;

import java.math.BigDecimal;

/**
 * @author lzx
 */
public interface AdoptService {

    /*通过密码购买货物*/
    public boolean paymentGoodsByPassword(String account, String password, BigDecimal price);

}
