package com.cloudcultivation.po;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author 陈宇豪
 */
public class Dispute {
    private int id;
    private Orders orders;
    private Service service;
    private String description;
    private String state;
    private String result;
    private BigDecimal amount;
    private String type;
    private Timestamp date;
    private String check;

    public Dispute() {
    }

    @Override
    public String toString() {
        return "Dispute{" +
                "id=" + id +
                ", orders=" + orders +
                ", service=" + service +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", result='" + result + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", check='" + check + '\'' +
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}
