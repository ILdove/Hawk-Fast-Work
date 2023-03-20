package com.hawk.common.annotation;


import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 *
 * @author 杨晨
 * @date 2023-03-20
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 操作模块
     */
    public String menu() default "";

    /**
     * 操作类型
     */
    public String logType() default "";

}
