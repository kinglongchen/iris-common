package com.kinglong.common.result;

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
}
