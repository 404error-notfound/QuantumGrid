package SystemFunctionality;

import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class DatabaseConnection implements Connectable{
    private PaymentService serviceName;
    private static final Double  initialTokenAmount=100.00;
    static String[] firstNames = {"John", "Jane", "Alex", "Emily", "Chris", "Sara", "Michael", "Nina", "David", "Lily",
            "Brian", "Grace", "Elijah", "Olivia", "James", "Aisha", "Daniel", "Chloe", "Samuel", "Zoe",
            "Kevin", "Laura", "Peter", "Naomi", "Victor", "Angela", "Dennis", "Brenda", "George", "Irene"};
    static String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Wilson", "Anderson",
            "Ochieng", "Kamau", "Mutiso", "Otieno", "Mwangi", "Kariuki", "Cheruiyot", "Wanjiru", "Barasa", "Okello",
            "Mburu", "Wambui", "Odhiambo", "Ndungu", "Kiplagat", "Makori", "Wanyama", "Nyambura", "Lemayian", "Njoroge"};
    static String[] fPasswords={"39xg8","w0djg","9fys","d9ufhu","3oirhs","dsiug48o","fgs439s","0sg-sd","d0ag94"};
    static String[] lPasswords={"d0a4risa","0asi","doiiag09","djaghgi","durtdla","asdy8we45","d974t","sdg88u","dhapidg90"};
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
            int id = resultSet.getInt("user_id");                // column name: "id"
            String name = resultSet.getString("user_name");      // column name: "name"
            String email = resultSet.getString("user_email");    // column name: "email"
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
            JOptionPane.showMessageDialog(null,"Customer with ID "+customerId+" has "+customer_tokens+ " tokens");
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Email or Password input");
        }
        resultSet.close();
        stmt2.close();
        conn.close();
    }
    public void savetoDatabase(Customer customer) throws SQLException{
        Connection conn=this.getConnection();
        String sqlUserInsertion ="INSERT INTO users (user_name,user_email,password,house_no) VALUES (?,?,?,?)";
        PreparedStatement statement1 =conn.prepareStatement(sqlUserInsertion,Statement.RETURN_GENERATED_KEYS);
        statement1.setString(1,customer.getName());
        statement1.setString(2,customer.getEmail());
        statement1.setString(3,customer.getPassword());
        statement1.setString(4,customer.getHouseNo());
        statement1.executeUpdate();
        ResultSet generatedKeys= statement1.getGeneratedKeys();

        if (generatedKeys.next()) {
            customer.id=generatedKeys.getInt(1);
//            JOptionPane.showMessageDialog(null,"Customer added with ID: "+customer.id);
        }
        String sqlCustomerInsertion ="INSERT INTO customers (customer_id,customer_tokens) VALUES (?,?)";
        PreparedStatement statement2=conn.prepareStatement(sqlCustomerInsertion);
        statement2.setInt(1,customer.id);
        statement2.setDouble(2,customer.getTokens());
        statement2.executeUpdate();
        statement1.close();
        statement2.close();
        System.out.println("customer saved");
    }

    public void updateTokens(Connection connection,Double customerTokens,Integer customerId) throws SQLException{
        String sqlStatement="UPDATE customers SET customer_tokens =? WHERE customer_id=? ";
        PreparedStatement stmt=connection.prepareStatement(sqlStatement);
        stmt.setDouble(1,customerTokens);
        stmt.setDouble(2,customerId);
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

        Random random=new Random();
        for (int i=0;i<100;i++){
            String first = firstNames[random.nextInt(firstNames.length)];
            String last = lastNames[random.nextInt(lastNames.length)];
            String fullName = first + " " + last;
            String gmail=first.toLowerCase()+last.toLowerCase()+"@mail.com";
            String fPassword=fPasswords[random.nextInt(fPasswords.length)];
            String lPassword=lPasswords[random.nextInt(lPasswords.length)];
            String password=fPassword+lPassword;
            System.out.println((i + 1) + ". " + fullName+"-> "+gmail);
            Customer customer=createCustomer(fullName,gmail,password);
        }

    }

    private static  Customer createCustomer(String name,String email,String password) throws SQLException {
        PaymentService creditCard=new PaymentService("MPESA");
        DatabaseConnection OpenAIDbase=new DatabaseConnection(creditCard);
        Random random=new Random();
        char prefix=(char) (random.nextInt(23)+'A');
        int number=random.nextInt(999)+1;

        String suffix=String.format("%03d",number);
        String houseNumber=prefix+suffix;

        Customer customer = new Customer(name,email,password,houseNumber,initialTokenAmount,creditCard,OpenAIDbase);
        OpenAIDbase.savetoDatabase(customer);
        return customer;

    }


}
