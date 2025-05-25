abstract public class User {
    private String name;
    private String email;
    private String Password;
    private static int count=0;
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.Password = password;
        count++;
    }
    abstract void checkTokens();
    abstract void makePayment();
    abstract void checkElectricityUsage();
    abstract void viewPaymentHistory();
    abstract void updatePaymentHistory();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return Password;
    }
    public int getCount(){
        return count;
    }


}
