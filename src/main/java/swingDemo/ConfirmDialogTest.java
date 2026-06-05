package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfirmDialogTest {

    JFrame jFrame =  new JFrame("确认对话框");

    JTextArea jTextArea = new JTextArea(6,16);

    JButton jbt = new JButton(new AbstractAction("确认对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = JOptionPane.showConfirmDialog(jFrame, "确认？", "确认对话框", JOptionPane.YES_NO_OPTION);
            switch (i) {
                case JOptionPane.YES_OPTION:
                    jTextArea.append("ok");
                    break;
                case JOptionPane.NO_OPTION:
                    jTextArea.append("no");
                    break;
                default:
                    break;
            }
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
        new ConfirmDialogTest().init();

    }
}
