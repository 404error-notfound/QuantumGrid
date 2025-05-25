public class Customer extends User{

    private Integer CustomerID;

    public Customer(String name,String email,String password,Integer CustomerID){
        super(name,email,password);
        this.CustomerID=CustomerID;
    }

    @Override
    void checkTokens() {

    }

    @Override
    void makePayment() {

    }

    @Override
    void checkElectricityUsage() {

    }

    @Override
    void viewPaymentHistory() {

    }

    @Override
    void updatePaymentHistory() {

    }
}
