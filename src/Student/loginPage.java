package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class loginPage implements ActionListener{
    JFrame loginFrame;
    JLabel studentLabel;
    JLabel passwordLabel;
    JTextField userText = new JTextField();
    JPasswordField passText = new JPasswordField();
    JButton loginButton;

    public void displayLoginPage(){

        loginFrame = new JFrame("Welcome to Login page");
        loginFrame.setBackground(Color.lightGray);
        loginFrame.setSize(450, 250);
        loginFrame.setLocation(550,300);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);

        JLabel test = new JLabel();


        studentLabel = new JLabel("Username :");
        studentLabel.setFont(new Font("serif", Font.BOLD, 20));
        studentLabel.setBounds(20, 40, 150, 20);
        loginFrame.add(studentLabel);
        userText.setBounds(150, 40, 120, 25);
        loginFrame.add(userText);

        passwordLabel = new JLabel("Password :");
        passwordLabel.setFont(new Font("serif", Font.BOLD, 20));

        passwordLabel.setBounds(20, 100, 150, 25);

        loginFrame.add(passwordLabel);
        passText.setBounds(150, 100, 120, 25);
        loginFrame.add(passText);


        loginButton = new JButton("LOGIN");
        loginButton.setBounds(150, 140, 120, 25);
        loginButton.setBackground(Color.blue);
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(this);
        loginFrame.add((loginButton));

    }

    // database name: courseName
    public void actionPerformed(ActionEvent aE){
        // getting tested for errors in the try block and catch defines the code that needs to be executed in case an exception occurs in the try block

        connectionMain connObject = new connectionMain();
        String studentNumber = userText.getText();
        String password = String.valueOf(passText.getPassword()); // gets password as a string

        if(studentNumber.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Both Fields are mandatory :)");
        }

        try {
            String executeQuery = "select * from login where studentNumber='"+studentNumber+"' and password ='"+password+"'" ;
            ResultSet rSet = connObject.queries.executeQuery(executeQuery);// stores result of query
            // u must use rSet.next() exactly once
            if(!rSet.next()){
                JOptionPane.showMessageDialog(null, "Student Number/ Password not found :(");
            }else{
                if(studentNumber.equals(rSet.getString("studentNumber"))){
                    if(password.equals(rSet.getString("password"))){
                        JOptionPane.showMessageDialog(null, "you are now logged in :)");

                        loginFrame.setVisible(false);
                        operationClass obj = new operationClass();
                        obj.callOpertionMenu();
                    }else{
                        JOptionPane.showMessageDialog(null, "password not found :(");

                    }
                }
            }




//            }


        }catch (Exception ex){
            ex.printStackTrace();// helps to debug since it gives u the details where the exception occured and all
        }


    }


    public static void main(String[] args){

        loginPage lg = new loginPage();
        lg.displayLoginPage();
    }

}
