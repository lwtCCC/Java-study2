package GAME1.MyJFrame3;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame extends JFrame implements KeyListener {
    JButton jButton = new JButton("文字");
    JButton jButton1 = new JButton("放大");
    JButton jButton2 = new JButton("位移");


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

        jButton.addKeyListener(this);
        jButton.setBounds(10, 10, 100, 30);

        this.add(jButton);
        this.add(jButton1);
        this.add(jButton2);

        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("键盘被点击了");
        if (e.getKeyCode() == 66) {
            System.out.println("现在点击的是B");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("键盘松开了");
    }
}
