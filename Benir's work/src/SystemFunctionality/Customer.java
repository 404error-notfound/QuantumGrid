package SystemFunctionality;

import javax.swing.*;
import java.sql.*;

public class Customer extends User implements TokenSystem{

    private Double Tokens;
    private static final Double TOKEN_UNIT=20.57;

    public Customer(Integer customerId,String name, String email, String password, Integer houseNo,Double initialTokens) {
        super(customerId,name, email, password);
        this.Tokens=initialTokens;
    }
    //Use a sql query to retrieve token amount
    //This should only happen when a user is logged in to the database or a user signs in to the database.
    @Override
    public double convertToTokens(Double amount) {
        Tokens+=amount/TOKEN_UNIT;
        return Tokens;
    }
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
            DatabaseConnection selectStmt=new DatabaseConnection();
            selectStmt.checkTokenColumn(conn,customerId,customerPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void makePayment(Double amount) {
        //Let 1 token represent 20.57 ksh and 1 KWH
        //20.57 shillings -> 1 Kwh/1 token
        boolean verifyPayment=verification(amount);
        if (verifyPayment){
            JOptionPane.showMessageDialog(null,"A token requires not less than 20.57");
        }else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/user_db",
                        "root",
                        "ManCity@254"
                );
                Double customerTokens=convertToTokens(amount);
                Integer customerId=UserId;
                DatabaseConnection databaseConnection = new DatabaseConnection();
                databaseConnection.updateTokens(conn,customerTokens,customerId);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean verification(Double amount) {
        return amount < 20.57;
    }


}
