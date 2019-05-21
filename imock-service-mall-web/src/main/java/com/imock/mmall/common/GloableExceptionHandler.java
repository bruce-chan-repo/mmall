package com.imock.mmall.common;

import com.imock.mmall.exception.ParamException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常控制类
 * @author: Chen Kj
 * @date: 2018/8/21 17:29
 * @version: 1.0
 */
@ControllerAdvice
public class GloableExceptionHandler {


    @ExceptionHandler(ParamException.class)
    @ResponseBody
    public String paramException(ParamException e) {

        return "";
    }
}
