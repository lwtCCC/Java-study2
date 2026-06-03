package GAME1.MyJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    JButton jButton = new JButton("文字");
    JButton jButton1 = new JButton("放大");
    JButton jButton2 = new JButton("位移");
    int count = 0;

    public MyJFrame() {
        this.setTitle("Test");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu jMenu1 = new JMenu("Menu");

        JMenuItem jMenuItem1 = new JMenuItem("选项1");

        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        this.setJMenuBar(menuBar);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


        jButton.addActionListener(this);
        jButton.setBounds(10, 10, 100, 50);
        jButton1.addActionListener(this);
        jButton1.setBounds(60, 70, 70, 60);
        jButton2.addActionListener(this);
        jButton2.setBounds(200, 100, 70, 60);

        this.add(jButton);
        this.add(jButton1);
        this.add(jButton2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == jButton) {
            System.out.println("不要再点啦");
        } else if (source == jButton1) {
            count %= 2;
            if (count == 0) {
                this.setSize(700, 800);
                jButton1.setText("缩小");
            } else {
                jButton1.setText("放大");
                this.setSize(500, 500);
            }
            count++;
        } else if (source == jButton2) {
            Random r = new Random();
            jButton2.setLocation(r.nextInt(300), r.nextInt(300));
        }

    }
}
