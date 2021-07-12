package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewClass implements ActionListener {
    JFrame viewFrame;
    JLabel heading;
    JLabel studentNumber;
    JButton viewBtn;
    JButton backBtn;
    JTextField studentT = new JTextField();

    public  void viewClassCall(){
        viewFrame = new JFrame("Search a student");
        viewFrame.getContentPane().setBackground( Color.blue );
        viewFrame.setSize(350, 400);
        viewFrame.setLocation(450,300);
        viewFrame.setLayout(null);
        viewFrame.setVisible(true);

        heading = new JLabel("Search Student ");
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setForeground(Color.white);
        heading.setBounds(80, 0, 200, 20);
        viewFrame.add(heading);

        studentNumber = new JLabel("Student no :");
        studentNumber.setFont(new Font("serif", Font.ITALIC, 20));
        studentNumber.setForeground(Color.white);
        studentNumber.setBounds(20, 100, 150, 20);
        viewFrame.add(studentNumber);
        studentT.setBounds(130, 100, 150, 25);
        viewFrame.add(studentT);


        viewBtn = new JButton("View");
        viewBtn.setBounds(100, 200, 120, 25);
        viewBtn.setBackground(Color.yellow);
        viewBtn.setForeground(Color.black);
        viewBtn.addActionListener(this);
        viewFrame.add(viewBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(100, 250, 120, 25);
        backBtn.setBackground(Color.darkGray);
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(this);
        viewFrame.add(backBtn);

    }

    public void actionPerformed(ActionEvent aE){
        String retrieveStudentNumber = studentT.getText();
        connectionMain connObject = new connectionMain();

        if (aE.getSource()==viewBtn){
            if(retrieveStudentNumber.isEmpty()){
                JOptionPane.showMessageDialog(null, "Field cannot be empty");
            }else{

                try {
                    String getStudentNumbers = "select `studentNumber` from students where `studentNumber`='"+retrieveStudentNumber+"'";
                    ResultSet rSet = connObject.queries.executeQuery(getStudentNumbers);

                    if(!rSet.next()){
                        JOptionPane.showMessageDialog(null, "Student no. doesn't exist");
                    }else{
                        viewDetails obj = new viewDetails();
                        obj.viewDetailsCall(retrieveStudentNumber);
                        viewFrame.setVisible(false);


                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
//
            }

        }else if(aE.getSource()==backBtn){
            viewFrame.setVisible(false);
            operationClass obj = new operationClass();
            obj.callOpertionMenu();

        }

    }

    public static void main(String[] args){
        viewClass obj = new viewClass();
        obj.viewClassCall();
    }
}
