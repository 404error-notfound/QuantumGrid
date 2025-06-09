package SystemFunctionality;

import PageUI.ButtonListener;
import PageUI.QuantPage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin extends ButtonListener implements SystemMonitor {
    Integer AdminNumber;
    public Admin(JTextField nameField, JTextField emailField, JPasswordField passwordField,User u1,Integer AdminNumber) {
        super(nameField, emailField, passwordField,u1);
        this.AdminNumber=AdminNumber;
    }


    @Override
    public void verifyTokens(Customer customer) {
        try {
            var aclass=Class.forName("com.mysql.cj.jdbc.Driver");
            var conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user_db",
                    "root",
                    "ManCity@254"
            );
            String userName=nameField.getText();
            String inputEmail=emailField.getText();
            String inputPassword=new String(passwordField.getPassword());
            //We then prepare a sql query
            String sqlStatement="SELECT customer_tokens FROM customers WHERE customer_id=? AND userNo=?";
            PreparedStatement stmt=conn.prepareStatement(sqlStatement);

            stmt.setString(1,inputEmail);
            stmt.setString(2,inputPassword);

            //We then execute the query
            ResultSet rs=stmt.executeQuery();

            //Check if a user was found

//            if (rs.next()){
//                String name=rs.getString("name");
//                JOptionPane.showMessageDialog(null,"Welcome to Quantum Grid, "+name);
//                JFrame homePage=new JFrame("QG Home Page");
//                new QuantPage(homePage).OpenQuantPage();
//
//
//            }else{
//                JOptionPane.showMessageDialog(null,"Invalid Email or Password input");
//            }

            //Close connections
            rs.close();
            stmt.close();
            conn.close();



        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void checkUserData() {

    }
}
