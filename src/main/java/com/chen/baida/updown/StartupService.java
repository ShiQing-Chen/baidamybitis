package com.chen.baida.updown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * @author HanHongmin 2018-01-24
 * @since 0.0.1
 */
public class StartupService implements InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(StartupService.class);

    @Autowired
    private Environment environment;

    @Value("${application.name}")
    private String applicationName;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.timestamp}")
    private String buildTimestamp;

    @Value("${server.port}")
    private Integer serverPort;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("######## 应用程序正在启动... ########");
        LOGGER.info("######## 应用程序正在启动... ########");
        LOGGER.info("######## 应用程序正在启动... ########");
        LOGGER.info("######## 运行端口: {} ########", serverPort);
        LOGGER.info("######## 应用名称: {} ########", applicationName);
        LOGGER.info("######## 程序版本: {} ########", buildVersion);
        LOGGER.info("######## 编译时间: {} ########", buildTimestamp);
        LOGGER.info("######## 使用配置文件 {} ########", Arrays.asList(environment.getActiveProfiles()));
    }
}
