package SystemFunctionality;

import javax.swing.*;
import java.sql.*;

public class Customer extends User {

    private DatabaseConnection connection;
    private PaymentService service;
    private Double Tokens;
    private static final Double TOKEN_UNIT=20.57;

    public Customer(Integer customerId,String name, String email, String password,
                    Integer houseNo,Double initialTokens,String serviceName) {
        super(customerId,name, email, password);
        this.Tokens=initialTokens;
        this.service=new PaymentService(serviceName);
        this.connection=new DatabaseConnection();
    }
    //Use a sql query to retrieve token amount
    //This should only happen when a user is logged in to the database or a user signs in to the database.
    @Override
    void checkTokens() throws SQLException {
            Connection validateConnection=service.getConnection();
            connection.checkTokenColumn(validateConnection,UserId,Tokens);
    }
    @Override
    void makePayment(Double amount) {
        //Let 1 token represent 20.57 ksh and 1 KWH
        //20.57 shillings -> 1 Kwh/1 token
        VerifyPayments payment1=(payment_amount -> payment_amount<TOKEN_UNIT);
        if (payment1.verification(amount)){
            JOptionPane.showMessageDialog(null,"A token requires not less than 20.57");
        }else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/user_db",
                        "root",
                        "ManCity@254"
                );
                TokenConversion conversion1=(payment_amount -> {
                    Tokens+=payment_amount/TOKEN_UNIT;
                    return Tokens;
                });
                Double customerTokens=conversion1.convertToTokens(amount);
                DatabaseConnection databaseConnection = new DatabaseConnection();
                databaseConnection.updateTokens(conn,customerTokens,UserId);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
