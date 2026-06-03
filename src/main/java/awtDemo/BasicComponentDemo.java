package awtDemo;

import javax.swing.*;
import java.awt.*;

public class BasicComponentDemo {

    Frame frame = new Frame();
    TextArea textArea = new TextArea(5,20);//文本域
    TextField textField = new TextField(20);//文本框
    CheckboxGroup checkboxGroup = new CheckboxGroup();//按钮组
    Checkbox male = new Checkbox("男",checkboxGroup,true);//复选按钮
    Checkbox girl = new Checkbox("女",checkboxGroup,false);//复选按钮
    Checkbox isMarried = new Checkbox("是否已婚");//复选按钮
    List colorlist = new List(6,true);//列表框
    Choice choice = new Choice();
    JButton btn = new JButton("确认");
    Panel npanel = new Panel();
    Panel spanel = new Panel();

    public void init() {
        //北侧组件
        Box nbox = Box.createHorizontalBox();

        Box nlbox = Box.createVerticalBox();//北侧+左侧盒子

        nlbox.add(textArea);

        Box box = Box.createHorizontalBox();
        choice.add("red");
        choice.add("green");
        choice.add("blue");
        box.add(choice);
        box.add(male);
        box.add(girl);
        box.add(isMarried);

        nlbox.add(box);

        nbox.add(nlbox);

        colorlist.add("red");
        colorlist.add("green");
        colorlist.add("blue");
        nbox.add(colorlist);
        npanel.add(nbox);
        frame.add(npanel);

        //南侧组件
        Box sbox = Box.createHorizontalBox();
        sbox.add(textField);
        sbox.add(Box.createHorizontalStrut(10));
        sbox.add(btn);
        spanel.add(sbox);
        frame.add(spanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BasicComponentDemo().init();
    }
}
