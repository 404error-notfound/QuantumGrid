package Credentials;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private JFrame parent;
    public LoginListener(JFrame frame){
        this.parent=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        openLoginForm(parent);

    }

    private void openLoginForm(JFrame parent) {
//        JFrame loginFrame = new JFrame("Login Form");
//        loginFrame.setSize(300, 200);
//        loginFrame.setLayout(null);
//
//        // Add fields and buttons...
//
//        loginFrame.setVisible(true);
//        parent.setVisible(false); // Hide the previous frame if needed

        JFrame LoginFrame=new JFrame("Login Form");

        LoginFrame.setSize(500,400);
        LoginFrame.setLayout(null);

        JLabel emailLabel=new JLabel("Email");
        JLabel passwordLabel=new JLabel("Password");

        JTextField emailField=new JTextField();
        JPasswordField passwordField1=new JPasswordField();

        emailLabel.setBounds(200,40,80,25);
        passwordLabel.setBounds(175,80,80,25);

        emailField.setBounds(250,40,80,25);
        passwordField1.setBounds(250,80,80,25);

        LoginFrame.add(emailLabel);
        LoginFrame.add(emailField);
        LoginFrame.add(passwordLabel);
        LoginFrame.add(passwordField1);

        LoginFrame.setVisible(true);
        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        parent.setVisible(false);
    }
}
