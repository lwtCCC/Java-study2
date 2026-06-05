package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JToolBarDemo {

    JFrame jFrame = new JFrame();
    JToolBar jToolBar = new JToolBar();

    JTextArea jTextArea = new JTextArea(4,6);

    Action one = new AbstractAction("one") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextArea.append("1\n");
        }
    };

    Action two = new AbstractAction("two") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextArea.append("2\n");
        }
    };

    Action three = new AbstractAction("three") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextArea.append("3\n");
        }
    };


    public static void main(String[] args) {
        new JToolBarDemo().init();
    }

    private void init() {

        jToolBar.setFloatable(true);

        jToolBar.add(one);
        jToolBar.add(two);
        jToolBar.add(three);

        jFrame.add(jToolBar,BorderLayout.NORTH);

        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jFrame.add(jScrollPane);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
