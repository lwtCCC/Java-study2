package GAME1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 extends methed2 {
    public static void main(String[] args) {

        /*
        *
        * 试着添加动作监听
        * */
        JFrame jf = new JFrame();
        jf.setSize(400, 400);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("菜单");
        JMenuItem jMenuItem = new JMenuItem("退出");
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        jf.setJMenuBar(jMenuBar);

        jf.setAlwaysOnTop(true);
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);

        JButton jButton = new JButton("点我看看");
        jButton.setBounds(0, 0, 100, 100);

        //普通添加
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("普通方法的实现");
            }
        });

        //匿名内部类
        jButton.addActionListener(e-> System.out.println("匿名内部类的实现"));

        //方法引用
        jButton.addActionListener(Test1::methed1);

        // 外部类实现
        jButton.addActionListener(new methed2());

        jf.add(jButton);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    private static void methed1(ActionEvent actionEvent) {
        System.out.println("方法引用的实现");
    }

}
