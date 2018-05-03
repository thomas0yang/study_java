package com.thomas.products.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangyang32 on 16/7/19.
 */
public class Main2 {


    public static void main(String[] args) {
        //1.初始化
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        int ringBufferSize = 1024 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；

//        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,
//                ringBufferSize, executor, ProducerType.SINGLE,
//                new YieldingWaitStrategy());

//        EventHandler<LongEvent> eventHandler = new LongEventHandler();
//        disruptor.handleEventsWith(eventHandler);


        executor = Executors.newFixedThreadPool(16);
        Disruptor<LongEvent> disruptor =
                new Disruptor<LongEvent>(eventFactory, 16,
                        executor, ProducerType.SINGLE, new YieldingWaitStrategy());
        disruptor.handleExceptionsWith(new ExceptionHandler() {
            @Override
            public void handleEventException(final Throwable throwable, final long l, final Object o) {
//                throwable.printStackTrace();
                System.err.println("sdaf");
            }

            @Override
            public void handleOnStartException(final Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void handleOnShutdownException(final Throwable throwable) {
                throwable.printStackTrace();
            }
        });

        LongEventWorkerHandler[] handlers = new LongEventWorkerHandler[16];
        for (int i = 0; i < 16; ++i) {
            handlers[i] = new LongEventWorkerHandler();
        }
        disruptor.handleEventsWithWorkerPool(handlers);

        disruptor.start();


        //2.发布事件；
        publishEvent1(disruptor);

        //3.关闭
        disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
        executor.shutdown();//关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；
    }

    private static void publishEvent1(Disruptor<LongEvent> disruptor) {
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();//请求下一个事件序号；

        try {
            LongEvent event = ringBuffer.get(sequence);//获取该序号对应的事件对象；
            long data = getEventData();//获取要通过事件传递的业务数据；
            long[] dataarr = {data, data+1};
            event.set(dataarr);
        } finally{
            ringBuffer.publish(sequence);//发布事件；
        }
    }

    private static long getEventData() {
        double v = Math.random() * 100;
        return (long)v;
    }
}
