package awtDemo;

import javax.swing.*;
import java.awt.*;

public class DialogDemo2 {
    public static void main(String[] args) {

        Frame frame = new Frame();
        JButton btn1 = new JButton("1");

        Dialog dialog = new Dialog(frame,"对话框1，非模式",false);
        dialog.setBounds(100,100,300,200);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(new TextField(20));
        verticalBox.add(new JButton("ok"));
        dialog.add(verticalBox);

        btn1.addActionListener( e ->dialog.setVisible(true));

        frame.add(btn1);
        frame.pack();
        frame.setVisible(true);
    }
}
