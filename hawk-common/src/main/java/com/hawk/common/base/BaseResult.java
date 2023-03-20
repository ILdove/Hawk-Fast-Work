package com.hawk.common.base;

import com.hawk.common.enums.ResultEnum;

/**
 * 通用返回基类
 *
 * @author 杨晨
 * @date 2023-03-17
 */
public class BaseResult<T> {

    private Integer code;
    private String message;
    private T data;


    public BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> BaseResult<T> success(T data, String message) {
        return new BaseResult<T>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> BaseResult<T> failed(String message) {
        return new BaseResult<T>(ResultEnum.FAILED.getCode(), message, null);
    }
}
