package com.monitor;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * Description 读取系统参数
 * @author Tesla Liu
 * Date 2022/8/24 17:04
 **/
public class MonitorSystem {

    private static final OperatingSystemMXBean OS_MXB = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    public static int cpu() {

        // 获取CPU
        double cpuLoad = OS_MXB.getSystemCpuLoad();
        int percentCpuLoad = (int) (cpuLoad * 100);
        System.out.println("CPU占用率: " + percentCpuLoad + "%");
        return percentCpuLoad;

    }

    public static int mem() {

        //获取内存
        double totalVirtualMemory = OS_MXB.getTotalPhysicalMemorySize();
        double freePhysicalMemorySize = OS_MXB.getFreePhysicalMemorySize();
        double value = freePhysicalMemorySize/totalVirtualMemory;
        int percentMemoryLoad = (int) ((1-value)*100);
        System.out.println("内存占用率: " + percentMemoryLoad + "%");
        return percentMemoryLoad;

    }

}
