package swingDemo;

import javax.swing.*;
import java.awt.*;

public class JProgressTest {

    JFrame jFrame =  new JFrame();

    JCheckBox box1 = new JCheckBox("不确定进度");
    JCheckBox box2 = new JCheckBox("不绘制边框");

    JProgressBar progressBar = new JProgressBar();

    private void init() {

        box1.addActionListener(e -> {
            boolean selected = box1.isSelected();
            progressBar.setIndeterminate(selected);
            progressBar.setStringPainted(!selected);
        });

        box2.addActionListener(e -> {
            boolean selected = box2.isSelected();
            progressBar.setBorderPainted(!selected);
        });

        progressBar.setStringPainted(true);
        progressBar.setBorderPainted(true);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(box1);
        verticalBox.add(box2);

        jFrame.setLayout(new FlowLayout());
        jFrame.add(verticalBox);
        jFrame.add(progressBar);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        for (int i = 0; i <= 100; i++) {
            progressBar.setValue(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("执行完了");
    }

    public static void main(String[] args) {
        new  JProgressTest().init();
    }
}
