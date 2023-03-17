package com.hawk.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus配置
 *
 * @author 杨晨
 * @date 2023-03-17
 */
@Configuration
@MapperScan({"com.hawk.*.mapper"})
public class MybatisPlusConfig {
}
