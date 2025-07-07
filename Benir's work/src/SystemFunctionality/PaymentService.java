package SystemFunctionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PaymentService implements Connectable {
    private final String serviceName;

    public PaymentService(String serviceName){
        this.serviceName=serviceName;
    }
    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user_db",
                "root",
                "ManCity@254"
        );
    }
}
