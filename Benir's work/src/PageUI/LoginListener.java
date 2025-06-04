package PageUI;

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


        JFrame LoginFrame=new JFrame("Login Form");

        LoginFrame.setSize(500,400);
        LoginFrame.setLayout(null);

        JLabel nameLabel=new JLabel("Name");
        JLabel emailLabel=new JLabel("Email");
        JLabel passwordLabel=new JLabel("Password");

        JTextField nameField=new JTextField();
        JTextField emailField=new JTextField();
        JPasswordField passwordField1=new JPasswordField();

        nameLabel.setBounds(200,10,80,25);
        emailLabel.setBounds(200,40,80,25);
        passwordLabel.setBounds(175,80,80,25);

        nameField.setBounds(250,10,80,25);
        emailField.setBounds(250,40,80,25);
        passwordField1.setBounds(250,80,80,25);

        LoginFrame.add(nameLabel);
        LoginFrame.add(nameField);
        LoginFrame.add(emailLabel);
        LoginFrame.add(emailField);
        LoginFrame.add(passwordLabel);
        LoginFrame.add(passwordField1);

        JButton submitButton=new JButton("Submit");
        submitButton.setBounds(250,120,80,25);


        LoginFrame.setVisible(true);
        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginFrame.add(submitButton);
        submitButton.addActionListener(new SubmitListener(nameField,emailField,passwordField1));

        parent.setVisible(false);
    }
}
