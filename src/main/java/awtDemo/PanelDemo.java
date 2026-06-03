package awtDemo;

import java.awt.*;
import java.io.UnsupportedEncodingException;

public class PanelDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Frame frame = new Frame("容器演示");

        Panel panel = new Panel();
        panel.add(new TextField("测试文本"));
        panel.add(new Button("测试按钮"));

        frame.add(panel);

        frame.setLocation(100,200);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
