package com.xyq.domain;

public class Detail {
    private String fid;
    private Integer nodeId;
    private String name;
    private String sex;
    private String headImgUrl;
    private String details;
    private String phone;

    public Detail() {
    }

    public Detail(String fid, Integer nodeId, String name, String sex, String headImgUrl, String details, String phone) {
        this.fid = fid;
        this.nodeId = nodeId;
        this.name = name;
        this.sex = sex;
        this.headImgUrl = headImgUrl;
        this.details = details;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "fid='" + fid + '\'' +
                ", nodeId=" + nodeId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", details='" + details + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
