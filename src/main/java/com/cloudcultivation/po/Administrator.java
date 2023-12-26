package com.cloudcultivation.po;
/**
 * @author 陈宇豪
 */
public class Administrator {
    private int id;
    private String account;
    private String password;
    /*
     * @description: 重复密码的属性，在登录注册时使用，数据库中不存在该列
     */
    private String repassword;
    private String phone;
    private String type;
    private String description;

    public Administrator() {
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
