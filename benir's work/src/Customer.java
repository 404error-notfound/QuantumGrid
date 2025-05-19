public class Customer extends User{
    String customerNumber;
    public Customer(String name,String email,String password,String customerNumber){
        super(name,email,password);
        this.customerNumber=customerNumber;

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
