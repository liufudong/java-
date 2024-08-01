package com.powernode.mybatis.pojo;

import java.util.List;

public class TClazzJoin {
    private String cname;
    private String cid;

    private List<TUserJoin> stus;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<TUserJoin> getStus() {
        return stus;
    }

    public void setStus(List<TUserJoin> stus) {
        this.stus = stus;
    }

    public TClazzJoin(String cname, String cid, List<TUserJoin> stus) {
        this.cname = cname;
        this.cid = cid;
        this.stus = stus;
    }

    public TClazzJoin( ) {
    }

    @Override
    public String toString() {
        return "TClazzJoin{" +
                "cname='" + cname + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
