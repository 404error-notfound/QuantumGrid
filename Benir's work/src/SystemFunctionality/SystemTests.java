package SystemFunctionality;

import javax.swing.*;
import java.sql.*;

public class SystemTests {
    //Managing table updates
    private void UpdateTokenColumn(Connection conn, PreparedStatement stmt) throws SQLException {
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
//    public static void updateCustomerTokens(int customerId, double amount) throws ClassNotFoundException, SQLException {
//        try {
//            // Load JDBC driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Establish database connection
//            Connection conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/user_db",
//                    "root",
//                    "ManCity@254"
//            );
//
//            // Convert amount to tokens and prepare update statement
//            Double customerTokens = convertToTokens(amount);
//            String sqlStatement = "UPDATE customers SET customer_tokens = ? WHERE customer_id = ?";
//            PreparedStatement stmt = conn.prepareStatement(sqlStatement);
//
//            // Set parameters and execute update
//            stmt.setDouble(1, customerTokens);
//            stmt.setInt(2, customerId);
//            int rowsUpdated = stmt.executeUpdate();
//
//            // Show appropriate message based on update result
//            if (rowsUpdated > 0) {
//                JOptionPane.showMessageDialog(null, "Customer tokens updated successfully");
//            } else {
//                JOptionPane.showMessageDialog(null, "Invalid customer ID or no changes made");
//            }
//
//            // Clean up resources
//            stmt.close();
//            conn.close();
//        }
//    }
    public static void main(String[] args) {
        Customer c1= new Customer(1,"benir odeny","n@mail.com","abcdef",101,150.00);
        c1.checkTokens();
        c1.makePayment(3000.00);
        //Probably create a method that:
        /*
        Once logged in to a database, the customer is instantiated
         */
    }
}
