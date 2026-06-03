package awtDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CardLayoutDemo {
    private static JButton btn1=new JButton("第一张卡片");
    private static JButton btn2=new JButton("下一张卡片");
    private static JButton btn3=new JButton("上一张卡片");
    private static JButton btn4=new JButton("第三张卡片");
    private static JButton btn5=new JButton("最后面的卡片");
    private static Panel panel1;
    private static CardLayout cardLayout=new CardLayout();

    public static void main(String[] args) {

        Frame frame = new Frame();
        panel1 = new Panel(cardLayout);
        panel1.setSize(450, 350);

        for (int i = 0; i < 10; i++) {
            JButton jButton = new JButton("Card " + i);
            panel1.add("card"+i,jButton);
        }
        frame.add(panel1, BorderLayout.CENTER);
        Panel panel2 = new Panel();
        JButton[] arr =  {btn1,btn2,btn3,btn4,btn5};

        for (JButton jButton : arr) {
            jButton.addActionListener(CardLayoutDemo::click);
        }
        panel2.add(btn1);
        panel2.add(btn2);
        panel2.add(btn3);
        panel2.add(btn4);
        panel2.add(btn5);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.pack();
        frame.setBounds(100, 100, 450, 450);
        frame.setVisible(true);
    }

    public static void click(ActionEvent e) {
        if (e.getSource() == btn1) {
            cardLayout.first(panel1);
        }else if (e.getSource() == btn2) {
            cardLayout.next(panel1);
        }else if (e.getSource() == btn3) {
            cardLayout.previous(panel1);
        }else if (e.getSource() == btn4) {
            cardLayout.show(panel1, "card2");
        }else {
            cardLayout.last(panel1);
        }
    }
}
