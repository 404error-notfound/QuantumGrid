package SystemFunctionality;

import PageUI.QuantPage;

import javax.swing.*;
import java.sql.*;

public class Customer extends User {

    private Integer userNo;
    private Double Tokens;
    private String customer_password;

    public Customer(Integer customerId,String name, String email, String password, Integer userNo,Double Tokens) {
        super(customerId,name, email, password);
        this.userNo = userNo;
        this.Tokens=Tokens;
    }
    //Use a sql query to retrieve token amount
    //This should only happen when a user is logged in to the database or a user signs in to the database.
    @Override
    void checkTokens() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user_db",
                    "root",
                    "ManCity@254"
            );
            Integer customerId=UserId;
            String customerPassword=Password;
            String sqlStatement="SELECT customer_tokens FROM customers c  JOIN users u on c.customer_id=u.id WHERE u.id=? AND u.password=?  ";
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
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void makePayment() {

    }
}
