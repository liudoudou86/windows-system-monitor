package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 测试类
 * windows内存监控界面
 * @author 豆儿
 * @since 2022/8/24
 */
public class MonitorFrame {

    public void init() {

        // 定义字体
        Font f1 = new Font("微软雅黑", Font.PLAIN,18);

        // 向容器添加文本CPU
        JLabel labelCpu = new JLabel();
        labelCpu.setFont(f1);
        // 向容器添加文本MEM
        JLabel labelMem = new JLabel();
        labelMem.setFont(f1);

        // 添加计时器
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // 调用读取系统参数的方法
                String monitorCpu = MonitorSystem.cpu();
                String monitorMem = MonitorSystem.mem();
                // 实时显示数据
                labelCpu.setText("CPU占用率: --->【" + monitorCpu + "%】");
                labelMem.setText("内存占用率: --->【" + monitorMem + "%】");

            }
        });
        timer.start();

        // 定义工具窗口
        JFrame frame = new JFrame("实时监控");
        // 定义窗口大小
        frame.setBounds(200,200,235,105);

        // 添加容器
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frame.setContentPane(panel);
        // 将数据打印至label
        panel.add(labelCpu);
        panel.add(labelMem);

        // 窗口可见性，放在这里是因为如果放在开头数据就不会立即显示
        frame.setVisible(true);
        // 添加关闭事件
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {

        new MonitorFrame().init();
    }

}
