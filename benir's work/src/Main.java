public class Main {
    public static void main(String[] args) {
        User admin=new User("Kylian Mbappe","kmbappe@gmail.com","xz3v58");
        userDatabase db=new userDatabase();
        db.saveUser(admin);
    }
}
