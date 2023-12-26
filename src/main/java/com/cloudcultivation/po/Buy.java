package com.cloudcultivation.po;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author 陈宇豪
 */
public class Buy {
    private int id;
    private Orders orders;
    private Feed feed;
    private int amount;
    private String description;
    private String paymentState;
    private BigDecimal paymentAmount;
    private Timestamp date;
    private int remain;

    public Buy() {
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", orders=" + orders +
                ", feed=" + feed +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", paymentState='" + paymentState + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", date=" + date +
                ", remain=" + remain +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
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

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = Timestamp.valueOf(date);
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }
}
