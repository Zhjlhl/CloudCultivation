package com.cloudcultivation.po;


import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jiejie
 */
public class Merchant {
    private int id;
    private String account;
    private String name;
    private String password;
    private String repassword;
    private String contacts;
    private String phone;
    private String description;
    private BigDecimal balance;
    private BigDecimal promise;
    private List<Orders> ordersList;
    private List<Feed> feedList;
    private List<Goods> goodsList;

    public Merchant() {
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", balance=" + balance +
                ", promise=" + promise +
                ", ordersList=" + ordersList +
                ", feedList=" + feedList +
                ", goodsList=" + goodsList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getPromise() {
        return promise;
    }

    public void setPromise(BigDecimal promise) {
        this.promise = promise;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<Feed> getFeedList() {
        return feedList;
    }

    public void setFeedList(List<Feed> feedList) {
        this.feedList = feedList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
