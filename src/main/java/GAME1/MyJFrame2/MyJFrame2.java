package GAME1.MyJFrame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener{

    JButton jButton = new JButton("文字");
    JButton jButton1 = new JButton("放大");
    JButton jButton2 = new JButton("位移");

    public MyJFrame2(){
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

        jButton.addMouseListener(this);
        jButton.setBounds(10, 10, 100, 30);

        this.add(jButton);
        this.add(jButton1);
        this.add(jButton2);

        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击事件");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标划出");
    }
}
