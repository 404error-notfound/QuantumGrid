public class Admin extends User{
    String adminNumber;
    public Admin(String name,String email,String password,String adminNumber){
        super(name,email,password);
        this.adminNumber=adminNumber;
    }


    @Override
    void userLogin() {

    }

    @Override
    void createAccount() {

    }

    @Override
    void checkTokens() {

    }

    @Override
    void makePayment() {

    }
}
