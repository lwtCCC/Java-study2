package project;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class SearchNumJFrame extends JFrame {
    public  SearchNumJFrame() {
        initJF();

        jTools();

        container();

        this.setVisible(true);
    }

    private void container() {
        JPanel leftPanel = new JPanel();

        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(BorderFactory.createTitledBorder("颜色"));
        JCheckBox checkBox1 = new JCheckBox("red");
        JCheckBox checkBox2 = new JCheckBox("blue");
        JCheckBox checkBox3 = new JCheckBox("green");
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        // 统一设置大小
        Dimension checkBoxSize = new Dimension(150, 100);
        checkBox1.setPreferredSize(checkBoxSize);
        checkBox1.setMaximumSize(checkBoxSize);
        checkBox2.setPreferredSize(checkBoxSize);
        checkBox2.setMaximumSize(checkBoxSize);
        checkBox3.setPreferredSize(checkBoxSize);
        checkBox3.setMaximumSize(checkBoxSize);

        // 设置左对齐
        checkBox1.setAlignmentX(Component.LEFT_ALIGNMENT);
        checkBox2.setAlignmentX(Component.LEFT_ALIGNMENT);
        checkBox3.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftPanel.add(checkBox1);
        leftPanel.add(checkBox2);
        leftPanel.add(checkBox3);

        JScrollPane scrollPane = new JScrollPane(leftPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel rightPanel = new JPanel(new GridLayout(4, 5, 15, 15));
        rightPanel.setBackground(Color.WHITE);
//        rightPanel.setBorder(BorderFactory.createEmptyBorder());

        //rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel[] numberLabels = new JLabel[20];
        for (int i = 0; i < 20; i++) {
            numberLabels[i] = new JLabel(""+i, SwingConstants.CENTER);
            numberLabels[i].setFont(new Font("微软雅黑", Font.BOLD, 28));
            numberLabels[i].setOpaque(true);
            numberLabels[i].setBackground(Color.WHITE);
            numberLabels[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            numberLabels[i].setBorder(new BevelBorder(1));
            numberLabels[i].setPreferredSize(new Dimension(80, 80));
            rightPanel.add(numberLabels[i]);
        }

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, rightPanel);
        splitPane.setDividerLocation(200);  // 设置分割线位置
        splitPane.setContinuousLayout(true); // 拖动时实时重绘
        this.add(splitPane, BorderLayout.CENTER);
    }

    private void jTools() {
        Dimension dimension = new Dimension(75, 25);
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel jt1 = new JLabel("长度");
        JTextField jTextField1 = new JTextField();
        jTextField1.setPreferredSize(dimension);
        jTextField1.setHorizontalAlignment(JTextField.CENTER);

        JLabel jt2 = new JLabel("范围");
        JTextField jTextField2 = new JTextField();
        jTextField2.setPreferredSize(dimension);
        jTextField2.setHorizontalAlignment(JTextField.CENTER);


        JLabel jt3 = new JLabel("sleeptime");
        JTextField jTextField3 = new JTextField();
        jTextField3.setPreferredSize(dimension);
        jTextField3.setHorizontalAlignment(JTextField.CENTER);


        JButton jButton1 = new JButton("生成");
        JButton jButton2 = new JButton("查找重复值");
        JButton jButton3 = new JButton("添加颜色");

        topPanel.add(jt1);
        topPanel.add(jTextField1);
        topPanel.add(jt2);
        topPanel.add(jTextField2);
        topPanel.add(jt3);
        topPanel.add(jTextField3);
        topPanel.add(jButton1);
        topPanel.add(jButton2);
        topPanel.add(jButton3);

        this.add(topPanel, BorderLayout.NORTH);
    }

    private void initJF() {
        this.setSize(700, 300);
        this.setTitle("随机数序列查找重复值,动态演示");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
