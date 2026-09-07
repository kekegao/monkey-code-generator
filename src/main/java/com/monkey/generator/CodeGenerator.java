package com.monkey.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

public class CodeGenerator {

    public static void main(String[] args) {

        // 当前项目根目录
        String projectPath = System.getProperty("user.dir")+"/out/";

        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/ams_db" +
                                "?useUnicode=true" +
                                "&characterEncoding=UTF-8" +
                                "&serverTimezone=Asia/Shanghai",

                        "root",
                        "123456"
                )

                // =========================
                // 全局配置
                // =========================
                .globalConfig(builder -> {
                    builder
                            .author("gkk")
                            .disableOpenDir()
                            .commentDate("yyyy-MM-dd")
                            .outputDir(projectPath );
                })

                // =========================
                // 包配置
                // =========================
                .packageConfig(builder -> {

                    builder
                            .parent("com.monkey.ams")

                            .entity("entity")

                            .mapper("mapper")

                            .service("service")

                            .serviceImpl("service.impl")

                            .controller("controller")

                            .xml("mapper")

                            .pathInfo(Collections.singletonMap(
                                    OutputFile.xml,
                                    projectPath+"/mapper"
                            ));
                })

                // =========================
                // 策略配置
                // =========================
                .strategyConfig(builder -> {

                    builder

                            // 指定表
                            .addInclude(
                                    "tf_b_user"
                            )

                            // 去掉表前缀
                            .addTablePrefix("tf_b_")

                            // =================
                            // Entity
                            // =================
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .enableChainModel()
                            .fileOverride() // ✅ 启用文件覆盖（关键配置）

                            // =================
                            // Controller
                            // =================
                            .controllerBuilder()
                            .enableRestStyle()

                            // =================
                            // Service
                            // =================
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .fileOverride() // ✅ 启用文件覆盖（关键配置）
                            // =================
                            // Mapper
                            // =================
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .fileOverride() // ✅ 启用文件覆盖（关键配置）
                            .enableBaseColumnList();
                })

                // =========================
                // 模板引擎
                // =========================
                .templateEngine(
                        new FreemarkerTemplateEngine()
                )

                // =========================
                // 执行
                // =========================
                .execute();
    }
}