package awtDemo;

import java.awt.*;

public class WindowDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("窗口创建");
        frame.setLocation(100,200);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
