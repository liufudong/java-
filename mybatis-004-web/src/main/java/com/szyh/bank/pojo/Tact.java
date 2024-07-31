package com.szyh.bank.pojo;

public class Tact {
    private String actno;
    private Double balance;

    public Tact(String actno, Double balance) {
        this.actno = actno;
        this.balance = balance;
    }
    public Tact() {

    }
    @Override
    public String toString() {
        return "Tact{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
