package GAME1;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame() {

        initJFrame();

        initLogin();

        this.setVisible(true);
    }

    private void initLogin() {
        JLabel jLabel1 = new JLabel("用户名");
        jLabel1.setBounds(50, 100, 40, 30);

        JLabel jLabel2 = new JLabel("密码");
        jLabel2.setBounds(50, 150, 40, 30);

        JTextField jTextField1 = new JTextField();
        jTextField1.setBounds(100, 100, 300, 30);

        JPasswordField jPasswordField1 = new JPasswordField();
        jPasswordField1.setBounds(100, 150, 300, 30);

        JButton jButton1 = new JButton("登录");
        jButton1.setBorderPainted(false);
        jButton1.setBounds(150, 200, 80, 40);

        jButton1.addActionListener(e->{
            if(!jTextField1.getText().isEmpty() && !jPasswordField1.getText().isEmpty()){
                new GameJFrame();
            }else{
                JDialog jDialog = new JDialog();
                jDialog.setLayout(null);
                jDialog.setSize(200,200);
                JLabel jLabel = new JLabel("请输入用户名或密码");
                jLabel.setBounds(35, 50, 180, 50);
                jDialog.getContentPane().add(jLabel);
                jDialog.setLocationRelativeTo(null);
                jDialog.setModal(true);
                jDialog.setAlwaysOnTop(true);
                jDialog.setVisible(true);
            }
        });

        JButton jButton2 = new JButton("注册");
        jButton2.setBorderPainted(false);
        jButton2.setBounds(250, 200, 80, 40);
        jButton2.addActionListener(e->{
            new RegisterJFrame();
        });

        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jTextField1);
        this.getContentPane().add(jPasswordField1);
        this.getContentPane().add(jButton1);
        this.getContentPane().add(jButton2);
    }

    private void initJFrame() {
        this.setSize(488, 430);
        this.setTitle("Login");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
    }
}
