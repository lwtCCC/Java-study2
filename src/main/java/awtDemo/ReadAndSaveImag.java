package awtDemo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadAndSaveImag {


    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("File");
    MenuItem menuItem = new MenuItem("Load");
    MenuItem menuItem2 = new MenuItem("Save");

    BufferedImage bufferedImage;

    private class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.drawImage(bufferedImage,0,0,null);
        }
    }

    MyCanvas myCanvas = new MyCanvas();


    private void init(){
        Frame frame = new Frame();

        menuItem.addActionListener(e->{
            FileDialog fileDialog = new FileDialog(frame,"打开文件",FileDialog.LOAD);
            fileDialog.setVisible(true);

            String directory = fileDialog.getDirectory();
            String file = fileDialog.getFile();
            try {
                bufferedImage = ImageIO.read(new File(directory,file));
                myCanvas.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        menuItem2.addActionListener(e->{

            FileDialog fileDialog = new FileDialog(frame,"保存文件",FileDialog.SAVE);
            fileDialog.setVisible(true);

            String directory = fileDialog.getDirectory();
            String file = fileDialog.getFile();

            try {
                ImageIO.write(bufferedImage,"PNG",new File(directory,file));

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        menuBar.add(fileMenu);
        fileMenu.add(menuItem);
        fileMenu.add(menuItem2);
        frame.add(myCanvas);
        frame.setMenuBar(menuBar);

        frame.setBounds(200,200,740,508);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new ReadAndSaveImag().init();
    }

}
