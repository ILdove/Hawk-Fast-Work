package com.hawk.common.enums;


/**
 * 返回结果枚举
 *
 * @author 杨晨
 * @date 2023-03-17
 */
public enum ResultEnum {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
