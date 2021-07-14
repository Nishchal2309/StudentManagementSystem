package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class registerYourself implements ActionListener {
    JFrame registerFrame;
    JLabel studentLabel;
    JLabel passwordLabel;
    JLabel passwordFormat;
    JTextField userText = new JTextField();
    JPasswordField passText = new JPasswordField();
    JButton registerButton;
    JLabel heading;


    public void registerCall(){
        registerFrame = new JFrame("Welcome to Register page");
        registerFrame.setBackground(Color.lightGray);
        registerFrame.setSize(450, 250);
        registerFrame.setLocation(550,300);
        registerFrame.setLayout(null);
        registerFrame.setVisible(true);

        heading = new JLabel("Register");
        heading.setBounds(150,0,150, 35);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.black);
        registerFrame.add(heading);


        studentLabel = new JLabel("Username :");
        studentLabel.setFont(new Font("serif", Font.BOLD, 20));
        studentLabel.setBounds(20, 50, 150, 20);
        registerFrame.add(studentLabel);
        userText.setBounds(200, 50, 120, 25);
        registerFrame.add(userText);


        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("serif", Font.BOLD, 20));

        passwordLabel.setBounds(20, 100, 250, 25);

        registerFrame.add(passwordLabel);
        passText.setBounds(200, 100, 120, 25);
        registerFrame.add(passText);

        passwordFormat = new JLabel("(mmddyy)");
        passwordFormat.setFont(new Font("serif", Font.ITALIC, 15));
        passwordFormat.setBounds(120, 100, 120, 25);
        registerFrame.add(passwordFormat);


        registerButton = new JButton("REGISTER");
        registerButton.setBounds(150, 140, 120, 25);
        registerButton.setBackground(Color.blue);
        registerButton.setForeground(Color.white);
        registerButton.addActionListener(this);
        registerFrame.add((registerButton));

    }

    public void actionPerformed(ActionEvent aE){
        connectionMain conObj = new connectionMain();
        String retrieveStudentNo = userText.getText();
        String retrievePassword = String.valueOf(passText.getPassword());
        if(aE.getSource() == registerButton){
            if(retrieveStudentNo.isEmpty() || retrievePassword.isEmpty()){
                JOptionPane.showMessageDialog(null, "Both Fields are mandatory :)");
            }else if(retrieveStudentNo.length() != 9 ){
                JOptionPane.showMessageDialog(null, "Student number needs to be 9 characters long");
            }else if(retrievePassword.length() != 6){
                JOptionPane.showMessageDialog(null, "Password needs to be 6 characters (format: mmddyy)");
            }
            else{
                try {
                    String executeQuery = "select * from login";
                    ResultSet rSet = conObj.queries.executeQuery(executeQuery);
                    if(rSet.next()){
                        if(retrieveStudentNo.equals(rSet.getString("studentNumber"))){
                            JOptionPane.showMessageDialog(null, "Student number already exists");
                        }else{
                            String executeFinal = "insert into login values('"+retrieveStudentNo+"','"+retrievePassword+"')";
                            conObj.queries.executeUpdate(executeFinal);
                            JOptionPane.showMessageDialog(null,"Registered sucessfully:), you can now proceed to login");
                            registerFrame.setVisible(false);
                            loginPage loginObj = new loginPage();
                            loginObj.displayLoginPage();

                        }
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }



        }

    }
    public static void main(String[] args){
        registerYourself obj = new registerYourself();
        obj.registerCall();
    }
}
