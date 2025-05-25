import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SubmitButtonListener implements ActionListener {
    private final JTextField nameField;
    private final JTextField emailField;
    private final JPasswordField passwordField;

    public static int findUserCount(User newUser){
        return newUser.getCount();
    }

    public SubmitButtonListener(JTextField nameField, JTextField emailField, JPasswordField passwordField){
        this.nameField =nameField;
        this.emailField=emailField;
        this.passwordField=passwordField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name=nameField.getText();
        String email=emailField.getText();
        String password=new String(passwordField.getPassword());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user_db",
                    "root",
                    "ManCity@254"
            );
            String sql="INSERT INTO users (name,email,password) VALUES (?,?,?)";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,password);
            //We then add the user to the database
            statement.executeUpdate();

            //System.out.println(findUserCount(newUser));
            JOptionPane.showMessageDialog(null,"User "+name+" saved successfully");
            //We then close the connection
            statement.close();
            conn.close();

            } catch (Exception ex) {
                System.out.println("An error occurred in connection");


        }

    }
}
