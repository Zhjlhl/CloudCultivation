package com.cloudcultivation.po;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author hyy
 */
public class Harvest {
    private int id;
    private Timestamp date;
    private String way;
    private String delivery;
    private BigDecimal earnings;
    private String state;
    private String number;
    private Orders orders;

    public Harvest(){
    }

    @Override
    public String toString() {
        return "Harvest{" +
                "id=" + id +
                ", date=" + date +
                ", way='" + way + '\'' +
                ", delivery='" + delivery + '\'' +
                ", earnings=" + earnings +
                ", state='" + state + '\'' +
                ", number='" + number + '\'' +
                ", orders=" + orders +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public BigDecimal getEarnings() {
        return earnings;
    }

    public void setEarnings(BigDecimal earnings) {
        this.earnings = earnings;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
