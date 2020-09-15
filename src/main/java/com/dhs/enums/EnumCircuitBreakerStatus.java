package com.dhs.enums;

/**
 * @author hongsend
 * @date 2020/9/15 18:20
 * @desc
 */
public enum EnumCircuitBreakerStatus {
    open(0,"打开"),
    colse(1,"关闭");

    int code;
    String  decs;

    EnumCircuitBreakerStatus(int code, String decs) {
        this.code = code;
        this.decs = decs;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }
}
