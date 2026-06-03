package GAME1;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    private static int[][] arr1 = new int[4][4]; //执行数组
    private final int[][] data = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};//答案数组
    private boolean flag = false;//获胜条件
    private int step = 0;//步数统计

    private int x;//空格x
    private int y;//空格y

    //积木搭建
    public GameJFrame() {

        initJFrame();

        initJMenuBar();

        initData();

        initImage();

        this.setVisible(true);

    }

    //初始化游戏相关数组
    private void initData() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i = 0; i < arr.length; i++) {
            int r = new Random().nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            arr1[i / 4][i % 4] = arr[i];
        }

    }

    //初始化图片
    private void initImage() {
        extracted(arr1);
    }

    //菜单内容
    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        this.setJMenuBar(jMenuBar);

        JMenu jMenu1 = new JMenu("功能");
        JMenu jMenu2 = new JMenu("关于我们");
        JMenu jMenu3 = new JMenu("多项选择");

        JMenuItem jMenuItem11 = new JMenuItem("Exit");
        JMenuItem jMenuItem12 = new JMenuItem("重新游戏");
        JMenuItem jMenuItem13 = new JMenuItem("重新登录");

        JMenuItem jMenuItem21 = new JMenuItem("公众号");

        JMenuItem jMenuItem31 = new JMenuItem("选项1");
        jMenu3.add(jMenuItem31);

        jMenu1.add(jMenu3);

        jMenu1.add(jMenuItem11);
        jMenu1.add(jMenuItem12);
        jMenu1.add(jMenuItem13);
        jMenu2.add(jMenuItem21);

        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);

        jMenuItem11.addActionListener(e -> {
            this.dispose();
        });

        jMenuItem12.addActionListener(e -> {
            step = 0;
            initData();
            initImage();
        });

        jMenuItem13.addActionListener(e -> {
            this.setVisible(false);
            new LoginJFrame();
        });

        jMenuItem21.addActionListener(e -> {
            JDialog jDialog = new JDialog();
            jDialog.setSize(300, 300);
            ImageIcon imageIcon = new ImageIcon("src/main/java/GAME1/images/5.png");
            JLabel jLabel = new JLabel(imageIcon);
            jDialog.add(jLabel);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        });
    }
    //初始化界面
    private void initJFrame() {
        this.setSize(170 * 4, 170 * 4 + 50 + 40);
        this.setTitle("Game");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);

        //取消默认布局
        this.setLayout(null);

        this.setDefaultCloseOperation(3);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (flag) {
            return;
        }
        int keyCode = e.getKeyCode();
        if (keyCode == 65) {
            extracted(data);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (flag) {
            return;
        }
        //左：37   上：38   右：39   下：40
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            if (x < 3) {
                int temp = arr1[x + 1][y];
                arr1[x + 1][y] = 0;
                arr1[x][y] = temp;
                x++;
                step++;
                initImage();
            }
        } else if (keyCode == 38) {
            if (y < 3) {
                int temp = arr1[x][y + 1];
                arr1[x][y + 1] = 0;
                arr1[x][y] = temp;
                y++;
                step++;
                initImage();
            }
        } else if (keyCode == 39) {
            if (x > 0) {
                int temp = arr1[x - 1][y];
                arr1[x - 1][y] = 0;
                arr1[x][y] = temp;
                x--;
                step++;
                initImage();
            }
        } else if (keyCode == 40) {
            if (y > 0) {
                int temp = arr1[x][y - 1];
                arr1[x][y - 1] = 0;
                arr1[x][y] = temp;
                y--;
                step++;
                initImage();
            }
        } else if (keyCode == 65) {//a
            initImage();
        } else if (keyCode == 87) {//w
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    arr1[i][j] = data[i][j];
                }
            }
            extracted(data);
        }
    }

    private void extracted(int[][] arr) {
        this.getContentPane().removeAll();

        JLabel str = new JLabel("步数：" + step);
        str.setBounds(10, 10, 60, 30);
        this.getContentPane().add(str);

        flag = win();
        if (flag) {
            ImageIcon winer = new ImageIcon("src/main/java/GAME1/images/win1.png");
            JLabel jLabel = new JLabel(winer);
            jLabel.setBounds(0, 40, winer.getIconWidth(), winer.getIconHeight());
            this.getContentPane().add(jLabel);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon icon = new ImageIcon("src/main/java/GAME1/images/" + arr[i][j] + ".png");
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(170 * i, 170 * j + 40, 170, 170);
                jLabel.setBorder(new BevelBorder(1));
                this.getContentPane().add(jLabel);
            }
        }

        ImageIcon imageIcon = new ImageIcon("src/main/java/GAME1/images/999.png");
        JLabel jLabel1 = new JLabel(imageIcon);
        jLabel1.setBounds(0, 40, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        this.getContentPane().add(jLabel1);

        this.getContentPane().repaint();
    }

    private boolean win() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr1[i][j] != data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
