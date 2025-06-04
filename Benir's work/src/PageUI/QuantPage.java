package PageUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuantPage implements ActionListener {

    private JFrame QuantFrame;
    public QuantPage(JFrame QuantFrame){
        this.QuantFrame=QuantFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }

    void OpenQuantPage(){
        QuantFrame.setSize(500,400);
        QuantFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        QuantFrame.setLayout(null);

        JLabel greetingLabel=new JLabel("Hello");
        greetingLabel.setBounds(100,50,100,30);
        QuantFrame.add(greetingLabel);
        QuantFrame.setVisible(true);

    }
}
