package SystemFunctionality;

import javax.swing.*;
import java.sql.*;

public class DatabaseConnection {
    public static void checkAllUsers(Connection conn) throws SQLException{
        String sqlQuery="SELECT * FROM users";
        PreparedStatement statement=conn.prepareStatement(sqlQuery);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");                // column name: "id"
            String name = resultSet.getString("name");      // column name: "name"
            String email = resultSet.getString("email");    // column name: "email"
            System.out.println("User: " + id + ", " + name + ", " + email);
        }
        resultSet.close();
        statement.close();
    }
    public void checkTokenColumn(Connection conn, Integer customerId,Double Tokens) throws SQLException {
        String sqlStatement1= "UPDATE customers SET customer_tokens=? WHERE customer_id=?";
        PreparedStatement stmt1=conn.prepareStatement(sqlStatement1);
        stmt1.setDouble(1, Tokens);
        stmt1.setInt(2, customerId);
        System.out.println(Tokens);

        stmt1.executeUpdate();
        stmt1.close();

        String sqlStatement2 ="SELECT customer_tokens FROM customers WHERE customer_id=?";
        PreparedStatement stmt2 =conn.prepareStatement(sqlStatement2);
        stmt2.setInt(1,customerId);
        ResultSet resultSet= stmt2.executeQuery();
        if (resultSet.next()){
            String customer_tokens=resultSet.getString("customer_tokens");
            JOptionPane.showMessageDialog(null,"You have "+customer_tokens+ " tokens");
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Email or Password input");
        }
        resultSet.close();
        stmt2.close();
        conn.close();
    }

    public void updateTokens(Connection connection,Double customerTokens,Integer customerId) throws SQLException{
        String sqlStatement="UPDATE customers SET customer_tokens =? WHERE customer_id=? ";
        PreparedStatement stmt=connection.prepareStatement(sqlStatement);
        stmt.setDouble(1,customerTokens);
        stmt.setInt(2,customerId);
        int rowsUpdated=stmt.executeUpdate();
        if (rowsUpdated>0){
            JOptionPane.showMessageDialog(null,"Customers Tokens Updated Successfully");
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Email or Password input");
        }
        stmt.close();
        connection.close();

    }

    public static void main(String[] args) throws SQLException {
        DatabaseConnection OpenAIDbase=new DatabaseConnection();
        PaymentService creditCard=new PaymentService("MPESA");
        Customer c1= new Customer(1,"Benir Odeny",
                "b@company.com",
                "abcdef",101,
                150.00,creditCard,OpenAIDbase);
        c1.checkTokens();
        c1.makePayment(3000.00);
        c1.checkTokens();
        c1.makePayment(3000.00);
        c1.checkTokens();
        c1.makePayment(3000.00);
        c1.checkTokens();
        SystemManagement company1=new SystemManagement();
        company1.verifyTokens(c1);
        company1.checkUserData(new Admin());
        //Probably create a method that:
        /*
        Once logged in to a database, the customer is instantiated
         */
    }
}
