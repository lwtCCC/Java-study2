package project.projcet1;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class SearchNumJFrame1 {

    private final BaseJFrame baseJFrame = new BaseJFrame(new JFrame("随机数序列查找重复值，动态演示"));

    private final JTextField lengthText = new JTextField(5);
    private final JTextField rangeText = new JTextField(5);
    private final JTextField sleepTime = new JTextField(5);

    private final JButton createBtn = new JButton("生成");
    private final JButton searchBtn = new JButton("查找重复值");
    private final JButton addColorBtn = new JButton("添加颜色");

    private final JScrollPane scrollPane = new JScrollPane();
    @Getter
    private final JPanel jPanel = new JPanel();

    //颜色列表框
    DefaultListModel<Color> model = new DefaultListModel<>();
    JList<Color> jList = new JList<>(model);

    @Getter
    private final int[] zeroArr = new int[20];

    private int[] saveArr;

    MyColor[] myColors = {new MyColor(Color.red),new MyColor(Color.orange),new MyColor(Color.yellow),
            new MyColor(Color.green), new MyColor(Color.blue), new MyColor(Color.cyan),new  MyColor(Color.magenta)};

    private int row=4;
    private int col=5;

    @Getter
    private ArrayList<JLabel> jLabels = new ArrayList<>();

    private Thread currentThread;
    @Getter
    private boolean stopFlag = false;

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

    private final int[] startArr = {20,100,500};

    private int test(JTextField jTextField,int x){
        JFrame jFrame = baseJFrame.getJFrame();
        int temp = 0;
        if(jTextField.getText().isEmpty()){
            temp = startArr[x];
        } else if (("0".equals(jTextField.getText()) && x != 2) || jTextField.getText().startsWith("-")) {
            JOptionPane.showMessageDialog(jFrame,"违规数据","错误发生",JOptionPane.ERROR_MESSAGE);
            jTextField.setText("");
            temp = -1;
        } else{
            try {
                temp = Integer.parseInt(jTextField.getText());//获取长度
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(jFrame,"请输入合法数据","错误发生",JOptionPane.ERROR_MESSAGE);
                jTextField.setText("");
                temp = -1;
            }
        }

        return temp;
    }

    public void createNumTable(int[] arr,int row,int col) {
        initData(row,col);
        for (int i : arr) {
            JLabel jLabel = new JLabel(i + "");
            jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
            jLabel.setVerticalAlignment(JLabel.CENTER);
            jLabel.setHorizontalAlignment(JLabel.CENTER);
            jLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
            jPanel.add(jLabel);
            jLabels.add(jLabel);
        }
        jPanel.revalidate();
        jPanel.repaint();
    }

    private int[] createRandArr(int length,int arrLength,int max){
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            if (i < arrLength) {
                    arr[i] = random.nextInt(max);
            }else{
                arr[i] = 0;
            }
        }
        return arr;
    }

    private void initData(int row, int col) {
        jLabels.clear();
        jPanel.removeAll();
        jPanel.setLayout(new GridLayout(row,col));

    }

    private final JMenuItem delete = new JMenuItem("删除选中多项");
    private final JMenuItem open = new JMenuItem("打开(完全更改)");
    private final JMenuItem openAdd = new JMenuItem("打开(追加)");
    private final JMenuItem save = new JMenuItem("保存");
    private final JMenuItem load  = new JMenuItem("读取文件");
    private final JMenuItem saveNum  = new JMenuItem("保存文件");
    private final JMenuItem saveAddNum  = new JMenuItem("追加保存文件");
    private final JFileChooser colorFileChooser = new JFileChooser("./src/main/java/project/color.txt");
    private final JFileChooser numFileChooser = new JFileChooser("./src/main/java/project/color.txt");
    private final FileNameExtensionFilter f = new FileNameExtensionFilter("文本文件（*.txt）","txt");

    private void initJPopupMenu() {
        baseJFrame.createPopupJMenu(jList,delete,open,openAdd,save);
        baseJFrame.createPopupJMenu(jPanel,load,saveNum,saveAddNum);
    }

    private void getRowAndCol(int length) {
        int sqrt = (int)Math.sqrt(length);
        if(sqrt * sqrt == length) row=col=sqrt;
        else if (Math.sqrt(length) - sqrt >= 0.5){
            row=col=sqrt+1;
        } else {
            row = sqrt;
            col = sqrt+1;
        }
    }

    private void initAction() {
        createBtn.addActionListener(_ -> createBtnAction());
        searchBtn.addActionListener(_ -> searchBtnAction());
        addColorBtn.addActionListener(_ -> addColorBtnAction());
        delete.addActionListener(_ -> deleteAction());
        open.addActionListener(_ -> openAction(true));
        openAdd.addActionListener(_ -> openAction(false));
        //save.addActionListener(e -> saveAction());
        save.addActionListener(this::saveAction);
        load.addActionListener(_ -> loadAction());
        saveNum.addActionListener(e -> saveNumAction(false));
        saveAddNum.addActionListener(e -> saveNumAction(true));
        btn1.addActionListener(this::changeAtion);
        btn2.addActionListener(this::changeAtion);
        btn3.addActionListener(this::changeAtion);
        btn4.addActionListener(this::changeAtion);
        btn5.addActionListener(this::changeAtion);
    }

    private void saveNumAction(boolean f) {
        numFileChooser.showSaveDialog(baseJFrame.getJFrame());
        StringBuilder sb = new StringBuilder();
        for (int i : saveArr) {
            sb.append(i).append(",");
        }
        String s = sb.toString();
        try {
            File selectedFile = numFileChooser.getSelectedFile();
            if(!selectedFile.toString().endsWith(".txt")){
                selectedFile = new File(selectedFile +".txt");
            }
            FileOutputStream fos = new FileOutputStream(selectedFile, f);
            fos.write(s.getBytes());
            fos.close();
        } catch (IOException | NullPointerException ex) {
            //throw new RuntimeException(ex);
        }
    }

    private void loadAction() {
        int tempSleepTime = test(sleepTime,2);
        if (tempSleepTime == -1) {
            return;
        }
        numFileChooser.showOpenDialog(baseJFrame.getJFrame());
        List<String> list = getNumStrLst();
        System.out.println(list);
        getRowAndCol(list.size());
        int[] array = list.stream().mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.copyOf(array, row * col);

        stopThread();
        stopFlag = false;
        currentThread = new Thread(new MyThread(tempSleepTime,row,col,arr,this));
        currentThread.start();
    }

    private List<String> getNumStrLst() {
        List<String> list = new ArrayList<>();
        try {
            File selectedFile = numFileChooser.getSelectedFile();
            FileInputStream fis = new FileInputStream(selectedFile);
            int r;
            StringBuilder sb = new StringBuilder();
            while ((r = fis.read()) != -1) {
                sb.append((char) r);
            }
            fis.close();
            String s = sb.toString();
            list = Arrays.stream(s.split("[,，、\n\r]+")).map(String::trim).toList();
        }catch (Exception _){
        }
        return list;
    }

    private void saveAction() {
        colorFileChooser.showSaveDialog(baseJFrame.getJFrame());
        try {
            File selectedFile = colorFileChooser.getSelectedFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile));
            oos.writeObject(model);
            oos.close();
        } catch (IOException | NullPointerException ex) {
            //throw new RuntimeException(ex);
        }
    }

    private void saveAction(ActionEvent e) {
        colorFileChooser.showSaveDialog(baseJFrame.getJFrame());
        try {
            File selectedFile = colorFileChooser.getSelectedFile();
            if(!selectedFile.toString().endsWith(".txt")){
                selectedFile = new File(selectedFile +".txt");
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile));
            oos.writeObject(model);
            oos.close();
        } catch (IOException | NullPointerException ex) {
            //throw new RuntimeException(ex);
        }
    }

    private void openAction(boolean f) {
        colorFileChooser.showOpenDialog(baseJFrame.getJFrame());
        DefaultListModel<Color> model2 = new DefaultListModel<>();
        try {
            File selectedFile = colorFileChooser.getSelectedFile();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile));
            model2 = (DefaultListModel<Color>)ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException | NullPointerException ex) {
            //throw new RuntimeException(ex);
        }
        if(f){
            model = model2;
        }else{
            baseJFrame.addModel(model,model2);
        }
        jList.removeAll();
        jList.setModel(model);
        jList.repaint();
    }

    private void deleteAction() {
        List<Color> selectList = jList.getSelectedValuesList();
        for (Color color : selectList) {
            model.removeElement(color);
        }
    }

    private void addColorBtnAction() {
        Color color = JColorChooser.showDialog(baseJFrame.getJFrame(), "颜色选择", null);
        if (color != null) {
            MyColor myColor = new MyColor(color);
            model.addElement(myColor);
        }
    }

    private void searchBtnAction() {
        int ok = stopAndSelect();
        if(ok != 0){
            return;
        }
        if(currentThread != null && currentThread.isAlive()){
            JOptionPane.showMessageDialog(baseJFrame.getJFrame(),"数据正在生成中，请稍等");
            return;
        }

        MyColor[] colorArray = new MyColor[model.size()];
        for (int i = 0; i < model.size(); i++) {
            colorArray[i] = (MyColor) model.get(i);
        }

        Map<Integer, MyColor> map = new HashMap<>();
        for (int i = 0; i < row*col; i++) {
            int jLabelNum = Integer.parseInt(jLabels.get(i).getText());
            if (map.containsKey(jLabelNum)) {
                MyColor s = map.get(jLabelNum);
                jLabels.get(i).setForeground(s);
            }else{
                int temp = i%colorArray.length;
                map.put(jLabelNum,colorArray[temp]);
                jLabels.get(i).setForeground(colorArray[temp]);
            }
        }
    }

    private void createBtnAction() {
        int ok = stopAndSelect();
        if(ok != 0){
            return;
        }
        int tempLength = test(lengthText,0);
        int max = test(rangeText,1);
        int tempSleepTime = test(sleepTime,2);
        if (tempLength == -1 || max == -1 || tempSleepTime == -1) {
            return;
        }

        stopThread();
        getRowAndCol(tempLength);
        int[] randArr = createRandArr(row * col, tempLength,max);
        saveArr = randArr;
        for (int i = 0; i < randArr.length; i++) {
            System.out.print(randArr[i]+"");
        }
        stopFlag = false;
        currentThread = new Thread(new MyThread(tempSleepTime,row,col,randArr,this));
        currentThread.start();
    }

    private int stopAndSelect(){
        int i = JOptionPane.showOptionDialog(baseJFrame.getJFrame(), "确定要选择吗", "ok?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        System.out.println(i);
        return i;
    }

    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final JRadioButton btn1 = new JRadioButton("Metal 风格");
    private final JRadioButton btn2 = new JRadioButton("Nimbus 风格");
    private final JRadioButton btn3 = new JRadioButton("Windows 风格",true);
    private final JRadioButton btn4 = new JRadioButton("Windows 经典风格");
    private final JRadioButton btn5 = new JRadioButton("Motif 风格");

    public SearchNumJFrame1(){
        initAction();
        initJPopupMenu();
        BaseJFrame.setTextCenter(lengthText,rangeText,sleepTime);
        colorFileChooser.setFileFilter(f);
        numFileChooser.setFileFilter(f);
        //顶部
        Box box = Box.createHorizontalBox();
        baseJFrame.addBox(box,3,new JLabel("长度"),lengthText,
                new JLabel("范围"),rangeText,new JLabel("sleepTime"),sleepTime,createBtn,searchBtn,addColorBtn);

        //中间右
        createNumTable(zeroArr,row,col);

        //中间左
        jList.setCellRenderer(new ColorCellRenderer());
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jList.setVisibleRowCount(5);

        baseJFrame.initModel(model,myColors);

        TitledBorder titleBorder = BorderFactory.createTitledBorder(new EtchedBorder(Color.black, Color.cyan),
                "颜色", TitledBorder.LEFT, TitledBorder.CENTER);
        scrollPane.setBorder(titleBorder);
        scrollPane.setViewportView(jList);
        jPanel.setPreferredSize(new Dimension(450,280));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, jPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);

        Box verticalBox = Box.createVerticalBox();
        BaseJFrame.addButtonGroup(buttonGroup,btn1,btn2,btn3,btn4,btn5);
        baseJFrame.addBox(verticalBox,btn1,btn2,btn3,btn4,btn5);

        JFrame jFrame = baseJFrame.getJFrame();
        jFrame.add(box,BorderLayout.NORTH);
        jFrame.add(verticalBox,BorderLayout.WEST);
        jFrame.add(splitPane,BorderLayout.CENTER);
        baseJFrame.initJFrame();
    }

    private void changeAtion(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        try {
            baseJFrame.changeFlavor(actionCommand,baseJFrame.getJFrame());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        new SearchNumJFrame1();
    }
}