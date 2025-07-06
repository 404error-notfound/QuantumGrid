package SystemFunctionality;

import java.sql.SQLException;

abstract public class User {
    private Integer UserId;
    private String name;
    private String email;
    private String Password;
    //protected int userNo; (MeterNo)
    private static int count=0;
    public User(Integer UserId ,String name, String email, String password) {
        this.UserId=UserId;
        this.name = name;
        this.email = email;
        this.Password = password;
        count++;
    }
    public User(String name,String email,String password){
        this.name=name;
        this.email=email;
        this.Password=password;
    }
    abstract void checkTokens() throws SQLException;
    abstract void makePayment(Double amount) throws SQLException;

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
    public Integer getUserId(){return UserId;}


}
