package SystemFunctionality;

import java.sql.Connection;
import java.sql.SQLException;

public class Admin extends SystemManagement{
    public void checkAllUsers(String serviceName) throws SQLException {
        PaymentService paymentService=new PaymentService(serviceName);
        Connection validateConnection=paymentService.getConnection();
        DatabaseConnection.checkAllUsers(validateConnection);
    }
}
