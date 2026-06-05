package swingDemo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class SplitPaneDemo {

    JFrame jFrame =  new JFrame("测试分割条");

    Person[] p = {new Person("罗薇塔1","luoweita1",new ImageIcon("./src/main/java/swingDemo/img/lwt1.png")),
            new Person("罗薇塔2","luoweita2",new ImageIcon("./src/main/java/swingDemo/img/lwt2.png")),
            new Person("罗薇塔3","luoweita3",new ImageIcon("./src/main/java/swingDemo/img/lwt3.png"))};

    JList<Person> list = new JList<>(p);
    JLabel jLabel = new JLabel();
    JTextArea jTextArea = new JTextArea(6,8);

    JScrollPane jScrollPane = new JScrollPane(jTextArea);

    JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jLabel,jScrollPane);
    JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jSplitPane,list);

    private void init(){
        list.setPreferredSize(new Dimension(150,400));
        jLabel.setPreferredSize(new Dimension(220,270));
        jTextArea.setPreferredSize(new Dimension(220,130));

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Person selectedValue = list.getSelectedValue();
                jLabel.setIcon(selectedValue.getIcon());
                jTextArea.setText(selectedValue.getDesc());
            }
        });

        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setContinuousLayout(true);

        jSplitPane1.setContinuousLayout(true);

        jFrame.add(jSplitPane1);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new SplitPaneDemo().init();
    }
}
