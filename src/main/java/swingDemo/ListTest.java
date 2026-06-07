package swingDemo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class ListTest {

    JFrame jFrame = new JFrame();

    Book[] books = new Book[]{new Book("java","java的描述"),
            new Book("C","C的描述"),
            new Book("python","python的描述"),
            new Book("C++","C++的描述"),
            new Book("C#","C#的描述")};
    JList<Book> jList = new JList<>(books);
    JComboBox<Book> jComboBox = new JComboBox<>(books);

    JTextArea jTextArea = new JTextArea(4,40);

    JScrollPane jScrollPane = new JScrollPane(jList);

    JRadioButton r = new JRadioButton("纵向滚动",true);
    JRadioButton r1 = new JRadioButton("纵向换行");
    JRadioButton r2 = new JRadioButton("横向换行");

    JRadioButton r3 = new JRadioButton("无限制",true);
    JRadioButton r4 = new JRadioButton("单选");
    JRadioButton r5 = new JRadioButton("单范围");

    private void init(){

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                switch (actionCommand) {
                    case "纵向滚动":
                        jList.setLayoutOrientation(JList.VERTICAL);
                        break;
                    case "纵向换行":
                        jList.setLayoutOrientation(JList.VERTICAL_WRAP);
                        break;
                    case "横向换行":
                        jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                        break;
                }
            }
        };

        ActionListener actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                switch (actionCommand) {
                    case "无限制":
                        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        break;
                    case "单选":
                        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        break;
                    case "单范围":
                        jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                        break;
                }
            }
        };


        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<Book> selectedValuesList = jList.getSelectedValuesList();
                for(Book book:selectedValuesList){
                    jTextArea.append(book.getDesc()+"\n");
                }
            }
        });

        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Book selectedItem = (Book)jComboBox.getSelectedItem();
                jTextArea.setText(selectedItem.getDesc()+"\n");
            }
        });

        jComboBox.setEditable(true);
        jComboBox.setMaximumRowCount(4);

        jList.setVisibleRowCount(3);
        jList.setSelectionInterval(2,4);

        r.addActionListener(actionListener);
        r1.addActionListener(actionListener);
        r2.addActionListener(actionListener);

        r3.addActionListener(actionListener1);
        r4.addActionListener(actionListener1);
        r5.addActionListener(actionListener1);

        //jScrollPane.setPreferredSize(new Dimension(100,50));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r);
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r3);
        buttonGroup1.add(r4);
        buttonGroup1.add(r5);

        Box verticalBox1 = Box.createVerticalBox();
        verticalBox1.add(jScrollPane);

        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(new LineBorder(Color.BLACK, 2), "确定选项布局");
        TitledBorder titledBorder2 = BorderFactory.createTitledBorder(new LineBorder(Color.BLACK, 2), "确定选择布局");
        JPanel jPanel = new JPanel();
        jPanel.add(r);
        jPanel.add(r1);
        jPanel.add(r2);
        jPanel.setBorder(titledBorder1);
        verticalBox1.add(jPanel);

        JPanel jPanel1 = new JPanel();
        jPanel1.add(r3);
        jPanel1.add(r4);
        jPanel1.add(r5);
        jPanel1.setBorder(titledBorder2);
        verticalBox1.add(jPanel1);

        Box box = Box.createHorizontalBox();
        box.add(verticalBox1);

        //jComboBox.setPreferredSize(new Dimension(200,20));
        JPanel jPanel2 = new JPanel();
        jPanel2.add(jComboBox);
        //jPanel2.setPreferredSize(new Dimension(200,50));
        box.add(jPanel2);

        jFrame.add(box);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(new JLabel("书本介绍:"));

        JScrollPane jScrollPane1 = new JScrollPane(jTextArea);
        verticalBox.add(jScrollPane1);
        jFrame.add(verticalBox, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new ListTest().init();
    }
}
