package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InputDialogTest {

    JFrame jFrame =  new JFrame("输入对话框");

    JTextArea jTextArea = new JTextArea(6,16);

    JButton jbt = new JButton(new AbstractAction("输入对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = JOptionPane.showInputDialog(jFrame, "请填写测试信息","初始化的默认字段",JOptionPane.INFORMATION_MESSAGE);
            jTextArea.setText(s);
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
        new InputDialogTest().init();

    }
}
