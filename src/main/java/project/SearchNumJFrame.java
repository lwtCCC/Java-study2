package project;

import swingDemo.DefaultListModelTest;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SearchNumJFrame{

    int tempLength, max, tempTime, rows = 4, cols = 5;
    boolean stopFlag = false;
    Thread currentThread;

    int[] startArr = {20,100,500};

    JFrame jFrame = new JFrame("随机数序列查找重复值，动态演示");

    //文本创建
    JTextField lengthText = new JTextField(5);
    JTextField rangeText = new JTextField(5);
    JTextField sleepTime = new JTextField(5);

    //按钮创建
    JButton createBtn = new JButton("生成");
    JButton searchBtn = new JButton("查找重复值");
    JButton addColorBtn = new JButton("添加颜色");

    //下半组件
    JScrollPane jScrollPane = new JScrollPane();
    JPanel numberPanel = new JPanel(new GridLayout(4,5));

    Random random = new Random();

    //默认随机数数组
    int[] arr = new int[20];

    //存放对应的容器
    JLabel[] jLabels = new JLabel[arr.length];

    //创建分割条
    JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jScrollPane,numberPanel);

    //颜色列表框
    DefaultListModel<Color> model = new DefaultListModel<>();
    JList<Color> jList = new JList<>(model);

    //右键弹出选项
    JPopupMenu jPopupMenu = new JPopupMenu();
    JMenuItem deleted = new JMenuItem("删除选中多项");
    JMenuItem open = new JMenuItem("打开");
    JMenuItem save = new JMenuItem("保存");

    //过滤器
    FileNameExtensionFilter f = new FileNameExtensionFilter("文本文件（*.txt）","txt");

    //文件选择对话框
    JFileChooser jFileChooser = new JFileChooser("./src/main/java/project/color.txt");

    private void createArr() {
        stopFlag = false;
        currentThread = null;

        tempTime = test(sleepTime, 2);
        cols = Math.max(tempLength / 4, 5);
        numberPanel.removeAll();
        numberPanel.setLayout(new GridLayout(4, cols));

        currentThread = new Thread(new MyThread(tempTime, tempLength));
        currentThread.start();
    }

    //创建长度为x的全0数组，并填充jLabels数组
    private void initCreateArr(int x) {
        for (int i = 0; i < x; i++) {
            JLabel jLabel = new JLabel( "0");
            jLabel.setBorder(new BevelBorder(1));
            jLabel.setVerticalAlignment(JLabel.CENTER);
            jLabel.setHorizontalAlignment(JLabel.CENTER);
            jLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
            numberPanel.add(jLabel);
            jLabels[i] = jLabel;
        }
    }

    private void stopThread() {
        if (currentThread != null && currentThread.isAlive()) {
            stopFlag = true;
            currentThread.interrupt();

            try {
                currentThread.join(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    //动态演示
    private class MyThread implements Runnable{
        int time;
        int arrLength;

        public MyThread(int tempTime,int tempLength){
            this.time = tempTime;
            this.arrLength = tempLength;
        }

        @Override
        public void run() {
            initCreateArr(arrLength);

            for(int i=0;i<arrLength;i++){
                if(stopFlag){
                    return;
                }

                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    return;
                }

                jLabels[i].setText(arr[i] + "");
                numberPanel.revalidate();
                numberPanel.repaint();
            }
        }
    }

    //数据检测
    private int test(JTextField jTextField,int x){
        int temp = 0;
        if(jTextField.getText().isEmpty()){
            temp = startArr[x];
        } else if ("0".equals(jTextField.getText()) && x != 2) {
            JOptionPane.showMessageDialog(jFrame,"违规数据","错误发生",JOptionPane.ERROR_MESSAGE);
            jTextField.setText("");
        } else{
            try {
                temp = Integer.parseInt(jTextField.getText());//获取长度
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(jFrame,"请输入合法数据","错误发生",JOptionPane.ERROR_MESSAGE);
                jTextField.setText("");
            }
        }
        return temp;
    }

    //新建渲染器
    private class ColorCellRenderer extends JPanel implements ListCellRenderer<Color> {
        private String color;
        private ImageIcon icon;
        private MyColor myColor;

        private Color background;
        private Color foreground;

        @Override
        public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index, boolean isSelected, boolean cellHasFocus) {
            myColor = (MyColor) value;
            this.color = myColor.toString();
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
            g.drawImage(icon.getImage(), 10, 10, null);
            g.setColor(myColor);
            g.drawString(this.color,10+icon.getIconWidth()+5,height/2+3);
        }
    }

    private void init(){

        jFileChooser.setFileFilter(f);

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

        //文本设置
        lengthText.setHorizontalAlignment(JTextField.CENTER);
        rangeText.setHorizontalAlignment(JTextField.CENTER);
        sleepTime.setHorizontalAlignment(JTextField.CENTER);

        //左侧的数字展示
        initCreateArr(arr.length);

        //生成
        createBtn.addActionListener(e -> {

            stopThread();

            tempLength = test(lengthText,0);
            max = test(rangeText,1);

            arr = new int[tempLength];//生成全0数组
            jLabels = new JLabel[arr.length];
            for (int i = 0; i < arr.length; i++) {
                int temp = 0;
                try {
                    temp = random.nextInt(max);
                } catch (Exception ex) {
                    //throw new RuntimeException(ex);
                }
                arr[i] = temp;
            }
            createArr();
        });

        //颜色查找
        searchBtn.addActionListener(e -> {
            if(currentThread != null && currentThread.isAlive()){
                JOptionPane.showMessageDialog(jFrame,"数据正在生成中，请稍等");
                return;
            }

            MyColor[] colorArray = new MyColor[model.size()];
            for (int i = 0; i < model.size(); i++) {
                colorArray[i] = (MyColor) model.get(i);
            }

            Map<Integer, MyColor> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    MyColor s = map.get(arr[i]);
                    jLabels[i].setForeground(s);
                }else{
                    int temp = i%colorArray.length;
                    map.put(arr[i],colorArray[temp]);
                    jLabels[i].setForeground(colorArray[temp]);
                }
            }
        });

        //添加颜色
        addColorBtn.addActionListener(e -> {
            Color color = JColorChooser.showDialog(jFrame, "颜色选择", null);
            if (color != null) {
                MyColor myColor = new MyColor(color);
                model.addElement(myColor);
            }
        });

        //自定义列表框
        jList.setCellRenderer( new ColorCellRenderer());
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //模型初始化
        model.addElement(new MyColor(Color.RED));
        model.addElement(new MyColor(Color.ORANGE));
        model.addElement(new MyColor(Color.YELLOW));
        model.addElement(new MyColor(Color.GREEN));
        model.addElement(new MyColor(Color.BLUE));
        model.addElement(new MyColor(Color.CYAN));
        model.addElement(new MyColor(Color.MAGENTA));

        //删除
        deleted.addActionListener(e -> {
            List<Color> selectList = jList.getSelectedValuesList();

            for (Color color : selectList) {
                model.removeElement(color);
            }
        });

        //打开功能
        open.addActionListener(e -> {
            jFileChooser.showOpenDialog(jFrame);

            try {
                File selectedFile = jFileChooser.getSelectedFile();
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile));
                model = (DefaultListModel)ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException | NullPointerException ex) {
                //throw new RuntimeException(ex);
            }
            jList.removeAll();
            jList.setModel(model);
            jList.repaint();
        });

        //保存功能
        save.addActionListener(e -> {
            jFileChooser.showSaveDialog(jFrame);

            try {
                File selectedFile = jFileChooser.getSelectedFile();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile));
                oos.writeObject(model);
                oos.close();
            } catch (IOException | NullPointerException ex) {
                //throw new RuntimeException(ex);
            }
        });

        //菜单栏
        jPopupMenu.add(deleted);
        jPopupMenu.add(open);
        jPopupMenu.add(save);

        //菜单项关联
        jList.setComponentPopupMenu(jPopupMenu);
        jList.setVisibleRowCount(3);

        //分割条的初始设置
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setContinuousLayout(true);

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

    public static void main(String[] args) {
        new  SearchNumJFrame().init();
    }
}