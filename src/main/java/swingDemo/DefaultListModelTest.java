package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DefaultListModelTest {

    JFrame jFrame = new JFrame();

    JButton jbt =  new JButton("添加");
    JButton jbt2 =  new JButton("删除");

    JTextField jTextField = new JTextField(20);

    JList<String> jList = new JList<>();

    DefaultListModel<String> model = new DefaultListModel<>();

    private void init(){

        jList.setModel(model);

        jbt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextField.getText();
                if(!text.trim().isEmpty()){
                    model.addElement(text);
                }
            }
        });

        jbt2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jList.getSelectedIndex();
                if(selectedIndex>=0){
                    model.removeElementAt(selectedIndex);
                }
            }
        });

        model.addElement("java");
        model.addElement("C");
        model.addElement("C++");
        model.addElement("python");

        jList = new JList<>(model);

        jList.setVisibleRowCount(4);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jScrollPane = new JScrollPane(jList);

        JPanel jPanel = new JPanel(new FlowLayout());
        jPanel.add(jTextField);
        jPanel.add(jbt);
        jPanel.add(jbt2);
        jFrame.add(jPanel,BorderLayout.SOUTH);
        jFrame.add(jScrollPane);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new  DefaultListModelTest().init();
    }
}
