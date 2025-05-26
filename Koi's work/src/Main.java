public class Main {
    public static void main(String[] args) {
        User admin=new User("Miricho","miricho@mail.com","45643xyw");
        userDatabase db=new userDatabase();
        db.saveUser(admin);
    }
}
