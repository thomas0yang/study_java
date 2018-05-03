package com.thomas.products.disruptor;

import java.util.Arrays;

public class LongEvent
{
    private long[] value;

    public void set(long[] value)
    {
        this.value = value;
    }

    public long[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}