package com.szyh.mybatis;

public class Car {
     private String carNum;
    private String branb;
    private Float guidePrice;
    private String produceTime;
    private String carType;

    public Car(String carNum, String branb, Float guidePrice, String produceTime, String carType) {
        this.carNum = carNum;
        this.branb = branb;
        this.guidePrice = guidePrice;
        this.produceTime = produceTime;
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNum='" + carNum + '\'' +
                ", branb='" + branb + '\'' +
                ", guidePrice=" + guidePrice +
                ", produceTime='" + produceTime + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getBranb() {
        return branb;
    }

    public void setBranb(String branb) {
        this.branb = branb;
    }

    public Float getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(Float guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
