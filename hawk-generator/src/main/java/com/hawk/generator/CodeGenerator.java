package com.hawk.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeGenerator {


    public static void main(String[] args) {
        // 设置代码生成的位置
        String projectPath = "E:\\work\\Hawk-Fast-Work";
        // 设置父模块名称
        String parentModuleName = "com.hawk";
        // 设置子模块名称
        String moduleName = "hawk-user";
        String subPath = "/" + moduleName;
        // 设置数据库连接
        String databaseUrl = "jdbc:mysql://100.25.34.28:3316/hawk" + "?useUnicode=true&useSSL=false&characterEncoding=utf8";
        // 数据库用户名
        String username = "root";
        // 数据库密码
        String password = "Magiccc9#812";
        // 设置表名前缀，例如表为tb_UserInfo，这里设置表前缀为"tb_",生成实体类的时候会自动去除前缀，最终生成UserInfo
        String tablePrefix = "sys_";
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 最终输出目录
        gc.setOutputDir(projectPath + subPath + "/src/main/java");
        //作者
        gc.setAuthor("Hawk");
        //是否打开输出目录
        gc.setOpen(false);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        //时间类型为 Date LocalDateTime
        gc.setDateType(DateType.ONLY_DATE);
        // 设置主键类型  ASSIGN_ID为分布式全局唯一ID  AUTO:数据库自增
        gc.setIdType(IdType.AUTO);
        // gc.setIdType(IdType.ASSIGN_ID);
        // 是否覆盖已有文件
        gc.setFileOverride(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(databaseUrl);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent(parentModuleName);
        pc.setModuleName(moduleName);

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            //自定义属性注入
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("parentName", parentModuleName);
                map.put("moduleName", moduleName);
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        //指定自定义模板路径, 位置：/resources/templates/entity.java.ftl(或者是.vm)
        //注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
        templateConfig.setEntity("templates/entity.java");
        templateConfig.setController("templates/controller.java");

        templateConfig.setEntity("templates/entity.java");
        templateConfig.setMapper("templates/mapper.java");
        templateConfig.setService("templates/service.java");
        templateConfig.setServiceImpl("templates/serviceImpl.java");
        templateConfig.setController("templates/controller.java");

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);

        // 公共父类
        strategy.setSuperEntityClass("com.hawk.common.api.CommonEntity");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(tablePrefix);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
