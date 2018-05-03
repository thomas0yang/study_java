package com.thomas.products.os;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;

public class OsMemoryStatistic {
    public static void main(String[] args) {

        OperatingSystemMXBean osmxb = ManagementFactory.getOperatingSystemMXBean();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println(osmxb);
        System.out.println(memoryMXBean);
    }
}
