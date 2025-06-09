package SystemFunctionality;

public class Customer extends User {

    private Integer userNo;
    private Double Tokens;

    public Customer(Integer customerId,String name, String email, String password, Integer userNo,Double Tokens) {
        super(customerId,name, email, password);
        this.userNo = userNo;
        this.Tokens=Tokens;
    }


    //Use a sql query to retrieve token amount (probably)
    @Override
    void checkTokens() {

    }

    @Override
    void makePayment() {

    }
}
