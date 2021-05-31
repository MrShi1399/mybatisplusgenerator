package com.ujiuye.mybatisplusgenerator.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

/**
 * @author 13320
 */
public class MybatisPlusGeneratorConfig {
    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg=new AutoGenerator();
        //全局配置
        GlobalConfig gc=new GlobalConfig();
        String property = System.getProperty("user.dir");
        gc.setOutputDir(property+"/src/main/java");
        //设置作者
        gc.setAuthor("Shi");
        //生成后是否打开资源管理器
        gc.setOpen(false);
        //重新生成文件时是否覆盖
        gc.setFileOverride(false);
        gc.setServiceName("%Service");
        mpg.setGlobalConfig(gc);
        //数据源配置
        DataSourceConfig dsc=new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://10.10.33.170:3306/mybatisplus0125?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("0000");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        //包配置
        PackageConfig pc=new PackageConfig();
        pc.setModuleName(null);
        pc.setParent("com.ujiuye.ssm");
        pc.setController("controller");
        pc.setEntity("pojo");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);
        //策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
        //对哪张表生成代码
        strategyConfig.setInclude("tb_employee");
        //数据库表名映射到实体的策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //生成实体时去掉表前缀
        strategyConfig.setTablePrefix(pc.getModuleName()+"_");
        //数据表字段映射到实体的命名策略
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //lombok 模型
        strategyConfig.setEntityLombokModel(true);
        //restful 风格
        strategyConfig.setRestControllerStyle(true);
        //url中的驼峰转连字符
        strategyConfig.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategyConfig);
        //执行
        mpg.execute();
    }
}
