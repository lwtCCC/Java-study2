package project.projcet1;

import javax.swing.*;
import java.awt.*;

public class ColorCellRenderer extends JPanel implements ListCellRenderer<Color>{
    private String color;
    private ImageIcon icon;
    private MyColor myColor;
    private Color background;

    @Override
    public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index, boolean isSelected, boolean cellHasFocus) {
        myColor = (MyColor) value;
        this.color = myColor.toString();
        this.icon = isSelected?new ImageIcon("./src/main/java/project/img/img_1.png")
                :new ImageIcon("./src/main/java/project/img/img.png");

        this.background = isSelected ? list.getSelectionBackground() : list.getBackground();
        return this;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200,50);
    }

    @Override
    public void paint(Graphics g) {
        int height = getHeight();
        g.setColor(background);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setFont(new Font("StSong", Font.BOLD, 18));
        g.drawImage(icon.getImage(), 10, 10, null);
        g.setColor(myColor);
        g.drawString(this.color,10+icon.getIconWidth()+5,height/2+3);
    }
}
