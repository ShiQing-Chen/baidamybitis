package com.chen.baida.util;

import com.chen.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 内部服务器间通讯认证
 * @author HanHongmin 2017-05-04
 * @since 0.0.1
 */
public class InternalAccessTokenUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(InternalAccessTokenUtils.class);
    /**
     * 5分钟内有效
     */
    private static final long VALID_TIME = 1000*60*5L;
    private static final String MESSAGE_TIMEOUT = "时间戳已过期";
    private static final String MESSAGE_NOT_MATCH = "Token 不匹配";

    private static final String INTERNAL_APP_ID = "ECourse";
    private static final String INTERNAL_APP_SECRET = "N738g81b";


    /**
     * 生成访问token
     * @param appId 应用id
     * @param appSecret 应用密钥
     * @param timestamp 时间戳 毫秒
     * @return 加密串
     */
    private static String generateAccessToken(String appId,String appSecret,long timestamp){
        String toEncode = appId + "_" + appSecret + "_" + timestamp;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        return encoder.encode(toEncode);
    }

    /**
     * 校验Token, 时间戳超过 {#VALID_TIME} 视为无效
     * @param appId 应用id （调用接口时传递的）
     * @param appSecret 应用密钥 （从应用列表查询的,调用接口不需要传递）
     * @param timestamp 时间戳 （调用接口传递的）
     * @param tokenForCheck （调用接口传递的）
     * @return 是否匹配
     */
    private static MessageVo matches(String appId, String appSecret, long timestamp, String tokenForCheck){
        long now = System.currentTimeMillis();
        if(now - timestamp > VALID_TIME){
            return new MessageVo(false, MESSAGE_TIMEOUT);
        }
        String toEncode = appId + "_" + appSecret + "_" + timestamp;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        if(!encoder.matches(toEncode,tokenForCheck)){
            return new MessageVo(false, MESSAGE_NOT_MATCH);
        }
        return new MessageVo(true);
    }

    /**
     * 该方法只提供给内部接口使用
     * @return 生成内部使用的Token
     */
    public static String getInternalToken(long timestamp){
        return generateAccessToken(INTERNAL_APP_ID,INTERNAL_APP_SECRET,timestamp);
    }

    /**
     * 该方法只提供给内部接口使用
     * @return 石佛验证成功
     */
    public static MessageVo matchesInternal(String token, long timestamp){
        return matches(INTERNAL_APP_ID,INTERNAL_APP_SECRET,timestamp,token);
    }

    /**
     * 该方法只提供给内部接口使用
     * @return 生成内部使用的Token
     */
    public static String getInternalUserToken(long timestamp, String userId){
        return generateAccessToken(INTERNAL_APP_ID, userId, timestamp);
    }

    /**
     * 该方法只提供给内部接口使用
     * @return 石佛验证成功
     */
    public static MessageVo matchesUserInternal(String token, long timestamp, String userId){
        return matches(INTERNAL_APP_ID, userId, timestamp,token);
    }

    /**
     * 简单测试
     */
    public static void main(String[] args){
        long time = System.currentTimeMillis();
        String token = generateAccessToken("a","b",time);
        LOGGER.debug("token : {}", token);
        MessageVo message = matches("a","b",time,token);
        LOGGER.debug("校验结果: {}",message);
    }


}
