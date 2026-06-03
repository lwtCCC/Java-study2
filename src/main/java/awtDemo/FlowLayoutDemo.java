package awtDemo;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("测试流布局");

        FlowLayout flowLayout = new FlowLayout(0,20,20);
        frame.setLayout(flowLayout);

        for (int i = 0; i < 100; i++) {
            JButton jButton = new JButton("按钮" + i);
            frame.add(jButton);
        }

        frame.pack();
        frame.setBounds(100, 100, 300, 200);
        frame.setVisible(true);
    }
}
