package com.kinglong.common.error;

/**
 * Created by chenjinlong on 2016/11/29.
 */
public enum  CommonError implements BaseError {
    SYSTEM_ERROR(10000001,"系统内部错误，请稍后再试!"),
    COMMON_ERROR(10000002,"Common Error!"),
    PARAM_ERROR(10000004,"参数错误！"),
    PARAM_NULL_ERROR(10000003,"参数为空错误！"),
    PARAM_BLANK_ERROR(10000004,"参数为空或空串错误！")
    ;

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
