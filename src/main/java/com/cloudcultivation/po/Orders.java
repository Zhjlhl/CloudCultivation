package com.cloudcultivation.po;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Jiejie
 */
public class Orders {
    private int id;
    private User user;
    private Merchant merchant;
    private Goods goods;
    private String description;
    private String paymentState;
    private BigDecimal amount;
    private String state;
    private String remark;
    private Timestamp date;
    private String insurance;
    private Timestamp endTime;
    private BigDecimal endYield;
    private String endState;
    private String nickname;
    private String feed;
    private List<Feeding> feedingList;
    private List<Harvest> harvestList;
    private List<Dispute> disputeList;
    private List<Buy> buyList;

    public Orders() {
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user=" + user +
                ", merchant=" + merchant +
                ", goods=" + goods +
                ", description='" + description + '\'' +
                ", paymentState='" + paymentState + '\'' +
                ", amount=" + amount +
                ", state='" + state + '\'' +
                ", remark='" + remark + '\'' +
                ", date=" + date +
                ", insurance='" + insurance + '\'' +
                ", endTime=" + endTime +
                ", endYield=" + endYield +
                ", endState='" + endState + '\'' +
                ", nickname='" + nickname + '\'' +
                ", feed='" + feed + '\'' +
                ", feedingList=" + feedingList +
                ", harvestList=" + harvestList +
                ", disputeList=" + disputeList +
                ", buyList=" + buyList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getEndYield() {
        return endYield;
    }

    public void setEndYield(BigDecimal endYield) {
        this.endYield = endYield;
    }

    public String getEndState() {
        return endState;
    }

    public void setEndState(String endState) {
        this.endState = endState;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public List<Feeding> getFeedingList() {
        return feedingList;
    }

    public void setFeedingList(List<Feeding> feedingList) {
        this.feedingList = feedingList;
    }

    public List<Harvest> getHarvestList() {
        return harvestList;
    }

    public void setHarvestList(List<Harvest> harvestList) {
        this.harvestList = harvestList;
    }

    public List<Dispute> getDisputeList() {
        return disputeList;
    }

    public void setDisputeList(List<Dispute> disputeList) {
        this.disputeList = disputeList;
    }

    public List<Buy> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<Buy> buyList) {
        this.buyList = buyList;
    }
}
