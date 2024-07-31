package com.powernode.mybatis.pojo;

public class Car {
    private Long id;
    private String carNum;
    private String branb;
    private Double guidePrice;
    private String produceTime;
    private String carType;

    public Car () {
    }

    public Car(Long id, String carNum, String branb, Double guidePrice, String produceTime, String carType) {
        this.id = id;
        this.carNum = carNum;
        this.branb = branb;
        this.guidePrice = guidePrice;
        this.produceTime = produceTime;
        this.carType = carType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(Double guidePrice) {
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carNum='" + carNum + '\'' +
                ", branb='" + branb + '\'' +
                ", guidePrice=" + guidePrice +
                ", produceTime='" + produceTime + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
