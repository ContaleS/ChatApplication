package client.view;

import client.controller.SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static client.Client.out;

public class SignUpForm extends JFrame{
    SignUp signUp = client.controller.SignUp.getInstance();
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField repeatPasswordField;
    private JButton signUpButton;
    private String username;
    private String password;
    private String repeatPassword;

    private static SignUpForm instance;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
    public void announce(String message){
        if(message.equals("1")) {
            JOptionPane.showMessageDialog(SignUpForm.this, "dang ky tai khoan thanh cong");
            setVisible(false);
            client.view.LoginForm.getInstance().setVisible(true);
        }
        else JOptionPane.showMessageDialog(SignUpForm.this, "ten dang nhap da ton tai");
    }
    private SignUpForm() {
        // Set up the user interface
        setTitle("Sign Up Form");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        JLabel repeatPasswordLabel = new JLabel("Repeat Password:");
        repeatPasswordField = new JPasswordField(20);
        JButton signUpButton = new JButton("Sign Up");
        JButton loginButton = new JButton("login");
        // Set layout
        setLayout(new GridLayout(5, 2));
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(repeatPasswordLabel);
        add(repeatPasswordField);
        add(new JLabel());
        add(signUpButton);
        add(new JLabel());
        add(loginButton);

        // Event handling for the signup button
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUsername(usernameField.getText());
                setPassword(new String(passwordField.getPassword()));
                setRepeatPassword(new String(repeatPasswordField.getPassword()));

                if (username.equals("")|| password.equals("")|| repeatPassword.equals("")){
                    JOptionPane.showMessageDialog(SignUpForm.this,"username or password or repeatPassword is empty!");
                }
                else{
                    if(!password.equals(repeatPassword)) {
                        JOptionPane.showMessageDialog(SignUpForm.this, "password and repeatPassword is not equal!");
                    }
                    else {
                        String message = signUp.sendSignUp(username, password);
                        out.println(message);
                    }
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.view.LoginForm.getInstance().setVisible(true);
                client.view.SignUpForm.getInstance().setVisible(false);
            }
        });
        setVisible(true);
    }
    public static SignUpForm getInstance(){
        if (instance == null) instance = new SignUpForm();
        return instance;
    }
}
