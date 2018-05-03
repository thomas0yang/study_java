/*
 * Copyright 2013-2018 Lilinfeng.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.thomas.products.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author Administrator
 * @version 1.0
 * @date 2014年2月16日
 */
public class MultiplexerTimeServer2 implements Runnable {

    private static final int BUF_SIZE = 1024;
    private static final int TIMEOUT = 3000;

    private Selector selector;

    private ServerSocketChannel servChannel;


    /**
     * 初始化多路复用器、绑定监听端口
     *
     * @param port
     */
    public MultiplexerTimeServer2(int port) {
        try {
            selector = Selector.open(); //多路复用器
            servChannel = ServerSocketChannel.open(); //server通道,通道是双向的
            servChannel.configureBlocking(false);//设置为非阻塞
            servChannel.socket().bind(new InetSocketAddress(port), 1024); //绑定端口
            servChannel.register(selector, SelectionKey.OP_ACCEPT); //注册到selector,监听ACCEPT事件
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
    }

    public void handleRead(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer) key.attachment();
        long bytesRead = sc.read(buf);

        StringBuilder body = new StringBuilder();
        while (bytesRead > 0) {
            buf.flip();
            while (buf.hasRemaining()) {
                body.append((char) buf.get());
            }
            buf.clear();
            bytesRead = sc.read(buf);
        }
        System.out.println(body.toString());
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body.toString()) ?
                new java.util.Date(System.currentTimeMillis()).toString()
                : "BAD ORDER";
        response(sc, currentTime);
        if (bytesRead == -1) {
            sc.close();
        }
    }

    public void handleWrite(SelectionKey key) throws IOException {
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while (buf.hasRemaining()) {
            sc.write(buf);
        }
        buf.compact();
    }


    @Override
    public void run() {
        try {
            while (true) {
                if (selector.select(TIMEOUT) == 0) {
                    System.out.println("==");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    if (key.isAcceptable()) {
                        handleAccept(key);
                    } else if (key.isReadable()) {
                        handleRead(key);
                    } else if (key.isWritable() && key.isValid()) {
                        handleWrite(key);
                    } else if (key.isConnectable()) {
                        System.out.println("isConnectable = true");
                    }
                    iter.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (selector != null) {
                    selector.close();
                }
                if (servChannel != null) {
                    servChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void response(SocketChannel channel, String response)
            throws IOException {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
