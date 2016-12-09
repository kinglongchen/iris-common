package com.kinglong.common.result;

import com.kinglong.common.error.BaseError;
import com.kinglong.common.error.CommonError;
import com.kinglong.common.exception.BaseException;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by chenjinlong on 2016/11/28.
 */
@Data
public class BaseResult implements Serializable{
    private static final long serialVersionUID = -7354414824242612327L;
    protected boolean success;
    protected Integer code;
    protected String message;
}
