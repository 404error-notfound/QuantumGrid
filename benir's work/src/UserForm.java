import javax.swing.*;

public class UserForm {
    static void makeFrame(String frameName,String nameLabel,String emailLabel,String passLabel){
        JFrame frame=new JFrame(frameName);
        JLabel name=new JLabel(nameLabel);
        JLabel email=new JLabel(emailLabel);
        JLabel pass=new JLabel(passLabel);

    }
    static void makeForm(JTextField nameField,JTextField emailField,JPasswordField passwordField){

    }
    public static void main(String[] args) {
        //Create UI components
        JFrame frame=new JFrame("User Registration");
        JLabel nameLabel=new JLabel("Name:");
        JLabel emailLabel=new JLabel("Email:");
        JLabel passwordLabel=new JLabel("Password:");

        JTextField nameField=new JTextField();
        JTextField emailField=new JTextField();
        JPasswordField passwordField=new JPasswordField();

        JButton submitButton=new JButton("Submit");

        //set my positions and sizes
        frame.setSize(350,250);
        frame.setLayout(null);

        nameLabel.setBounds(20,20,80,25);
        emailLabel.setBounds(20,60,80,25);
        passwordLabel.setBounds(20,100,80,25);

        nameField.setBounds(100,20,80,25);
        emailField.setBounds(100,60,80,25);
        passwordField.setBounds(100,100,80,25);

        submitButton.setBounds(100,150,100,30);

        //Add the edited items to the frame
        frame.add(nameLabel);
        frame.add(emailLabel);
        frame.add(passwordLabel);
        frame.add(nameField);
        frame.add(emailField);
        frame.add(passwordField);
        frame.add(submitButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Handle submit button click

    }
}
