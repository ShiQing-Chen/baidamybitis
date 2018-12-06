package com.chen.baida.config;

import freemarker.template.utility.HtmlEscape;
import freemarker.template.utility.XmlEscape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
@Configuration
public class FreemarkerConfig extends FreeMarkerAutoConfiguration.FreeMarkerWebConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(FreemarkerConfig.class);
    private static final String SYSTEM_TITLE="********管理系统";

    @Value("${build.version}")
    private String buildVersion;


    @Override
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        LOGGER.info("######## 配置模板引擎常量... ########");
        FreeMarkerViewResolver viewResolver = super.freeMarkerViewResolver();
        // 设置自定义属性
        Properties properties = new Properties();
        properties.setProperty("buildVersion", buildVersion);
        properties.setProperty("systemTitle", SYSTEM_TITLE);
        viewResolver.setAttributes(properties);
        return viewResolver;
    }

    @Override
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = super.freeMarkerConfigurer();

        Properties properties = new Properties();
        properties.setProperty("number_format", "#.##");
        properties.setProperty("datetime_format","yyyy-MM-dd HH:mm:ss");
        properties.setProperty("time_format","HH:mm:ss");
        properties.setProperty("boolean_format","true,false");
        properties.setProperty("whitespace_stripping","true");
        properties.setProperty("locale","utf-8");
        properties.setProperty("default_encoding","utf-8");
        properties.setProperty("template_update_delay","5");
        freeMarkerConfigurer.setFreemarkerSettings(properties);
        Map<String,Object> variables = new HashMap<>();
        variables.put("xml_escape", new XmlEscape());
        variables.put("html_escape", new HtmlEscape());
        freeMarkerConfigurer.setFreemarkerVariables(variables);
        return freeMarkerConfigurer;
    }
}