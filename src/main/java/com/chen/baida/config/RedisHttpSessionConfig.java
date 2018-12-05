package com.chen.baida.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import java.util.Map;

/**
 * session 有效期7天
 * @author HanHongmin 2018-01-25
 * @since 0.0.1
 */
@Configuration
@EnableRedisHttpSession(redisNamespace = "qrcollection",maxInactiveIntervalInSeconds = 604800)
public class RedisHttpSessionConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisHttpSessionConfig.class);

    private final RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public RedisHttpSessionConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Bean
    public GenericJackson2JsonRedisSerializer springSessionDefaultRedisSerializer(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        return new GenericJackson2JsonRedisSerializer(mapper);
    }

    @Bean
    public RedisTemplate<String, Map<String,Object>> menusRedisTemplate() {
        RedisTemplate<String, Map<String,Object>> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(springSessionDefaultRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

    @Bean
    public CookieSerializer devCookieSerializer(){
        LOGGER.info("######## 配置共享登录规则... ########");
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("sid");
        serializer.setCookiePath("/");
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");

        serializer.setCookieMaxAge(3600*24);
        return serializer;
    }

}
