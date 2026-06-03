package awtDemo;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo3 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createVerticalBox();
        box1.add(new Button("1"));
        box1.add(Box.createHorizontalGlue());
        box1.add(new Button("2"));
        box1.add(Box.createHorizontalStrut(10));
        box1.add(new Button("3"));

        box2.add(new Button("4"));
        box2.add(Box.createVerticalGlue());
        box2.add(new Button("5"));
        box2.add(Box.createVerticalStrut(10));
        box2.add(new Button("6"));
        frame.add(box1, BorderLayout.NORTH);
        frame.add(box2);

        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
