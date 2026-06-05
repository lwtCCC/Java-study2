package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JColorChooserDemo {
    JFrame jFrame =  new JFrame("颜色选择对话框");
    JTextArea jTextArea = new JTextArea(6,16);
    JToolBar jToolBar = new JToolBar();

    Action action = new AbstractAction("颜色选择") {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = JColorChooser.showDialog(jFrame, "", null);

            jTextArea.setBackground(color);
        }
    };

    private void init(){
        jToolBar.add(action);

        jFrame.add(jToolBar,BorderLayout.NORTH);

        jFrame.add(jTextArea);

        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new  JColorChooserDemo().init();
    }
}
