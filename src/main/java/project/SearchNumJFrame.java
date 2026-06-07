package project;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SearchNumJFrame{

    JFrame jFrame = new JFrame("随机数序列查找重复值，动态演示");

    //文本创建
    JTextField lengthText = new JTextField(5);
    JTextField rangeText = new JTextField(5);
    JTextField sleepTime = new JTextField(5);

    //按钮创建
    JButton createBtn = new JButton("生成");
    JButton searchBtn = new JButton("查找重复值");
    JButton addColorBtn = new JButton("添加颜色");

    //颜色盘
    JColorChooser jColorChooser = new JColorChooser();

    //下半组件
    JScrollPane jScrollPane = new JScrollPane();
    JPanel numberPanel = new JPanel(new GridLayout(4,5));

    JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jScrollPane,numberPanel);

    //颜色列表框
    String[] colors = {"red","green","blue"};
    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> jList = new JList<>(model);

    //默认随机数数组
    int[] arr = {67, 23, 12, 45, 12, 78, 34, 91, 56, 3, 47, 82, 19, 64, 38, 72, 95, 15, 51, 88};
    //存放对应的容器
    JLabel[] jLabels = new JLabel[arr.length];

    Random random = new Random();

    //右键弹出选项
    JPopupMenu jPopupMenu = new JPopupMenu();
    JMenuItem deleted = new JMenuItem("删除选中多项");
    JMenuItem open = new JMenuItem("打开");
    JMenuItem save = new JMenuItem("保存");

    //文件选择对话框
    JFileChooser jFileChooser = new JFileChooser();

    //新建渲染器
    private class ColorCellRenderer extends JPanel implements ListCellRenderer<String> {
        private String color;
        private ImageIcon icon;

        private Color background;
        private Color foreground;

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
            this.color = value.toString();
            this.icon = isSelected?new ImageIcon("./src/main/java/project/img/select2.png")
                    :new ImageIcon("./src/main/java/project/img/select.png");

            this.background = isSelected ? list.getSelectionBackground() : list.getBackground();
            this.foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
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
            g.setColor(foreground);
            g.drawImage(icon.getImage(), 10, 10, null);

            g.drawString(this.color,10+icon.getIconWidth()+5,height/2+3);
        }
    }

    private void init(){

        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.length; i++) {
                    int temp = random.nextInt(100);
                    arr[i] = temp;
                }
                createArr();
            }
        });

        //左侧的数字展示
        createArr();

        //颜色查找
        searchBtn.addActionListener(e -> {
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    String s = map.get(arr[i]);
                    if("red".equals(s)){
                        jLabels[i].setForeground(Color.RED);
                    }
                }else{
                    map.put(arr[i],"red");
                }
            }
        });

        //模型初始化
        model.addElement("red");
        model.addElement("green");
        model.addElement("blue");

        //添加颜色
        addColorBtn.addActionListener(e -> {
            Color color = JColorChooser.showDialog(jFrame, "颜色选择", null);
            model.addElement(color.toString());
        });

        //打开功能
        open.addActionListener(e -> {
            jFileChooser.showOpenDialog(jFrame);
            File selectedFile = jFileChooser.getSelectedFile();
            System.out.println(selectedFile.toString());
        });

        //保存功能
        save.addActionListener(e -> {
            jFileChooser.showSaveDialog(jFrame);
            File selectedFile = jFileChooser.getSelectedFile();
            System.out.println(selectedFile.toString());
        });

        //菜单栏
        jPopupMenu.add(deleted);
        jPopupMenu.add(open);
        jPopupMenu.add(save);

        //菜单项关联
        jList.setComponentPopupMenu(jPopupMenu);
        jList.setVisibleRowCount(3);


        //自定义列表框
        jList.setCellRenderer( new ColorCellRenderer());
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //分割条的初始设置
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setContinuousLayout(true);

        //文本设置
        lengthText.setHorizontalAlignment(JTextField.CENTER);
        rangeText.setHorizontalAlignment(JTextField.CENTER);
        sleepTime.setHorizontalAlignment(JTextField.CENTER);

        //上半设置
        Box topBox = Box.createHorizontalBox();
        topBox.add(Box.createHorizontalStrut(3));
        topBox.add(new JLabel("长度"));
        topBox.add(Box.createHorizontalStrut(3));
        topBox.add(lengthText);
        topBox.add(Box.createHorizontalStrut(3));
        topBox.add(new JLabel("范围"));
        topBox.add(Box.createHorizontalStrut(3));
        topBox.add(rangeText);
        topBox.add(Box.createHorizontalStrut(3));
        topBox.add(new JLabel("sleeptime"));
        topBox.add(Box.createHorizontalStrut(3));
        topBox.add(sleepTime);
        topBox.add(Box.createHorizontalStrut(3));
        topBox.add(createBtn);
        topBox.add(Box.createHorizontalStrut(3));
        topBox.add(searchBtn);
        topBox.add(Box.createHorizontalStrut(3));
        topBox.add(addColorBtn);
        topBox.add(Box.createHorizontalStrut(3));

        //下半左侧设置
        TitledBorder titleBorder = BorderFactory.createTitledBorder(new EtchedBorder(Color.black, Color.cyan),
                "颜色", TitledBorder.LEFT, TitledBorder.CENTER);

        jScrollPane.setBorder(titleBorder);
        jScrollPane.setViewportView(jList);

        //框架设置
        jFrame.add(topBox, BorderLayout.NORTH);

        jFrame.add(jSplitPane);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    private void createArr() {
        numberPanel.removeAll();
        numberPanel.setLayout(new GridLayout(4, 5));
        for(int i=0;i<arr.length;i++){
            JLabel jLabel = new JLabel(arr[i] + "");
            jLabel.setBorder(new BevelBorder(1));
            jLabel.setVerticalAlignment(JLabel.CENTER);
            jLabel.setHorizontalAlignment(JLabel.CENTER);
            jLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
            numberPanel.add(jLabel);
            jLabels[i] = jLabel;
        }
        numberPanel.revalidate();
        numberPanel.repaint();
    }

    public static void main(String[] args) {
        new  SearchNumJFrame().init();
    }
}