package swingDemo;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressMonitorTest {

    Timer timer;

    JProgressBar progressBar = new JProgressBar();

    @Setter
    @Getter
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


    private void init(){

        ProgressMonitor progressMonitor = new ProgressMonitor(null,"当前进度","已完成",0,100);

        ThreadTest threadTest = new ThreadTest(100);
        new Thread(threadTest).start();

         timer = new Timer(100,new  ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int current = threadTest.getCurrent();
                progressMonitor.setProgress(current);

                if(progressMonitor.isCanceled()){
                    timer.stop();
                    progressMonitor.close();
                    System.exit(0);
                }
            }
        });

        timer.start();
    }


    public static void main(String[] args) {
        new ProgressMonitorTest().init();
    }
}
