package awtDemo;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo2 {
    public static void main(String[] args) {

        Frame frame = new Frame("borderLayout测试");

        BorderLayout borderLayout = new BorderLayout(30,10);

        frame.setLayout(borderLayout);
        frame.add(new JButton("北侧"), BorderLayout.NORTH);
        frame.add(new JButton("南侧"), BorderLayout.SOUTH);
        /*frame.add(new JButton("西侧"), BorderLayout.WEST);
        frame.add(new JButton("东侧"), BorderLayout.EAST);*/
        frame.add(new JButton("中间"), BorderLayout.CENTER);
        Panel panel = new Panel();
        panel.add(new JButton("测试按钮"));
        panel.add(new TextField("测试文本"));
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();

        frame.setBounds(100, 100, 600, 300);
        frame.setVisible(true);
    }
}
