import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SubmitButtonListener implements ActionListener {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JFrame frame;

    public SubmitButtonListener(JTextField nameField, JTextField emailField, JPasswordField passwordField, JFrame frame){
        this.nameField =nameField;
        this.emailField=emailField;
        this.passwordField=passwordField;
        this.frame=frame;
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
            //We then close the connection
            statement.close();
            conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("An error occurred in connection");

        }

    }
}
