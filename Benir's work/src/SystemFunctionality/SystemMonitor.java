package SystemFunctionality;

import java.sql.SQLException;

public interface SystemMonitor {
    void verifyTokens(Customer customer) throws SQLException;
    void checkUserData(Admin admin) throws SQLException;
}
