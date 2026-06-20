package project.projcet1;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {

        JTextField j1 = new JTextField(10);
        JTextField j2 = new JTextField(10);
        JTextField j3 = new JTextField(10);
        BaseJFrame.setTextCenter(j1,j2,j3);

        BaseJFrame baseJFrame = new BaseJFrame(new JFrame());

        JPanel top = new JPanel();
        JPanel center = new JPanel();

        Box box = Box.createHorizontalBox();
        baseJFrame.addBox(box, 10,new JLabel("文本1"),j1,
                                            new JLabel("文本2"),j2,
                                            new JLabel("文本3"),j3,
                                            new JButton("生成"),new JButton("查找"),new JButton("设置"));
        top.add(box);
        baseJFrame.createPopupJMenu(center,new JMenuItem("11"),new JMenuItem("12"));
        JFrame jFrame = baseJFrame.getJFrame();
        jFrame.add(top,BorderLayout.NORTH);
        jFrame.add(center,BorderLayout.CENTER);
        baseJFrame.initJFrame();
    }
}
