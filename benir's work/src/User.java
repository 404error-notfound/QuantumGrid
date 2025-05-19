abstract public class User {
    String name;
    String email;
    String Password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.Password = password;
    }
    abstract void userLogin();
    abstract void createAccount();
    abstract void checkTokens();
    abstract void makePayment();


}
