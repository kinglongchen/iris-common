package com.kinglong.common.result;

import com.kinglong.common.error.CommonError;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by chenjinlong on 2016/11/28.
 */
public class Result<D> extends BaseResult {
    private static final long serialVersionUID = -5682612310511509963L;
    @Getter
    @Setter
    private D data;

    public static <D> Result<D> wrapSuccessfulResult(D data) {
        Result<D> result = new Result<D>();
        result.data = data;
        result.success = true;
        return result;
    }


    public static <D> Result<D> wrapErrorResult(CommonError error) {
        Result<D> result = new Result<D>();
        result.success = false;
        result.code = error.getCode();
        result.message = error.getMsg();
        return result;
    }

    public static <D> Result<D> wrapErrorResult(CommonError error, Object... extendMsg) {
        Result<D> result = new Result<D>();
        result.success = false;
        result.code = error.getCode();
        result.message = String.format(error.getMsg(), extendMsg);
        return result;
    }

    public static <D> Result<D> wrapErrorResult(Integer code, String message) {
        Result<D> result = new Result<D>();
        result.success = false;
        result.code = code;
        result.message = message;
        return result;
    }
}
