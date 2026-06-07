package swingDemo;

import javax.swing.*;
import java.awt.*;

public class ListCellRendererTest {

    JFrame jFrame = new JFrame();

    String[] s = {"lwt","jfx","zm","gyy","xc","wq",};

    JList<String> jList = new JList<>(s);

    private void init(){

        jFrame.add(jList);
        jList.setCellRenderer(new MyRenderer());

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    private class MyRenderer extends JPanel implements ListCellRenderer{

        private String name;
        private ImageIcon icon;

        private Color background;
        private Color foreground;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            this.name = value.toString();
            this.icon = new ImageIcon("./src/main/java/swingDemo/img/lwt1.png");
            this.background = isSelected ? list.getSelectionBackground() : list.getBackground();
            this.foreground = isSelected ? list.getSelectionForeground() : list.getForeground();

            return this;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200,175);
        }

        @Override
        public void paint(Graphics g) {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();

            g.setColor(background);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setFont(new Font("StSong", Font.BOLD, 18));
            g.setColor(foreground);
            g.drawImage(icon.getImage(), this.getWidth()/2 - w/2, 10, null);
            g.drawString(this.name, this.getWidth()/2 - this.name.length()/2, 30+h);

        }
    }

    public static void main(String[] args) {
        new ListCellRendererTest().init();
    }
}
