package com.hawk.common.exception;

import com.hawk.common.base.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理程序
 *
 * @author 杨晨
 * @date 2023-03-20
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResult handle(Exception e) {
        return BaseResult.failed(e.getMessage());
    }
}
