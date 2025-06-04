package SystemFunctionality;

public class Customer extends User {

    private Integer userNo;

    public Customer(String name, String email, String password, Integer userNo) {
        super(name, email, password);
        this.userNo = userNo;
    }


    //Use a sql query to retrieve token amount (probably)
    @Override
    void checkTokens() {

    }

    @Override
    void makePayment() {

    }
}
