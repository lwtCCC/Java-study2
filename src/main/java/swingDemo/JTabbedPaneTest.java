package swingDemo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabbedPaneTest {

    JFrame jFrame = new JFrame("JTabbedPane Test");

    JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

    private void init() {

        jTabbedPane.addTab("标签1",new JList<String>(new String[]{"选项1","选项2","选项3"}));
        jTabbedPane.addTab("标签2",new JList<String>(new String[]{"选项4","选项5","选项6"}));
        jTabbedPane.addTab("标签3",new JList<String>(new String[]{"选项7","选项8","选项9"}));

        jTabbedPane.setEnabledAt(0,false);
        jTabbedPane.setSelectedIndex(1);

        jTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = jTabbedPane.getSelectedIndex();
                JOptionPane.showMessageDialog(jFrame,"该用户点击了"+selectedIndex+"标签");
            }
        });

        jFrame.add(jTabbedPane);

        jFrame.setResizable(false);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new  JTabbedPaneTest().init();
    }
}
