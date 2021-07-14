package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class optionPage implements ActionListener {

    JFrame optionFrame;
    JButton loginBtn, registerBtn;
    JLabel heading;

    public  void optionPageCall(){
        optionFrame = new JFrame("Welcome to Login page");
        optionFrame.getContentPane().setBackground(Color.PINK);
        optionFrame.setSize(450, 250);
        optionFrame.setLocation(550,300);
        optionFrame.setLayout(null);
        optionFrame.setVisible(true);

        heading= new JLabel("REGISTER IF LOGGING FOR THE FIRST TIME...");
        heading.setBounds(20, 30, 350, 30);
        heading.setFont(new Font("serif", Font.BOLD, 15));
        optionFrame.add(heading);


        loginBtn = new JButton("Login");
        loginBtn.setBounds(25, 100, 150, 25);
        loginBtn.setBackground(Color.yellow);
        loginBtn.setForeground(Color.black);
        loginBtn.addActionListener(this);
        optionFrame.add(loginBtn);


        registerBtn = new JButton("Register");
        registerBtn.setBounds(260, 100, 150, 25);
        registerBtn.setBackground(Color.yellow);
        registerBtn.addActionListener(this);
        registerBtn.setForeground(Color.black);

        optionFrame.add(registerBtn);


    }

    public void actionPerformed(ActionEvent aE){
        if (aE.getSource()== loginBtn){
            optionFrame.setVisible(false);
            loginPage loginObj = new loginPage();
            loginObj.displayLoginPage();
        }else if(aE.getSource() == registerBtn){
            optionFrame.setVisible(false);
            registerYourself registerObj = new registerYourself();
            registerObj.registerCall();

        }
    }
    public static void main(String[] args){
        optionPage obj = new optionPage();
        obj.optionPageCall();
    }
}
