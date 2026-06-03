package awtDemo;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createVerticalBox();
        box1.add(new Button("1"));
        box1.add(new Button("2"));
        box2.add(new Button("3"));
        box2.add(new Button("4"));
        frame.add(box1, BorderLayout.NORTH);
        frame.add(box2);

        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
