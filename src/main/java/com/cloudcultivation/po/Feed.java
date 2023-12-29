package com.cloudcultivation.po;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author lzx
 */
public class Feed {
    private int id;
    private String name;
    private BigDecimal price;
    private int amount;
    private String description;
    private Merchant merchant;
    private int remain;
    private String check;
    private List<Buy> buyList;

    public Feed() {
    }

    @Override
    public String toString() {
        return "Feed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", merchant=" + merchant +
                ", remain=" + remain +
                ", check='" + check + '\'' +
                ", buyList=" + buyList +
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public List<Buy> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<Buy> buyList) {
        this.buyList = buyList;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}
