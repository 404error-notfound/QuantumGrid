package SystemFunctionality;

abstract public class User {
    protected String name;
    protected String email;
    protected String Password;
    //protected int userNo; (MeterNo)
    private static int count=0;
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.Password = password;
        count++;
    }
    abstract void checkTokens();
    abstract void makePayment();


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
