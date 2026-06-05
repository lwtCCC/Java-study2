package swingDemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JFileChooserDemo {

    JFrame jFrame = new JFrame("文件选择对话框测试");

    JToolBar jToolBar = new JToolBar();

    JFileChooser jFileChooser = new JFileChooser();

    JButton open = new JButton(new AbstractAction("文件打开") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jFileChooser.showOpenDialog(jFrame);
            File selectedFile = jFileChooser.getSelectedFile();
            try {
                image = ImageIO.read(selectedFile);
                myCanvas.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    });

    JButton save = new JButton(new AbstractAction("文件保存") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jFileChooser.showSaveDialog(jFrame);
            File selectedFile = jFileChooser.getSelectedFile();
            try {
                ImageIO.write(image,"PNG",selectedFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    });

    BufferedImage image;

    private class MyCanvas extends JPanel{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }

    MyCanvas myCanvas = new MyCanvas();

    private void init(){
        jToolBar.add(save);
        jToolBar.add(open);
        myCanvas.setPreferredSize(new Dimension(400,400));

        jFrame.add(jToolBar,BorderLayout.NORTH);

        jFrame.add(myCanvas);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JFileChooserDemo().init();
    }
}
