package awtDemo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleDemo2 {
    public static void main(String[] args) {

        Frame frame = new Frame();

        TextArea textArea = new TextArea(10, 100);

        Panel panel = new Panel();
        PopupMenu popupMenu = new PopupMenu();
        MenuItem menuItem = new MenuItem("select");
        MenuItem menuItem2 = new MenuItem("select2");
        MenuItem menuItem3 = new MenuItem("select3");
        Menu menu = new Menu("special select");
        MenuItem menuItem4 = new MenuItem("select4");
        menuItem4.addActionListener(e -> {
            textArea.append("select4");
        });
        MenuItem menuItem5 = new MenuItem("select5");

        menu.add(menuItem4);
        menu.add(menuItem5);
        popupMenu.add(menuItem);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);
        popupMenu.add(menu);

        panel.add(popupMenu);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean flag = e.isPopupTrigger();
                if(flag){
                    popupMenu.show(panel,e.getX(),e.getY());
                }
            }
        });

        panel.setPreferredSize(new Dimension(150,200));
        frame.add(textArea, BorderLayout.NORTH);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}
