package swingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingComponentDemo {

    JFrame jFrame = new JFrame();

    JMenuBar jMenuBar = new JMenuBar();

    JMenu jMenu =  new JMenu("文件");
    JMenu jMenu2 =  new JMenu("编辑");

    JMenuItem jMenuItem1 = new JMenuItem("打开文件");
    JMenuItem jMenuItem2 = new JMenuItem("保存文件");
    JMenuItem jMenuItem3 = new JMenuItem("自动换行");
    JMenuItem jMenuItem4 = new JMenuItem("复制");
    JMenuItem jMenuItem5 = new JMenuItem("粘贴");
    JMenuItem jMenuItem6 = new JMenuItem("注释");
    JMenuItem jMenuItem7 = new JMenuItem("取消注释");

    JMenu jMenu3 = new JMenu("格式");

    JTextArea jTextArea = new JTextArea(5,20);

    String[] comboBoxList = {"红色", "绿色", "蓝色"};
    JComboBox<String> jComboBox = new JComboBox<>(comboBoxList);

    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton jCheckBox =  new JRadioButton("男");
    JRadioButton jCheckBox2 =  new JRadioButton("女");

    JCheckBox jCheckBox3 =  new JCheckBox("是否已婚");

    String[] colors = {"红色", "绿色", "蓝色"};
    JList<String> jList = new JList<>(colors);

    JTextField jTextField = new JTextField(20);
    JButton btn = new JButton("确认");

    JPopupMenu jPopupMenu = new JPopupMenu();

    ButtonGroup buttonGroup2 = new ButtonGroup();
    JRadioButtonMenuItem item = new JRadioButtonMenuItem("Metal 风格");
    JRadioButtonMenuItem item2 = new JRadioButtonMenuItem("Nimbus 风格");
    JRadioButtonMenuItem item3 = new JRadioButtonMenuItem("Windows 风格",true);
    JRadioButtonMenuItem item4 = new JRadioButtonMenuItem("Windows 经典风格");
    JRadioButtonMenuItem item5 = new JRadioButtonMenuItem("Motif 风格");

    private void init(){
        //选项1
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);

        //选项2
        jMenu2.add(jMenuItem3);
        jMenu2.addSeparator();
        jMenu2.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        jMenu2.addSeparator();

        //选项2分支
        jMenu3.add(jMenuItem6);
        jMenu3.add(jMenuItem7);
        jMenu2.add(jMenu3);

        //菜单栏
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu2);
        jFrame.setJMenuBar(jMenuBar);

        //界面
        Box box = Box.createHorizontalBox();//最外侧的盒子
        Box verticalBox = Box.createVerticalBox();//左侧盒子
        Box box2 = Box.createHorizontalBox();//左侧盒子的横向盒子

        //左侧盒子的横向盒子添加下拉列表
        box2.add(jComboBox);

        //左侧盒子选项按钮
        buttonGroup.add(jCheckBox);
        buttonGroup.add(jCheckBox2);

        box2.add(jCheckBox);
        box2.add(jCheckBox2);
        box2.add(jCheckBox3);

        //鼠标右键菜单选项---单选设置
        buttonGroup2.add(item);
        buttonGroup2.add(item2);
        buttonGroup2.add(item3);
        buttonGroup2.add(item4);
        buttonGroup2.add(item5);

        //鼠标右键菜单选项
        jPopupMenu.add(item);
        jPopupMenu.add(item2);
        jPopupMenu.add(item3);
        jPopupMenu.add(item4);
        jPopupMenu.add(item5);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        item.addActionListener(actionListener);
        item2.addActionListener(actionListener);
        item3.addActionListener(actionListener);
        item4.addActionListener(actionListener);
        item5.addActionListener(actionListener);

        //添加鼠标右键菜单给文本域
        jTextArea.add(jPopupMenu);

        //绑定鼠标右键事件
        /*jTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger()){
                    jPopupMenu.show(jTextArea, e.getX(), e.getY());
                }
            }
        });*/
        jTextArea.setComponentPopupMenu(jPopupMenu);

        verticalBox.add(jTextArea);//添加文本域
        verticalBox.add(box2);//内部添加上下盒子

        box.add(verticalBox);//加入最外侧的大盒子

        box.add(jList);//大盒子加入列表框
        jFrame.add(box);//框架添加盒子

        //最下侧的横向盒子
        Box box3 = Box.createHorizontalBox();
        box3.add(jTextField);
        box3.add(btn);
        jFrame.add(box3,BorderLayout.SOUTH);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new  SwingComponentDemo().init();
    }

    private void changeFlavor(String flavor) throws Exception {
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
        SwingUtilities.updateComponentTreeUI(jPopupMenu);
        SwingUtilities.updateComponentTreeUI(jMenuBar);
    }
}
