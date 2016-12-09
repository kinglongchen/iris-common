package com.kinglong.common.exception;

import com.kinglong.common.error.BaseError;
import com.kinglong.common.error.CommonError;
import lombok.Getter;

/**
 * Created by chenjinlong on 2016/11/29.
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -617286697424424445L;


    private static final Integer DEFAULT_ERROR_CODE = 0;
    @Getter
    Integer errorCode;

    @Getter
    String errorMsg;

    public BaseException() {
        this(CommonError.COMMON_ERROR);
    }

    public BaseException(BaseError err) {
        this(err.getCode(),err.getMsg());
    }

    public BaseException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;

        this.errorMsg = errorMsg;
    }

    public BaseException(String errorMsg) {
        this(DEFAULT_ERROR_CODE,errorMsg);
    }
}
