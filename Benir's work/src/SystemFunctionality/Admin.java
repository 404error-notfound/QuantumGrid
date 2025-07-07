package SystemFunctionality;

import java.sql.Connection;
import java.sql.SQLException;

public class Admin {
    public void checkAllUsers(PaymentService serviceType) throws SQLException {
        Connection validateConnection=serviceType.getConnection();
        DatabaseConnection.checkAllUsers(validateConnection);
    }
}
