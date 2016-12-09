package com.kinglong.common.error;

import java.io.Serializable;

/**
 * Created by chenjinlong on 2016/11/29.
 */
public interface BaseError extends Serializable{
    Integer getCode();

    String getMsg();
}
