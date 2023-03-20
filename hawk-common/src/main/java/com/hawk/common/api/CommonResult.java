package com.hawk.common.api;

import com.hawk.common.enums.ResultEnum;

/**
 * 通用返回基类
 *
 * @author 杨晨
 * @date 2023-03-17
 */
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;


    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultEnum.FAILED.getCode(), message, null);
    }
}
