package SystemFunctionality;

import java.sql.SQLException;

public class SystemManagement implements SystemMonitor{

    @Override
    public void verifyTokens(Customer customer) throws SQLException {
        customer.checkTokens();
    }

    @Override
    public void checkUserData(Admin administrator) throws SQLException {
        administrator.checkAllUsers("MPESA");

    }
}
