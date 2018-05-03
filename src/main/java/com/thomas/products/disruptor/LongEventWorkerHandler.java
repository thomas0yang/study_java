package com.thomas.products.disruptor;

import com.lmax.disruptor.WorkHandler;

public class LongEventWorkerHandler implements WorkHandler<LongEvent>
{
//    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
//    {
//        throw new RuntimeException("error");
////        System.out.println("Event: " + event);
//    }

    @Override
    public void onEvent(LongEvent event) throws Exception {
        System.out.println("Event: " + event);
    }
}