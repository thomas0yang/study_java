/*
 * Copyright (c) 2010-2011 meituan.com
 * All rights reserved.
 * 
 */
package com.thomas.products.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yangayng32
 * @version 1.0
 * @created 2013-1-30
 */
public class HttpClientUtils {
    public static final long DEFAULT_CONNECTION_MANAGER_TIME_OUT = 8000L; // 默认的连接池等待时间
    public static final int DEFAULT_CONNECTION_TIME_OUT = 5000; // 默认的连接等待时间
    public static final int DEFAULT_SOCKET_TIME_OUT = 10000; // 默认的数据等待时间

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private static HttpClient httpclient = ServerHolder.getInstance()
            .getHttpClient();

    public static String get(String url) {
        return get(url, 0);
    }

    /**
     * 同步deal list等缓存时，设置长一点的timeout
     *
     * @param url
     * @return
     */
    public static String getWithLongTimeOut(String url) {
        return get(url, 30 * 1000);
    }

    private static String get(String url, int timeout) {
        HttpGet httpGet = new HttpGet(url);
        if (timeout > 0) {
            httpGet.getParams().setIntParameter(
                    CoreConnectionPNames.SO_TIMEOUT, timeout);
        }
        try {
            String content = httpclient.execute(httpGet,
                    new BasicResponseHandler());
            return content;
        } catch (Exception e) {
            logger.error(
                    "HttpClientUtils.get() Error:" + url, e);
        }
        return null;
    }

    public static String post(String url, Map<String, String> postData) {
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        if (postData != null) {
            for (String key : postData.keySet()) {
                params.add(new BasicNameValuePair(key, postData.get(key)));
            }
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            String content = httpclient.execute(httpPost,
                    new BasicResponseHandler());
            return content;
        } catch (Exception e) {
            logger.error(
                    "HttpClientUtils.post() Error:" + url + "," + postData, e);
        }
        return null;
    }

    public static void main(String[] args) {
        String withBA = HttpClientUtils.get("https://www.ele.me/place/wx4gd6w14jz?latitude=40.00417&longitude=116.4744");
        System.out.println(withBA);
    }

}
