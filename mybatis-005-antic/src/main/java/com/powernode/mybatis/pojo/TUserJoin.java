package com.powernode.mybatis.pojo;

public class TUserJoin {
    private String sid;
    private String sname;
    private String cid;
    private TClazzJoin tClazzJoin;
    public TUserJoin() {

    }
    public TUserJoin(String sid, String sname, String cid, TClazzJoin tClazzJoin) {
        this.sid = sid;
        this.sname = sname;
        this.cid = cid;
        this.tClazzJoin = tClazzJoin;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public TClazzJoin gettClazzJoin() {
        return tClazzJoin;
    }

    public void settClazzJoin(TClazzJoin tClazzJoin) {
        this.tClazzJoin = tClazzJoin;
    }

    @Override
    public String toString() {
        return "TUserJoin{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", cid='" + cid + '\'' +
                ", tClazzJoin=" + tClazzJoin +
                '}';
    }
}
