package swingDemo;

import javax.swing.*;
import java.awt.*;

public class BorderTest {

    JFrame jFrame = new JFrame();

    private void init(){
        jFrame.setLayout(new GridLayout(2,4));


    }

    public static void main(String[] args) {
        new BorderTest().init();
    }
}
