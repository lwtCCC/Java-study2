package awtDemo;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        frame.add(new Button("按钮1"));
        frame.add(new Button("2"));

        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
