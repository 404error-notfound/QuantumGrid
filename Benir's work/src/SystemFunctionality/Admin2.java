package SystemFunctionality;

import java.sql.SQLException;

public class Admin2 extends User{
    private Integer adminId;
    private DatabaseConnection connection;

    public Admin2(Integer adminId, String name, String email, String password,DatabaseConnection connection) {
        super(adminId, name, email, password);
        this.connection=connection;
    }

    @Override
    void checkTokens() throws SQLException {

    }
    @Override
    void makePayment(Double amount) throws SQLException {

    }
    void checkAllUsers(){
        //DatabaseConnection.checkAllUsers();
    }
}
