package com.powernode.mybatis.pojo;

import java.math.BigDecimal;

public class Car {
    private Integer id;

    private String carNum;

    private String produceTime;

    private String carType;

    private BigDecimal guidePrice;

    private String branb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum == null ? null : carNum.trim();
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime == null ? null : produceTime.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getBranb() {
        return branb;
    }

    public void setBranb(String branb) {
        this.branb = branb == null ? null : branb.trim();
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carNum='" + carNum + '\'' +
                ", produceTime='" + produceTime + '\'' +
                ", carType='" + carType + '\'' +
                ", guidePrice=" + guidePrice +
                ", branb='" + branb + '\'' +
                '}';
    }
}