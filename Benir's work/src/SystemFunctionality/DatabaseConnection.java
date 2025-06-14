package SystemFunctionality;

import javax.swing.*;
import java.sql.*;

public class DatabaseConnection {
    //Managing table updates
    public void checkTokenColumn(Connection conn, Integer customerId, String customerPassword) throws SQLException {
        String sqlStatement="SELECT customer_tokens FROM customers c  JOIN users u on c.customer_id=u.id WHERE u.id=? AND u.password=?";
        PreparedStatement stmt=conn.prepareStatement(sqlStatement);
        stmt.setInt(1,customerId);
        stmt.setString(2,customerPassword);
        ResultSet resultSet= stmt.executeQuery();
        if (resultSet.next()){
            String customer_tokens=resultSet.getString("customer_tokens");
            JOptionPane.showMessageDialog(null,"You have "+customer_tokens+ " tokens");
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Email or Password input");
        }
        resultSet.close();
        stmt.close();
        conn.close();
    }
    /**
     * Updates customer tokens in the database
     *
     *  The ID of the customer to update
     *  The amount to convert to tokens and update
     * @throws ClassNotFoundException If JDBC driver is not found
     * @throws SQLException If there's an error during database operations
     */
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

    public static void main(String[] args) {
        Customer c1= new Customer(1,"benir odeny","n@mail.com","abcdef",101,150.00);
        c1.checkTokens();
        c1.makePayment(3000.00);
        c1.checkTokens();
        c1.makePayment(3000.00);
        c1.checkTokens();
        //Probably create a method that:
        /*
        Once logged in to a database, the customer is instantiated
         */
    }
}
