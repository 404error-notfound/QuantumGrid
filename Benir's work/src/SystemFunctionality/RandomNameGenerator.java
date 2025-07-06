package SystemFunctionality;

import java.util.Random;

public class RandomNameGenerator {
    String[] firstNames = {"John", "Jane", "Alex", "Emily", "Chris", "Sara", "Michael", "Nina", "David", "Lily"};
    String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Wilson", "Anderson"};
    String[] fPasswords={"39xg8","w0djg","9fys","d9ufhu","3oirhs","dsiug48o","fgs439s","0sg-sd","d0ag94"};
    String[] lPasswords={"d0a4risa","0asi","doiiag09","djaghgi","durtdla","asdy8we45","d974t","sdg88u","dhapidg90"};

    public static void main(String[] args) {
        String[] firstNames = {"John", "Jane", "Alex", "Emily", "Chris", "Sara", "Michael", "Nina", "David", "Lily"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Wilson", "Anderson"};
        String[] fPasswords={"39xg8","w0djg","9fys","d9ufhu","3oirhs","dsiug48o","fgs439s","0sg-sd","d0ag94"};
        String[] lPasswords={"d0a4risa","0asi","doiiag09","djaghgi","durtdla","asdy8we45","d974t","sdg88u","dhapidg90"};

        new RandomNameGenerator().generateCredentials();

//        Random rand = new Random();
//
//        for (int i = 0; i < 100; i++) {
//            String first = firstNames[rand.nextInt(firstNames.length)];
//            String last = lastNames[rand.nextInt(lastNames.length)];
//            String fullName = first + " " + last;
//            String gmail=first+last+"@mail.com";
//            System.out.println((i + 1) + ". " + fullName+"-> "+gmail);
//        }
    }
    public void generateCredentials(){
        Random random=new Random();
        for (int i=0;i<100;i++){
            String first = firstNames[random.nextInt(firstNames.length)];
            String last = lastNames[random.nextInt(lastNames.length)];
            String fullName = first + " " + last;
            String gmail=first+last+"@mail.com";
            System.out.println((i + 1) + ". " + fullName+"-> "+gmail);
        }

    }
}
