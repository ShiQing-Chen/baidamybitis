package com.chen.baida.util;

import com.chen.baida.exception.ChenRuntimeException;
import com.chen.baida.jsckson2.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**Http工具
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */

public class HttpClientUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);
    private static PoolingHttpClientConnectionManager cm = null;
    private static final String ERROR_MESSAGE = "网络请求异常: ";

    private HttpClientUtils() {
        //empty
    }

    public static CloseableHttpClient getHttpClient() {
        try {
            if(cm==null){
                TrustStrategy trustStrategy = new TrustSelfSignedStrategy();

                SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(trustStrategy).build();
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                        sslContext, NoopHostnameVerifier.INSTANCE);

                ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();

                Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                        .<ConnectionSocketFactory> create().register("http",plainSF).register("https", sslsf)
                        .build();

                cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
                // 将最大连接数增加到200
                cm.setMaxTotal(200);
                // 将每个路由基础的连接增加到20
                cm.setDefaultMaxPerRoute(20);
                //将目标主机的最大连接数增加到50
                cm.setValidateAfterInactivity(60000);
            }

            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .build();

            return HttpClients.custom()
                    .setConnectionManager(cm).setConnectionManagerShared(true)
                    .setDefaultRequestConfig(defaultRequestConfig)
                    .build();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            throw new ChenRuntimeException(e);
        }
    }

    public static void release() {
        LOGGER.info("######## 正在释放连接资源... ########");
        if (cm != null) {
            cm.shutdown();
        }
    }

    /**
     * 简单的网络请求
     * @param urlString Get请求地址
     * @return 返回内容
     */
    public static String doGetRequest(String urlString){
        try(CloseableHttpClient client = HttpClientUtils.getHttpClient()){
            HttpGet get = new HttpGet(urlString);
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, Consts.UTF_8);
            }else{
                LOGGER.error("Get 网络请求状态异常 - {}: {}",response.getStatusLine().getStatusCode(), urlString);
                return null;
            }
        } catch (IOException e) {
            LOGGER.error(ERROR_MESSAGE+urlString,e);
        }
        return null;
    }

    /**
     * 简单的网络请求
     * @param url Get请求地址
     * @param params 请求参数
     * @return 返回内容
     */
    public static String doPostParams(String url, Map<String,String> params){
        try(CloseableHttpClient client = HttpClientUtils.getHttpClient()){
            HttpPost httpPost = new HttpPost(url);
            if(!CollectionUtils.isEmpty(params)){
                List<NameValuePair> nvps = new ArrayList<>();
                for (Map.Entry<String,String> e : params.entrySet()) {
                    nvps.add(new BasicNameValuePair(e.getKey(), e.getValue()));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            }
            HttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, Consts.UTF_8);
            }else{
                LOGGER.error("#### PostParams 网络请求状态异常 - {}: {}",response.getStatusLine().getStatusCode(), url);
                return null;
            }
        } catch (IOException e) {
            LOGGER.error(ERROR_MESSAGE+url,e);
        }
        return null;
    }

    /**
     * 简单的网络请求
     * @param url Get请求地址
     * @param params 请求参数
     * @return 返回内容
     */
    public static String doPostJson(String url,Map<String,String> params){
        try(CloseableHttpClient client = HttpClientUtils.getHttpClient()){
            HttpPost httpPost = new HttpPost(url);
            if(!CollectionUtils.isEmpty(params)){
                ObjectMapper om = ObjectMapperFactory.getSimpleMapper();
                String json = om.writeValueAsString(params);
                StringEntity entity = new StringEntity(json,"utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            HttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, Consts.UTF_8);
            }else{
                LOGGER.error("#### doPostJsonWithMap 网络请求状态异常 - {}: {}",response.getStatusLine().getStatusCode(), url);
                return null;
            }
        } catch (IOException e) {
            LOGGER.error(ERROR_MESSAGE+url,e);
        }
        return null;
    }

    /**
     * 简单的网络请求
     * @param url Get请求地址
     * @param jsonString 请求参数
     * @return 返回内容
     */
    public static String doPostJson(String url,String jsonString){
        try(CloseableHttpClient client = HttpClientUtils.getHttpClient()){
            HttpPost httpPost = new HttpPost(url);
            if(StringUtils.isNotBlank(jsonString)){
                StringEntity entity = new StringEntity(jsonString,"utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            HttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, Consts.UTF_8);
            }else{
                LOGGER.error("#### doPostJsonWithString 网络请求状态异常 - {}: {}",response.getStatusLine().getStatusCode(), url);
                return null;
            }
        } catch (IOException e) {
            LOGGER.error(ERROR_MESSAGE+url,e);
        }
        return null;
    }

}
