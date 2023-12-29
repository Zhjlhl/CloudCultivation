package com.cloudcultivation.po;


import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jiejie
 */
public class Goods {
    private int id;
    private String name;
    private String type;
    private Merchant merchant;
    private BigDecimal price;
    private String description;
    private String growth;
    private String yield;
    private int amount;
    private int remain;
    private String check;
    private List<Orders> ordersList;

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", merchant=" + merchant +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", growth='" + growth + '\'' +
                ", yield='" + yield + '\'' +
                ", amount=" + amount +
                ", remain=" + remain +
                ", check='" + check + '\'' +
                ", ordersList=" + ordersList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
