package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OptionDialogTest {

    JFrame jFrame =  new JFrame("选项对话框");

    JTextArea jTextArea = new JTextArea(6,16);

    JButton jbt = new JButton(new AbstractAction("选项对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = JOptionPane.showOptionDialog(jFrame, "请做出你的选择", "选项对话框",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, new String[]{"大杯", "中杯", "小杯"}, 1);
            switch (i) {
                case 0:
                    jTextArea.append("大杯");
                    break;
                case 1:
                    jTextArea.append("中杯");
                    break;
                case 2:
                    jTextArea.append("小杯");
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
        new OptionDialogTest().init();

    }
}
