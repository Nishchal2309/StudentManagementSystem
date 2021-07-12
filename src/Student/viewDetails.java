package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewDetails implements ActionListener{

    JFrame viewFrame;
    JLabel heading;
    JLabel name, guardianName, emailId, studentNumberLabel, majorCourse, dob, contactInformation;
    String name1, guardianName1, emailId1, studentNumber1, majorCourse1, dob1, contactInformation1;
    JLabel nameT;
    JButton backBtn;

    public void viewDetailsCall(String studentNumber){

        try {
            connectionMain connObj = new connectionMain();
            String executeQuery = "select * from students where `studentNumber`='"+studentNumber+"'";
            ResultSet rSet = connObj.queries.executeQuery(executeQuery);

            while(rSet.next()){
                name1 = rSet.getString("name");
                guardianName1 = rSet.getString("guardian");
                emailId1 = rSet.getString("emailId");
                studentNumber1 = rSet.getString("studentNumber");
                majorCourse1 = rSet.getString("major");
                dob1 = rSet.getString("dob");
                contactInformation1 = rSet.getString("contact");



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        viewFrame = new JFrame("Add students page");
        viewFrame.setLayout(null);
        viewFrame.setSize(550, 400);
        viewFrame.setLocation(450, 150);
        viewFrame.getContentPane().setBackground(Color.gray);
        viewFrame.setVisible(true);

        heading = new JLabel("View Students");
        heading.setBounds(170, 0, 300, 50);
        heading.setFont(new Font("serif", Font.BOLD,  30));
        heading.setForeground(Color.white);
        viewFrame.add(heading);


        name = new JLabel("Name");
        name.setBounds(25, 100, 150, 25);
        name.setFont(new Font("serif", Font.ITALIC, 20));

        viewFrame.add(name);

        nameT = new JLabel(name1);
        nameT.setBounds(125, 105, 100, 20);
        viewFrame.add(nameT);




        studentNumberLabel = new JLabel("Student no.");
        studentNumberLabel.setBounds(30, 150, 150, 25);
        studentNumberLabel.setFont(new Font("serif", Font.ITALIC, 20));

        viewFrame.add(studentNumberLabel);

        JLabel studentNumberT = new JLabel(studentNumber1);
        studentNumberT.setBounds(125, 155, 100, 20);
        viewFrame.add(studentNumberT);


        emailId = new JLabel("Email id");
        emailId.setBounds(25, 200, 300, 25);
        emailId.setFont(new Font("serif", Font.ITALIC, 20));

        viewFrame.add(emailId);

        JLabel emailIdT = new JLabel(emailId1);

        emailIdT.setBounds(125, 205, 200, 20);
        viewFrame.add(emailIdT);


        guardianName = new JLabel("Guardian ");
        guardianName.setBounds(25, 250, 150, 25);
        guardianName.setFont(new Font("serif", Font.ITALIC, 20));

        viewFrame.add(guardianName);

        JLabel guardianNameT = new JLabel(guardianName1);
        guardianNameT.setBounds(125, 255, 100, 20);
        viewFrame.add(guardianNameT);

        majorCourse = new JLabel("Major");
        majorCourse.setBounds(300, 100, 200, 25);
        majorCourse.setFont(new Font("serif", Font.ITALIC, 20));

        viewFrame.add(majorCourse);

        JLabel majorCourseT = new JLabel(majorCourse1);
        majorCourseT.setBounds(400, 105, 100, 20);
        viewFrame.add(majorCourseT);


        dob = new JLabel("DOB");
        dob.setBounds(300, 150, 150, 25);
        dob.setFont(new Font("serif", Font.ITALIC, 20));

        viewFrame.add(dob);

        JLabel dobT = new JLabel(dob1);
        dobT.setBounds(400, 155, 100, 20);
        viewFrame.add(dobT);


        contactInformation = new JLabel("Contact ");
        contactInformation.setBounds(300, 200, 300, 25);
        contactInformation.setFont(new Font("serif", Font.ITALIC, 20));

        viewFrame.add(contactInformation);

        JLabel contactInformationT = new JLabel(contactInformation1);
        contactInformationT.setBounds(400, 205, 100, 20);
        viewFrame.add(contactInformationT);

        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        backBtn.setBounds(350,320,150, 30);
        backBtn.setBackground(Color.darkGray);
        backBtn.setForeground(Color.white);
        viewFrame.add(backBtn);



    }

    public void actionPerformed(ActionEvent aE){
        if (aE.getSource() == backBtn){
            viewFrame.setVisible(false);
            operationClass operationObj = new operationClass();
            operationObj.callOpertionMenu();
        }

    }

    public static void main(String[] args){
        viewDetails obj = new viewDetails();
//        obj.viewDetailsCall();
    }
}
