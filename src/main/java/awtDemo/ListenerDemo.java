package awtDemo;

import java.awt.*;
import java.awt.event.*;

public class ListenerDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Choice choice = new Choice();
        choice.add("a");
        choice.add("b");
        choice.add("c");

        TextField textField = new TextField(20);

        //绑定事件
        textField.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                System.out.println(textField.getText());
            }
        });

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getItem());
            }
        });


        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                System.out.println(e.getChild());
            }

            @Override
            public void componentRemoved(ContainerEvent e) {

            }
        });

        frame.add(textField);
        frame.add(choice,BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
    }
}
