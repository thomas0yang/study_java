package com.thomas.products.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangyang32 on 16/7/19.
 */
public class Main {


    public static void main(String[] args) {
        //1.初始化
        int num = 4;
        LongEventHandler eventHandler = new LongEventHandler();
        LongEventHandler eventHandler2 = new LongEventHandler();

        ExecutorService executor = Executors.newFixedThreadPool(num);
        ExecutorService executor2 = Executors.newFixedThreadPool(num);
        Disruptor<LongEvent> disruptor = init(executor,eventHandler,  num);
        Disruptor<LongEvent> disruptor2 = init(executor2,eventHandler2,  num);

        eventHandler.setDisruptor(disruptor2);
        eventHandler2.setDisruptor(disruptor);


        //2.发布事件；
//        publishEvent1(disruptor);
        publishEvent2(disruptor);


        //3.关闭
//        disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
//        executor.shutdown();//关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；
    }

    private static Disruptor<LongEvent> init(ExecutorService executor,EventHandler<LongEvent> eventHandler, int num) {
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        int ringBufferSize = num; // RingBuffer 大小，必须是 2 的 N 次方；

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,
                ringBufferSize, executor, ProducerType.SINGLE,
                new YieldingWaitStrategy());

        disruptor.handleExceptionsWith(new FatalExceptionHandler());
        disruptor.handleEventsWith(eventHandler);

        disruptor.start();
        return disruptor;
    }

    private static void publishEvent1(Disruptor<LongEvent> disruptor) {
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();//请求下一个事件序号；

        for (int i = 0; i < 10; i++) {
            try {
                LongEvent event = ringBuffer.get(sequence);//获取该序号对应的事件对象；
                long data = getEventData();//获取要通过事件传递的业务数据；
                long[] dataarr = {data, data+1};
                event.set(dataarr);
            } finally{
                ringBuffer.publish(sequence);//发布事件；
            }
        }

    }


    static class Translator implements EventTranslatorOneArg<LongEvent, long[]> {
        @Override
        public void translateTo(LongEvent event, long sequence, long[] data) {
            event.set(data);
        }
    }

    public static Translator TRANSLATOR = new Translator();

    public static void publishEvent2(Disruptor<LongEvent> disruptor) {
        // 发布事件；
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long data = getEventData();//获取要通过事件传递的业务数据；
        long[] dataarr = {data, data+1};
        ringBuffer.publishEvent(TRANSLATOR, dataarr);
    }

    private static long getEventData() {
        double v = Math.random() * 100;
        return (long)v;
    }
}
