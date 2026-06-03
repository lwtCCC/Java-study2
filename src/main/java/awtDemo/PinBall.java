package awtDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PinBall {
    //画布大小
    private static final int CANVAS_WIDTH = 400;
    private static final int CANVAS_HEIGHT = 300;

    //球拍大小
    private static final int TABLE_WIDTH = 60;
    private static final int TABLE_HEIGHT = 20;

    //球大小
    private static final int BALL_SIZE = 10;

    //记录位置,球
    private static int BALL_X = 120;
    private static int BALL_Y = 20;

    //速度,球
    private static int SPEED_X = 10;
    private static int SPEED_Y = 10;

    //记录位置，球拍
    private static int TABLE_X = 100;
    private static int TABLE_Y = 270;

    //移动速度,球拍
    private static final int SPEED_TABLE = 50;

    //胜负
    private static boolean flag = false;

    //定时器
    private Timer timer;

    //画布
    private MyCanvas myCanvas = new MyCanvas();

    public static void main(String[] args) {
        new PinBall().init();
    }

    private void init() {
        Frame frame = new Frame();

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    if (TABLE_X - SPEED_TABLE > 0) {
                        TABLE_X = TABLE_X - SPEED_TABLE;
                    }else {
                        TABLE_X = 0;
                    }
                } else if (key == KeyEvent.VK_RIGHT) {
                    if (TABLE_X+SPEED_TABLE < CANVAS_WIDTH - TABLE_WIDTH) {
                        TABLE_X = TABLE_X + SPEED_TABLE;
                    }else{
                        TABLE_X = CANVAS_WIDTH - TABLE_WIDTH;
                    }
                }
            }
        };

        frame.addKeyListener(keyAdapter);

        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(BALL_X <= 0 || BALL_X >= CANVAS_WIDTH - BALL_SIZE) {
                    SPEED_X = -SPEED_X;
                }
                if(BALL_Y <= 0 || (BALL_Y + BALL_SIZE >= TABLE_Y && BALL_X >= TABLE_X && BALL_X + BALL_SIZE <= TABLE_X+TABLE_WIDTH )) {
                    SPEED_Y = -SPEED_Y;
                }
                if(BALL_Y + BALL_SIZE >= CANVAS_HEIGHT) {
                    timer.stop();
                    flag = true;
                    myCanvas.repaint();
                }

                BALL_X += SPEED_X;
                BALL_Y += SPEED_Y;
                myCanvas.repaint();
            }
        };
        timer = new Timer(100,task);
        timer.start();

        myCanvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        frame.add(myCanvas);
        frame.pack();
        frame.setVisible(true);
    }

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {

            if (flag){
                g.setColor(Color.BLUE);
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("游戏结束！",CANVAS_HEIGHT/2-50,CANVAS_HEIGHT/2);
            }else {
                g.setColor(Color.RED);
                g.drawOval(BALL_X, BALL_Y, BALL_SIZE, BALL_SIZE);
                g.fillOval(BALL_X, BALL_Y, BALL_SIZE, BALL_SIZE);

                g.setColor(Color.ORANGE);
                g.drawRect(TABLE_X, TABLE_Y, TABLE_WIDTH, TABLE_HEIGHT);
                g.fillRect(TABLE_X, TABLE_Y, TABLE_WIDTH, TABLE_HEIGHT);
            }

        }
    }
}
