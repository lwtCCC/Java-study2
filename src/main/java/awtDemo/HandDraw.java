package awtDemo;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class HandDraw {

    private int WIDTH=400;
    private int HEIGH=300;

    private PopupMenu popupMenu = new PopupMenu();
    MenuItem item = new MenuItem("red");
    MenuItem item2 = new MenuItem("blue");
    MenuItem item3 = new MenuItem("green");

    private Color color= Color.BLACK;

    private int preX = -1;
    private int preY = -1;

    BufferedImage image = new BufferedImage(WIDTH, HEIGH, BufferedImage.TYPE_INT_RGB);

    Graphics g = image.getGraphics();

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0,null);
        }
    }

    MyCanvas myCanvas = new MyCanvas();

    public static void main(String[] args) {
        new HandDraw().init();
    }

    private void init() {
        Frame frame = new Frame();
        popupMenu.add(item);
        popupMenu.add(item2);
        popupMenu.add(item3);

        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("red")) {
                    color = Color.RED;
                }else if (actionCommand.equals("blue")) {
                    color = Color.BLUE;
                }else if (actionCommand.equals("green")) {
                    color = Color.GREEN;
                }
                myCanvas.repaint();
            }
        };

        item.addActionListener(actionListener);
        item2.addActionListener(actionListener);
        item3.addActionListener(actionListener);

        myCanvas.setPreferredSize(new Dimension(WIDTH,HEIGH));
        myCanvas.add(popupMenu);
        frame.add(myCanvas);
        myCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                if(popupTrigger){
                    popupMenu.show(myCanvas,e.getX(),e.getY());
                }
                preX = -1;
                preY = -1;
            }
        });

        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HEIGH);

        //鼠标按下并拖动时绘图
        myCanvas.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {

                if(preX > 0 && preY > 0){
                    g.setColor(color);
                    g.drawLine(preX,preY,e.getX(),e.getY());
                }

                preX = e.getX();
                preY = e.getY();
                myCanvas.repaint();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
