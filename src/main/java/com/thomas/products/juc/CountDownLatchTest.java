package com.thomas.products.juc;

public class CountDownLatchTest {

    private final java.util.concurrent.CountDownLatch keepAliveLatch = new java.util.concurrent.CountDownLatch(1);
    private final Thread keepAliveThread;

    /** creates a new instance */
    CountDownLatchTest() {
        keepAliveThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    keepAliveLatch.await();
                } catch (InterruptedException e) {
                    // bail out
                }
            }
        }, "elasticsearch[keepAlive/test]");
        keepAliveThread.setDaemon(false);
        // keep this thread alive (non daemon thread) until we shutdown
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                keepAliveLatch.countDown();
            }
        });
    }

    void start(){
        keepAliveThread.start();
    }

    public static void main(String[] args) {
        CountDownLatchTest test = new CountDownLatchTest();
        test.start();
        System.out.println("i am alive");
    }
}
