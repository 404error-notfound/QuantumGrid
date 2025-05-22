import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userDatabase {
    //This is a method to save the user
    public void saveUser(User user){
        String url="jdbc:mysql://localhost:3306/user_db";
        String dbUser="root";
        String dbPassword="ManCity@254";

        try {
            //We try connecting to the database
            Connection conn=DriverManager.getConnection(url,dbUser,dbPassword);
            //Creating an SQL statement
            String sql="INSERT INTO users (name, email, password) values (?,?,?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getEmail());
            stmt.setString(3,user.getPassword());

            //Execute the update
            stmt.executeUpdate();
            System.out.println("User saved successfully");
            //Close the connections
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
