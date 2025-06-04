package PageUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SubmitListener extends ButtonListener {


    public SubmitListener(JTextField nameField, JTextField emailField, JPasswordField passwordField) {
        super(nameField, emailField, passwordField);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user_db",
                    "root",
                    "ManCity@254"
            );
            String userName=nameField.getText();
            String inputEmail=emailField.getText();
            String inputPassword=new String(passwordField.getPassword());
            //We then prepare a sql query
            String sqlStatement="SELECT * FROM users WHERE email= ? AND password= ?";
            PreparedStatement stmt=conn.prepareStatement(sqlStatement);

            stmt.setString(1,inputEmail);
            stmt.setString(2,inputPassword);

            //We then execute the query
            ResultSet rs=stmt.executeQuery();

            //Check if a user was found

            if (rs.next()){
                String name=rs.getString("name");
                JOptionPane.showMessageDialog(null,"Welcome to Quantum Grid, "+name);
                JFrame homePage=new JFrame("QG Home Page");
                new QuantPage(homePage).OpenQuantPage();


            }else{
                JOptionPane.showMessageDialog(null,"Invalid Email or Password input");
            }

            //Close connections
            rs.close();
            stmt.close();
            conn.close();



        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
