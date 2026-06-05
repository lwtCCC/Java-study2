package swingDemo;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class BorderTest {

    JFrame jFrame = new JFrame();

    private void init(){
        jFrame.setTitle("边框测试");
        jFrame.setLayout(new GridLayout(2,4));

        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.red, Color.blue, Color.green, Color.yellow);
        jFrame.add(getWithBorder(bevelBorder,"bevelBorder"));

        Border lineBorder = BorderFactory.createLineBorder(Color.black,10);
        jFrame.add(getWithBorder(lineBorder,"lineBorder"));

        Border emptyBorder = BorderFactory.createEmptyBorder(10,20,5,10);
        jFrame.add(getWithBorder(emptyBorder,"emptyBorder"));

        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.black,Color.blue);
        jFrame.add(getWithBorder(etchedBorder,"etchedBorder"));

        TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.red,3),"titledBorder");
        jFrame.add(getWithBorder(titledBorder,"titledBorder"));

        MatteBorder matteBorder = new MatteBorder(30,30,30,30,Color.orange);
        jFrame.add(getWithBorder(matteBorder,"matteBorder"));

        CompoundBorder compoundBorder = new CompoundBorder(BorderFactory.createLineBorder(Color.red,10), BorderFactory.createTitledBorder(new LineBorder(Color.yellow,10),"compoundBorder"));
        jFrame.add(getWithBorder(compoundBorder,"compoundBorder"));


        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }


    private JPanel getWithBorder(Border border,String content){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel(content));
        jPanel.setBorder(border);

        return jPanel;
    }

    public static void main(String[] args) {
        new BorderTest().init();
    }
}
