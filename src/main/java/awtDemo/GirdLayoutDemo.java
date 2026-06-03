package awtDemo;

import java.awt.*;

public class GirdLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel1 = new Panel();
        panel1.add(new TextField(50));
        frame.add(panel1, BorderLayout.NORTH);
        Panel panel2 = new Panel(new GridLayout(4, 5, 30, 10));
        for (int i = 0; i < 20; i++) {
            panel2.add(new Button(""+i));
        }
        frame.add(panel2, BorderLayout.CENTER);


        frame.pack();
        frame.setSize(600, 300);
        frame.setVisible(true);
    }
}
