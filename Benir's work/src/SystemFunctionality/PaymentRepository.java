package SystemFunctionality;

import java.sql.Connection;
import java.sql.SQLException;

public interface PaymentRepository {
    Connection getConnection() throws SQLException;
}
