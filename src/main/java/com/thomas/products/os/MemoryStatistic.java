package com.thomas.products.os;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class MemoryStatistic {
    public static void main(String[] args) {

//        try {
//            JVMMemoryStats baseStatsImpl = new GenericStatsImpl(STATS_INTERFACE_NAME, this);
//        } catch(Exception e) {
//
//        }
        MemoryMXBean bean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = bean.getHeapMemoryUsage();
        MemoryUsage nonheapUsage = bean.getNonHeapMemoryUsage();

        // initialize all the MutableStatistic Classes
//        initializeStatistics();
        System.out.println(heapUsage);
        System.out.println(nonheapUsage);
    }
}
