package awtDemo;

import java.awt.*;
import java.awt.event.*;

public class ListenerDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
