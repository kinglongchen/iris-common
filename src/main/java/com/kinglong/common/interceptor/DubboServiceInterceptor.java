package com.kinglong.common.interceptor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kinglong.common.error.CommonError;
import com.kinglong.common.exception.BaseException;
import com.kinglong.common.result.BaseResult;
import com.kinglong.common.result.PagingResult;
import com.kinglong.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by chenjinlong on 2016/11/29.
 */
@Slf4j
public class DubboServiceInterceptor<T extends BaseResult> implements MethodInterceptor {


    public T invoke(MethodInvocation methodInvocation) throws Throwable {
        T result;
        try {
            Long startTime=System.currentTimeMillis();
            log.info("Dubbo服务[method=" + methodInvocation.getMethod() + "] params=" + JSONArray.toJSONString(methodInvocation.getArguments()));
            result = (T) methodInvocation.proceed();
            log.info("[method=" + methodInvocation.getMethod() + "] cost:" + (System.currentTimeMillis()-startTime)+"|"+ JSONObject.toJSONString(result));
            return result;
        } catch (BaseException e) {
            log.error(String.format("Dubbo服务异常[method=%s] params=%s",methodInvocation.getMethod(),JSONArray.toJSONString(methodInvocation.getArguments())),e);
            result = (T)(methodInvocation.getMethod().getReturnType().newInstance());
            result.setCode(e.getErrorCode());
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }  catch (Exception e) {
            log.error(String.format("Dubbo服务异常[method=%s] params=%s",methodInvocation.getMethod(),JSONArray.toJSONString(methodInvocation.getArguments())),e);
            result = (T)(methodInvocation.getMethod().getReturnType().newInstance());
            result.setCode(CommonError.SYSTEM_ERROR.getCode());
            result.setMessage(CommonError.SYSTEM_ERROR.getMsg());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }
}
