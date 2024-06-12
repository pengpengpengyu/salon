package com.ruoyi.salon;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class Generator {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/salon?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
        // 使用 FastAutoGenerator 快速配置代码生成器
        FastAutoGenerator.create(jdbcUrl, "salon", "123456")
                .globalConfig(builder -> {
                    builder.author("pywang") // 设置作者
                            .outputDir("src/main/java") // 输出目录
                            .disableOpenDir(); // 不打开目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ruoyi.salon") // 设置父包名
                            .entity("domain.entity") // 设置实体类包名
                            .mapper("mapper") // 设置 Mapper 接口包名
                            .service("service") // 设置 Service 接口包名
                            .serviceImpl("service.impl") // 设置 Service 实现类包名
                            .xml("mapper.salon"); // 设置 Mapper XML 文件包名
                })
                .strategyConfig(builder -> {
                    builder.mapperBuilder()
                            .enableBaseColumnList()
                            .enableBaseResultMap();
                    builder.addTablePrefix("t_")
                            .addInclude("t_rchg_give_item_record") // 设置需要生成的表名
                            .entityBuilder()
                            .logicDeleteColumnName("del_flag")
                            .enableLombok() // 启用 Lombok
                            .enableTableFieldAnnotation() // 启用字段注解
                            .controllerBuilder()
                            .enableRestStyle(); // 启用 REST 风格

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎
                .execute(); // 执行生成
    }
}
