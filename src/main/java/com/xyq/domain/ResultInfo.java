package com.xyq.domain;

public class ResultInfo {
    private Boolean flag;
    private  Object object;
    private  String errorMsg;

    public ResultInfo() {
    }

    public ResultInfo(Boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public ResultInfo(Boolean flag) {
        this.flag = flag;
    }

    public ResultInfo(Boolean flag, Object object, String errorMsg) {
        this.flag = flag;
        this.object = object;
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", object=" + object +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
