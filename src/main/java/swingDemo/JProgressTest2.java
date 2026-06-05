package swingDemo;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class JProgressTest2 {

    JFrame jFrame =  new JFrame();

    JCheckBox box1 = new JCheckBox("不确定进度");
    JCheckBox box2 = new JCheckBox("不绘制边框");

    JProgressBar progressBar = new JProgressBar();

    @Setter @Getter
    private class ThreadTest implements Runnable {
        private int max;
        private volatile int current = 0;

        private ThreadTest(int max) {
            this.max = max;
        }

        @Override
        public void run() {

            while (current<max) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                current++;
            }
        }
    }

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

        ThreadTest threadTest = new ThreadTest(100);
        new Thread(threadTest).start();

        Timer timer = new Timer(200, e -> {
            int current = threadTest.getCurrent();
            progressBar.setValue(current);
        });
        timer.start();

        System.out.println("执行完了");
    }

    public static void main(String[] args) {
        new JProgressTest2().init();
    }
}
