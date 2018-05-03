package com.thomas.products.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class LongEventHandler implements EventHandler<LongEvent>
{
    private Disruptor<LongEvent> disruptor;

    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
        System.out.println("Event: " + event + " next disruptor: " + disruptor);
        publishEvent2(event, disruptor);
    }

    public void setDisruptor(Disruptor<LongEvent> disruptor) {
        this.disruptor = disruptor;
    }


    static class Translator implements EventTranslatorOneArg<LongEvent, long[]> {
        @Override
        public void translateTo(LongEvent event, long sequence, long[] data) {
            event.set(data);
        }
    }

    public static Translator TRANSLATOR = new Translator();

    public static void publishEvent2(LongEvent event, Disruptor<LongEvent> disruptor) {
        // 发布事件；
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long[] value = event.getValue();
        value[0] = value[0] +1;
        value[1] = value[1] +1;
        ringBuffer.publishEvent(TRANSLATOR, value);
    }
}