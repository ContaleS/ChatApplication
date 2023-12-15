package client.view;

import client.Client;
import client.controller.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static client.Client.*;

public class LoginForm extends JFrame {
    Login login = client.controller.Login.getInstance();
    private JTextField usernameField;
    private JPasswordField passwordField;
    private String username;
    private String password;
    private static LoginForm instance;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void announce(String message){
        if(message.equals("1")){
            JOptionPane.showMessageDialog(LoginForm.this,"dang nhap thanh cong");
            client.view.LoginForm.getInstance().setVisible(false);
            client.view.HomePage.getInstance().setVisible(true);
        }
        else JOptionPane.showMessageDialog(LoginForm.this,"ten dang nhap hoac mat khau khong dung");
    }
    private LoginForm() {
        // Thiết lập giao diện
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo các components
        JLabel usernameLabel = new JLabel("username:");
        JLabel passwordLabel = new JLabel("password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("login");
        JButton signUpButton = new JButton("sign up");

        // Thiết lập layout
        setLayout(new GridLayout(4, 2));
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Ô rỗng để căn chỉnh
        add(loginButton);
        add(new JLabel()); // Ô rỗng để căn chỉnh
        add(signUpButton);

        // Xử lý sự kiện khi nhấn nút đăng nhập
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 setUsername(usernameField.getText());
                 setPassword(new String(passwordField.getPassword()));

                if (username.equals("")|| password.equals("")){
                    JOptionPane.showMessageDialog(LoginForm.this,"username or password is empty!");
                }
                else{
                    String message = login.sendLogin(username,password);
                    out.println(message);
                }
            }
        });
        // Xử lý sự kiện khi nhấn nút đăng ký
        signUpButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.view.SignUpForm.getInstance().setVisible(true);
                client.view.LoginForm.getInstance().setVisible(false);
            }
        }));
        setVisible(true);
    }

    public static LoginForm getInstance(){
        if (instance == null) instance = new LoginForm();
        return instance;
    }
}