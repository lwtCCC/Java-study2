package awtDemo;

import javax.swing.*;
import java.awt.*;

public class SimpleDraw {

    static Button btn1 = new Button("React");//绘制矩形
    static Button btn2 = new Button("Oval");//绘制椭圆

    private static String temp = "";

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            if (temp.equals("React")) {
                g.setColor(Color.RED);
                g.drawRect(0, 0, 100, 100);
            }else if (temp.equals("Oval")) {
                g.setColor(Color.BLUE);
                g.drawOval(100, 100, 100, 100);
            }
        }
    }

    MyCanvas myCanvas = new MyCanvas();


    public static void main(String[] args) {
        new SimpleDraw().init();
    }

    private void init() {
        Frame frame = new Frame();
        btn1.addActionListener(e -> {
           temp = "React";
           myCanvas.repaint();
        });
        btn2.addActionListener(e -> {
            temp = "Oval";
            myCanvas.repaint();
        });
        Box box = Box.createHorizontalBox();
        box.add(btn1);
        box.add(btn2);
        myCanvas.setPreferredSize(new Dimension(500, 500));
        frame.add(myCanvas);
        frame.add(box,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
