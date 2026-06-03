package awtDemo;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {

        Frame frame = new Frame("borderLayout测试");

        BorderLayout borderLayout = new BorderLayout(30,10);

        frame.setLayout(borderLayout);
        frame.add(new JButton("北侧"), BorderLayout.NORTH);
        frame.add(new JButton("南侧"), BorderLayout.SOUTH);
        frame.add(new JButton("西侧"), BorderLayout.WEST);
        frame.add(new JButton("东侧"), BorderLayout.EAST);
        frame.add(new JButton("中间"), BorderLayout.CENTER);
        frame.pack();

        frame.setBounds(100, 100, 600, 300);
        frame.setVisible(true);
    }
}
