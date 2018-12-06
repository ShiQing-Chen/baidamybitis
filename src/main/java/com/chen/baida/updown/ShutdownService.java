package com.chen.baida.updown;

import com.chen.baida.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

/**
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
public class ShutdownService implements DisposableBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShutdownService.class);
    @Override
    public void destroy() throws Exception {
        LOGGER.info("######## 应用程序正在关闭... ########");
        LOGGER.info("######## 应用程序正在关闭... ########");
        LOGGER.info("######## 应用程序正在关闭... ########");
        HttpClientUtils.release();
    }
}
