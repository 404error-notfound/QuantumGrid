package SystemFunctionality;

import java.sql.SQLException;

abstract public class User {
    private final String name;
    private final String email;
    private final String Password;

    /**
     * Sets the attributes of a user in our Token System database
     * @param name The full name of the user
     * @param email The email of the user
     * @param password The password of the user
     */

    public User(String name,String email,String password){
        this.name=name;
        this.email=email;
        this.Password=password;
    }

    /**
     * Facilitates database connection when a customer is checking tokens
     * @throws SQLException We handle this exception given that we encounter an error.
     */
    abstract void checkTokens() throws SQLException;

    /**
     * Making payments requires database interactions as well, hence SQL exceptions need to be handled
     * @param amount  Amount in Ksh that the user will input to make payments
     * @throws SQLException Given an error in network connection or database connection,
     * we handle it
     */
    abstract void makePayment(Double amount) throws SQLException;

    /**
     * Gets the name of the user
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the email of the user
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user password during database access
     * @return password
     */
    public String getPassword() {
        return Password;
    }


}
