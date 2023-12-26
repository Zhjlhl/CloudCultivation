package com.cloudcultivation.po;

import java.sql.Timestamp;


/**
 * @author lzx
 */
public class Feeding {
    private int id;
    private Orders orders;
    private String state;
    private String photo;
    private String video;
    private Timestamp date;
    private double weight;
    private String check;

    public Feeding() {
    }

    @Override
    public String toString() {
        return "Feeding{" +
                "id=" + id +
                ", orders=" + orders +
                ", state='" + state + '\'' +
                ", photo='" + photo + '\'' +
                ", video='" + video + '\'' +
                ", date=" + date +
                ", weight=" + weight +
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}
