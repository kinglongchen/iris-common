package com.kinglong.common.error;

/**
 * Created by chenjinlong on 2016/11/29.
 */
public enum  CommonError implements BaseError {
    SYSTEM_ERROR(0,"系统内部错误，请稍后再试!"),
    COMMON_ERROR(1,"Common Error!");

    private final Integer code;

    private final String msg;


    CommonError(Integer code, String msg) {
        this.code  = code;

        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
