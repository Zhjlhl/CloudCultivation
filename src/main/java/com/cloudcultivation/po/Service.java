package com.cloudcultivation.po;

import java.util.List;

/**
 * @author Jiejie
 */
public class Service {
    private int id;
    private String account;
    private String name;
    private String nickname;
    private String gender;
    private String phone;
    private String description;
    private String password;
    private String repassword;
    private List<Dispute> disputeList;

    public Service() {
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", disputeList=" + disputeList +
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public List<Dispute> getDisputeList() {
        return disputeList;
    }

    public void setDisputeList(List<Dispute> disputeList) {
        this.disputeList = disputeList;
    }
}
