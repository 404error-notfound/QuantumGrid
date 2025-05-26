package Credentials;

import javax.swing.*;


public class UserForm {
    static void makeFrame(String frameName,String nameLabel,String emailLabel,String passLabel){
        //Inserting the frame and labels for input
        JFrame frame=new JFrame(frameName);
        JLabel name=new JLabel(nameLabel);
        JLabel email=new JLabel(emailLabel);
        JLabel pass=new JLabel(passLabel);

        //We then insert the fields for input
        JTextField nameField=new JTextField();
        JTextField emailField=new JTextField();
        JPasswordField passwordField=new JPasswordField();

        //We then create the submit button
        JButton submitButton=new JButton("Submit");

        //Set size of the frame
        frame.setSize(500,400);
        frame.setLayout(null);

        //We then set the size of the labels
        name.setBounds(200,40,80,25);
        email.setBounds(200,80,80,25);
        pass.setBounds(175,120,80,25);

        //We then set the size of the fields
        nameField.setBounds(250,40,100,25);
        emailField.setBounds(250,80,100,25);
        passwordField.setBounds(250,120,100,25);

        //We then set the size of the submit button
        submitButton.setBounds(250,160,80,25);

        //We then add the configured elements one by one.
        frame.add(name);
        frame.add(email);
        frame.add(pass);
        frame.add(nameField);
        frame.add(emailField);
        frame.add(passwordField);
        frame.add(submitButton);

        //We set the frame to be visible
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submitButton.addActionListener(new ButtonListener(nameField,emailField,passwordField));


    }
    public static void main(String[] args) {
        //makeFrame("User Registration","Name","Email","Password");
        JFrame frame=new JFrame("Credentials.Main Page");
        frame.setSize(500,400);
        frame.setLayout(null);

        JButton LoginButton=new JButton("Log in");
        JButton SignUpButton=new JButton("Sign up");

        LoginButton.setBounds(130,160,80,25);
        SignUpButton.setBounds(130,200,80,25);


        frame.add(LoginButton);
        frame.add(SignUpButton);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoginButton.addActionListener(new LoginListener(frame));
    }
}
