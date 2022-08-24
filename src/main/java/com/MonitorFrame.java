package com;

import javax.swing.*;
import java.awt.*;

/**
 * 测试类
 * windows内存监控页面
 * @author 豆儿
 * @since 2022/8/24
 */
public class MonitorFrame {

    public void init() {
        // 定义窗口
        JFrame frame = new JFrame("CPU内存监控");
        // 窗口大小
        frame.setSize(300,300);
        // 窗口可见性
        frame.setVisible(true);
        // 添加关闭事件
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加容器
        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        // 定义字体
        Font f1 = new Font("微软雅黑", Font.PLAIN,12);

        // 调用读取系统参数的方法
        String monitorCpu = MonitorSystem.cpu();
        String monitorMem = MonitorSystem.mem();

        // 向容器添加文本
        JLabel labelCpu = new JLabel();
        Dimension cpuSize = labelCpu.getPreferredSize();
        labelCpu.setFont(f1);
        labelCpu.setText("CPU占用率: " + monitorCpu + "%");
        labelCpu.setBounds(30,30,cpuSize.width,cpuSize.height);
        panel.add(labelCpu);

        // 向容器添加文本
        JLabel labelMem = new JLabel();
        Dimension memSize = labelMem.getPreferredSize();
        labelMem.setFont(f1);
        labelMem.setText("内存占用率: " + monitorMem + "%");
        labelMem.setBounds(30,90,memSize.width,memSize.height);
        panel.add(labelMem);

    }
    public static void main(String[] args) {

        new MonitorFrame().init();
    }

}
