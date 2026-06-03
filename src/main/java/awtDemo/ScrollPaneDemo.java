package awtDemo;

import javax.swing.*;
import java.awt.*;

public class ScrollPaneDemo {
    public static void main(String[] args) {

        Frame frame = new Frame("演示滚轮");

        ScrollPane scrollPane = new ScrollPane(1);

        scrollPane.add(new TextField("测试文本"));
        scrollPane.add( new JButton("测试按钮"));
        frame.add(scrollPane);

        frame.setBounds(100, 100, 300, 200);
        frame.setVisible(true);
    }
}
