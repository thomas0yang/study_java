package com.thomas.products.util;

import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.HttpContext;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mazhao
 */
public class ServerHolder {

    private static ServerHolder ins = new ServerHolder();

    /** 线程池 暂且使用cpu个数做线程个数 */
    private final ExecutorService executorService = Executors
            .newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private final ConcurrentMap<String, String> statusMap = new ConcurrentHashMap<String, String>();

    private DefaultHttpClient client;

    private ServerHolder() {
    }

    public static ServerHolder getInstance() {
        return ins;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    /**
     * 创建带连接池的httpclient，线程安全<br>
     * 默认每host最大100连接，timeout时间为5秒
     * */
    public DefaultHttpClient createClientWithPool() {
        ThreadSafeClientConnManager connectionManager = new ThreadSafeClientConnManager();
        connectionManager.setDefaultMaxPerRoute(300);
        connectionManager.setMaxTotal(2048);
        client = new MyHttpClient(connectionManager);
        client.getParams().setParameter(CoreProtocolPNames.USER_AGENT,
                "Imeituan_Mobile_SRV");

        client.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT,
                10 * 1000);
        client.getParams().setIntParameter(
                CoreConnectionPNames.CONNECTION_TIMEOUT, 10 * 1000);
        return client;
    }

    public DefaultHttpClient getHttpClient() {
        if (client == null) {
            synchronized (this) {
                this.createClientWithPool();
            }
        }
        return client;
    }

    public void shutdown() {
        executorService.shutdownNow();
    }

    public void markStatus(String key, String value) {
        statusMap.put(key, value);
    }

    public String getStatus() {
        return statusMap.toString();
    }

    private static class MyHttpClient extends DefaultHttpClient {
        MyHttpClient(final ClientConnectionManager conman) {
            super(conman);
        }

        @Override
        public HttpContext createHttpContext() {
            HttpContext context = super.createHttpContext();
            context.setAttribute(ClientContext.COOKIE_STORE,
                    new BasicCookieStore());
            return context;
        }
    }

}
