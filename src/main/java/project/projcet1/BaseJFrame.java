package project.projcet1;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class BaseJFrame {
    private JFrame jFrame;

    public BaseJFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public static ArrayList<JLabel> createJLabelArr(String... s){
        ArrayList<JLabel> list = new ArrayList<>();
        for(String str : s){
            list.add(new JLabel(str));
        }
        return list;
    }

    public static ArrayList<JButton> createJButtonArr(String... s){
        ArrayList<JButton> list = new ArrayList<>();
        for(String str : s){
            list.add(new JButton(str));
        }
        return list;
    }

    public static void setTextCenter(JTextField... text){
        for(JTextField jTextField : text){
            jTextField.setHorizontalAlignment(JTextField.CENTER);
        }
    }

    public void addBox(Box parent,int spacing,JComponent... child) {
        for (JComponent c : child) {
            parent.add(c);
            parent.add(Box.createHorizontalStrut(spacing));
        }
    }

    public void addBox(Box parent,JComponent... child) {
        for (JComponent c : child) {
            parent.add(c);
        }
    }

    public JComponent createPopupJMenu(JComponent parent, JMenuItem... items) {
        JPopupMenu jPopupMenu = new JPopupMenu();
        for (JMenuItem item : items) {
            jPopupMenu.add(item);
        }
        parent.setComponentPopupMenu(jPopupMenu);
        return parent;
    }

    public <E> void initModel(DefaultListModel<E> model,E[] elements) {
        for (E e : elements) {
            model.addElement(e);
        }
    }

    public <E> void addModel(DefaultListModel<E> model,DefaultListModel<E> model2) {
        HashMap<E, Integer> map = new HashMap<>();
        for(int i = 0; i < model.getSize(); i++) {
            if(!map.containsKey(model.getElementAt(i))) {
                map.put(model.getElementAt(i), 1);
            }
        }

        for (int j = 0; j < model2.getSize(); j++) {
            if (!map.containsKey(model2.getElementAt(j))) {
                map.put(model2.getElementAt(j), 1);
                model.addElement(model2.get(j));
            }
        }
    }

    public void changeFlavor(String flavor,JFrame jFrame) throws Exception {
        switch (flavor){
            case "Metal 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            case "Windows 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows 经典风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }
        SwingUtilities.updateComponentTreeUI(jFrame.getContentPane());
    }

    public static void addButtonGroup(ButtonGroup buttonGroup,JRadioButton... btn) {
        for (JRadioButton jRadioButton : btn) {
            buttonGroup.add(jRadioButton);
        }
    }

    public void initJFrame(){
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
