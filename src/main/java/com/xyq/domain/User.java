package com.xyq.domain;

public class User {
    private Integer uid;
    private String uname;
    private String upassword;
    private String phone;
    private String fid;

    public User() {
    }

    public User(Integer uid, String uname, String upassword, String phone, String fid) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.phone = phone;
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", phone='" + phone + '\'' +
                ", fid='" + fid + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}
