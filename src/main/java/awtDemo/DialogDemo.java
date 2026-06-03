package awtDemo;

import javax.swing.*;
import java.awt.*;

public class DialogDemo {
    public static void main(String[] args) {

        Frame frame = new Frame();
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");

        Dialog dialog = new Dialog(frame,"对话框1，非模式",false);
        dialog.setBounds(100,100,300,200);
        Dialog dialog2 = new Dialog(frame,"对话框2，模式",true);
        dialog2.setBounds(100,100,300,200);

        btn1.addActionListener( e ->dialog.setVisible(true));
        btn2.addActionListener( e ->dialog2.setVisible(true));

        frame.add(btn1,BorderLayout.NORTH);
        frame.add(btn2);
        frame.pack();
        frame.setVisible(true);
    }
}
