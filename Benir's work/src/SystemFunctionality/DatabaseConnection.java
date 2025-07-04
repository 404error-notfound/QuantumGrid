package SystemFunctionality;

import javax.swing.*;
import java.sql.*;

public class DatabaseConnection implements Connectable{
    private PaymentService serviceName;
    public DatabaseConnection(PaymentService serviceObject){
        this.serviceName=serviceObject;
    }


    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection conn= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user_db",
                "root",
                "ManCity@254"
        );
        return conn;
    }
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
    public void savetoDatabase(Customer customer) throws SQLException{
        Connection conn=this.getConnection();
        String sql="INSERT INTO token_users (user_name,user_email,password,house_no) VALUES (?,?,?,?)";
        PreparedStatement statement=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,customer.getName());
        statement.setString(2,customer.getEmail());
        statement.setString(3,customer.getPassword());
        statement.setString(4,customer.getHouseNo());
        statement.executeUpdate();
        ResultSet generatedKeys=statement.getGeneratedKeys();

        if (generatedKeys.next()) {
            customer.id=generatedKeys.getInt(1);
            JOptionPane.showMessageDialog(null,"Customer added with ID"+customer.id);
        }
        statement.close();
        System.out.println("customer saved");
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

        PaymentService creditCard=new PaymentService("MPESA");
        DatabaseConnection OpenAIDbase=new DatabaseConnection(creditCard);
        Customer c1= new Customer(1,"Benir Odeny",
                "b@company.com",
                "abcdef","H3V18",
                150.00,creditCard,OpenAIDbase);
        Customer c2= new Customer("Kenya","K@mail.com","374ske","ZH143",500.00,creditCard,OpenAIDbase);
//
        OpenAIDbase.savetoDatabase(c2);
//        c1.checkTokens();
//        c1.makePayment(3000.00);
//        c1.checkTokens();
//        Admin a1=new Admin();
//        a1.checkAllUsers(creditCard);
//        c1.makePayment(3000.00);
//        c1.checkTokens();
//        c1.makePayment(3000.00);
//        c1.checkTokens();
//        SystemManagement company1=new SystemManagement();
//        company1.verifyTokens(c1);
//        company1.checkUserData(new Admin());
        //Probably create a method that:
        /*
        Once logged in to a database, the customer is instantiated
         */
    }


}
