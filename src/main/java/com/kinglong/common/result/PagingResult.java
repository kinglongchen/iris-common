package com.kinglong.common.result;

import lombok.Getter;

import java.util.List;

/**
 * Created by chenjinlong on 16/12/9.
 */
public class PagingResult<D> extends BaseResult {
    @Getter
    private List<D> list;

    @Getter
    private int total;

    public PagingResult() {
    }

    public static <T> PagingResult<T> wrapSuccessfulResult(List<T> data, int total) {
        PagingResult<T> result = new PagingResult<T>();
        result.list = data;
        result.total = total;
        result.success = true;
        return result;
    }

    public static <T> PagingResult<T> wrapErrorResult(BaseResult error) {
        PagingResult<T> result = new PagingResult<T>();
        result.success = false;
        result.code = error.getCode();
        result.message = error.getMessage();
        return result;
    }

    public static <T> PagingResult<T> wrapErrorResult(Integer code, String message) {
        PagingResult<T> result = new PagingResult<T>();
        result.success = false;
        result.code = code;
        result.message = message;
        return result;
    }
}
