package project.projcet1;

import javax.swing.*;
import java.util.ArrayList;

public class MyThread implements Runnable {
    private int time;
    private int row;
    private int col;
    private int[] arr;
    SearchNumJFrame1 searchNumJFrame1;

    public MyThread(int time,int row,int col,int[] arr,SearchNumJFrame1 searchNumJFrame1) {
        this.time = time;
        this.row = row;
        this.col = col;
        this.arr = arr;
        this.searchNumJFrame1 = searchNumJFrame1;
    }

    @Override
    public void run() {
        int[] zeroArr = new int[row*col];
        ArrayList<JLabel> jLabels = searchNumJFrame1.getJLabels();
        JPanel jPanel = searchNumJFrame1.getJPanel();
        try {
            searchNumJFrame1.createNumTable(zeroArr,row,col);
        } catch (Exception _) {

        }

        for(int i=0;i<row*col;i++){
            if(searchNumJFrame1.isStopFlag()){
                return;
            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException _) {}
            jLabels.get(i).setText(arr[i]+"");
            jPanel.revalidate();
            jPanel.repaint();
        }
    }
}
