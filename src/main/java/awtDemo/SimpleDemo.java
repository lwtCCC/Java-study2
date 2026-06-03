package awtDemo;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SimpleDemo {
    public static void main(String[] args) {

        Frame frame = new Frame();

        Menu menu = new Menu("select");
        MenuItem it1 = new MenuItem("select1");
        MenuItem it2 = new MenuItem("select2");
        MenuItem it3 = new MenuItem("select3");

        Menu menu1 = new Menu("special select");
        MenuItem it4 = new MenuItem("select4 ctrl+shift+q",new MenuShortcut(KeyEvent.VK_Q,true));
        MenuItem it5 = new MenuItem("select5");
        MenuBar menuBar = new MenuBar();

        it4.addActionListener(e -> {
            System.out.println("select4");
        });

        menu.add(it1);
        menu.add(it2);
        menu.add(it3);
        menu.add(new MenuItem("-"));
        menu1.add(it4);
        menu1.add(it5);
        menu.add(menu1);
        menuBar.add(menu);

        frame.setMenuBar(menuBar);

        frame.add(new TextArea(5,20));

        frame.pack();
        frame.setVisible(true);
    }
}
