package com.hawk.common.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.hawk.common.api.CommonEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CodeGenerator {

    public static void main(String[] args) {
        // 设置代码生成的位置
        String projectPath = "E:/work/Hawk-Fast-Work";
        // 设置父模块名称
        String parentModuleName = "com.hawk";
        String subPath = "/hawk-user";
        // 设置子模块名称
        String moduleName = "user";
        // 设置表名前缀，例如表为tb_UserInfo，这里设置表前缀为"tb_",生成实体类的时候会自动去除前缀，最终生成UserInfo
        String tablePrefix = "sys_";
        // 代码生成器
        FastAutoGenerator.create("jdbc:mysql://100.25.34.28:3306/hawk?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "Magiccc9#812")
                .globalConfig(builder -> {
                    builder.author("Hawk")
                            .enableSwagger()
                            .disableOpenDir()
                            .outputDir(projectPath + subPath + "/src/main/java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.hawk").moduleName(moduleName)
                            .pathInfo(Collections.singletonMap(OutputFile.xml,projectPath + subPath + "/src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user")
                            .addTablePrefix(tablePrefix)
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .addIgnoreColumns("create_by", "create_time", "update_by", "update_time")
                            .superClass(CommonEntity.class);
                })
                .templateConfig(builder -> {
                    builder.controller("templates/controller.java")
                            .service("templates/service.java")
                            .serviceImpl("templates/serviceImpl.java")
                            .mapper("templates/mapper.java")
                            .entity("templates/entity.java");
                })
                .injectionConfig(builder -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("parentName", parentModuleName);
                    map.put("moduleName", moduleName);
                    builder.customMap(map);
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
