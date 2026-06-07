package swingDemo;

import swingDemo.model.NumberComboBoxListModel;
import swingDemo.model.NumberListModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.List;

public class ListModeTest {

    JFrame jFrame = new JFrame();

    JTextField jTextField = new JTextField(20);

    JList<BigDecimal> jList = new JList<>(new NumberListModel(new BigDecimal(1), new BigDecimal(21), new BigDecimal(2)));
    JComboBox<BigDecimal> jComboBox = new JComboBox<>(new NumberComboBoxListModel(new BigDecimal(0.1), new BigDecimal(1.2), new BigDecimal(0.2)));

    private void init(){
        jList.setVisibleRowCount(4);
        jList.setSelectionInterval(2, 3);

        jList.setFixedCellHeight(30);
        jList.setFixedCellWidth(90);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<BigDecimal> selectedValuesList = jList.getSelectedValuesList();
                for(BigDecimal val : selectedValuesList){
                    jTextField.setText(jTextField.getText() + val.toString());
                }
            }
        });

        jComboBox.setMaximumRowCount(4);

        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object selectedItem = jComboBox.getSelectedItem();
                jTextField.setText(selectedItem.toString());
            }
        });

        Box horizontalBox = Box.createHorizontalBox();
        JScrollPane jScrollPane = new JScrollPane(jList);
        horizontalBox.add(jScrollPane);
        JPanel jPanel = new JPanel();
        jPanel.add(jComboBox);
        horizontalBox.add(jPanel);

        jFrame.add(horizontalBox);

        JPanel jPanel1 = new JPanel(new FlowLayout());
        jPanel1.add(new JLabel("选择的值为："));
        jPanel1.add(jTextField);
        jFrame.add(jPanel1, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
         new ListModeTest().init();
    }
}
