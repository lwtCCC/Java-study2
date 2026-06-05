package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MessageDialogTest {

    JFrame jFrame =  new JFrame("测试消息对话框");

    JTextArea jTextArea = new JTextArea(6,16);

    JButton jbt = new JButton(new AbstractAction("弹出消息对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(jFrame,"hello,world","消息对话框",JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(jFrame,"hello,world","消息对话框",JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(jFrame,"hello,world","消息对话框",JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(jFrame,"hello,world","消息对话框",JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(jFrame,"hello,world","消息对话框",JOptionPane.PLAIN_MESSAGE);
        }
    });

    private void init(){

        jFrame.add(jTextArea);

        jFrame.add(jbt, BorderLayout.SOUTH);

        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new MessageDialogTest().init();

    }
}
