package awtDemo;

import javax.swing.*;
import java.awt.*;

public class FileDialogDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();

        FileDialog fileDialog = new FileDialog(frame,"open",FileDialog.LOAD);
        FileDialog fileDialog2 = new FileDialog(frame,"save",FileDialog.SAVE);

        JButton jButton = new JButton("open");
        JButton jButton2 = new JButton("save");
        jButton.addActionListener(e-> {
            fileDialog.setVisible(true);
            String directory = fileDialog.getDirectory();
            String file = fileDialog.getFile();
            System.out.println("Directory: "+directory+" File: "+file);
        });
        jButton2.addActionListener(e-> {
            fileDialog2.setVisible(true);
            String directory = fileDialog2.getDirectory();
            String file = fileDialog2.getFile();
            System.out.println("Directory: "+directory+" File: "+file);
        });

        frame.add(jButton,BorderLayout.NORTH);
        frame.add(jButton2);

        frame.pack();
        frame.setVisible(true);
    }
}
