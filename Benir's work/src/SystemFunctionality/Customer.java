package SystemFunctionality;

import PageUI.QuantPage;

import javax.swing.*;
import java.sql.*;

public class Customer extends User {

    private Integer userNo;
    private Double Tokens;

    public Customer(Integer customerId,String name, String email, String password, Integer userNo,Double Tokens) {
        super(customerId,name, email, password);
        this.userNo = userNo;
        this.Tokens=Tokens;
    }


    //Use a sql query to retrieve token amount (probably)
    @Override
    void checkTokens() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user_db",
                    "root",
                    "ManCity@254"
            );
            int customer_id=this.UserId;
            if (customer_id==this.UserId){
                String sqlStatement="SELECT customer_tokens FROM customers ";
                PreparedStatement stmt=conn.prepareStatement(sqlStatement);
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
            else{
                JOptionPane.showMessageDialog(null,"Enter correct customer ID");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    void makePayment() {

    }
}
