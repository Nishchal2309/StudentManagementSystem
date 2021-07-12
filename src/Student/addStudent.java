package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addStudent implements ActionListener {

    JFrame addFrame;
    JLabel imageLabel, imageLabel2;
    JLabel name, guardianName, emailId, studentNumber, majorCourse, dob, contactInformation;
    JTextField nameT= new JTextField();
    JTextField guardianNameT= new JTextField();
    JTextField emailIdT= new JTextField();
    JTextField studentNumberT= new JTextField();
    JTextField majorCourseT= new JTextField();
    JTextField dobT= new JTextField();
    JTextField contactInformationT= new JTextField();

    JButton submit;
    JButton back;

    public void addStudentPage(){
        addFrame = new JFrame("Add students page");
        addFrame.setLayout(null);
        addFrame.setSize(700, 600);
        addFrame.setLocation(450, 200);
        addFrame.getContentPane().setBackground(Color.white);
        addFrame.setVisible(true);


        imageLabel = new JLabel();
        imageLabel.setBounds(120, 0, 700, 600);
        imageLabel.setLayout(null);
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Student/images/addStudent.png"));
        Image i2 = ic.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        imageLabel.setIcon(i3);
        addFrame.add(imageLabel);


        imageLabel2 = new JLabel("Add Students");
        imageLabel2.setBounds(130, 0, 300, 50);
        imageLabel2.setFont(new Font("serif", Font.BOLD,  30));
        imageLabel.add(imageLabel2);


        name = new JLabel("Name");
        name.setBounds(0, 100, 150, 25);
        name.setFont(new Font("serif", Font.ITALIC, 20));

        imageLabel.add(name);


        studentNumber = new JLabel("Student no");
        studentNumber.setBounds(0, 150, 150, 25);
        studentNumber.setFont(new Font("serif", Font.ITALIC, 20));

        imageLabel.add(studentNumber);


        emailId = new JLabel("Email id");
        emailId.setBounds(0, 200, 300, 25);
        emailId.setFont(new Font("serif", Font.ITALIC, 20));

        imageLabel.add(emailId);


        guardianName = new JLabel("Guardian ");
        guardianName.setBounds(0, 250, 150, 25);
        guardianName.setFont(new Font("serif", Font.ITALIC, 20));

        imageLabel.add(guardianName);

        ////////////////////////////
        nameT.setBounds(100, 105, 100, 20);
        imageLabel.add(nameT);

        studentNumberT.setBounds(100, 155, 100, 20);
        imageLabel.add(studentNumberT);

        emailIdT.setBounds(100, 205, 100, 20);
        imageLabel.add(emailIdT);

        guardianNameT.setBounds(100, 255, 100, 20);
        imageLabel.add(guardianNameT);

        /////////////////////////////
        majorCourse = new JLabel("Major");
        majorCourse.setBounds(300, 100, 150, 25);
        majorCourse.setFont(new Font("serif", Font.ITALIC, 20));

        imageLabel.add(majorCourse);


        dob = new JLabel("DOB");
        dob.setBounds(300, 150, 150, 25);
        dob.setFont(new Font("serif", Font.ITALIC, 20));

        imageLabel.add(dob);


        contactInformation = new JLabel("Contact ");
        contactInformation.setBounds(300, 200, 300, 25);
        contactInformation.setFont(new Font("serif", Font.ITALIC, 20));

        imageLabel.add(contactInformation);

        /////////////////////////////////////

        majorCourseT.setBounds(400, 105, 100, 20);
        imageLabel.add(majorCourseT);

        dobT.setBounds(400, 155, 100, 20);
        imageLabel.add(dobT);

        contactInformationT.setBounds(400, 205, 100, 20);
        imageLabel.add(contactInformationT);

        /////////////////
        //button
        submit = new JButton("SUBMIT");
        submit.setBounds(150, 400, 150, 30);
        submit.setBackground(Color.darkGray);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        imageLabel.add(submit);

        back = new JButton("Main Page");
        back.setBounds(150, 450, 150, 30);
        back.setBackground(Color.darkGray);
        back.setForeground(Color.white);
        back.addActionListener(this);
        imageLabel.add(back);
    }

    public void actionPerformed(ActionEvent aE){
        connectionMain conObj = new connectionMain();
        String retrieveName = nameT.getText();
        String retrieveStudentNo = studentNumberT.getText();
        String retrieveEmail = emailIdT.getText();
        String retrieveGuardian = guardianNameT.getText();
        String retrievMajor = majorCourseT.getText();
        String retrieveDob = dobT.getText();
        String retrieveContact = contactInformationT.getText();

        if (aE.getSource() == submit){
            if(retrieveName.isEmpty() || retrieveStudentNo.isEmpty() || retrieveEmail.isEmpty()|| retrieveGuardian.isEmpty() || retrievMajor.isEmpty() || retrieveDob.isEmpty() || retrieveContact.isEmpty()){
                JOptionPane.showMessageDialog(null,"All fields are mandatory");
            }else{
                try {
                    String executeQuery = "insert into students values('"+retrieveName+"','"+retrieveStudentNo+"','"+retrieveEmail+"','"+retrieveGuardian+"','"+retrievMajor+"','"+retrieveDob+"','"+retrieveContact+"')";
                    conObj.queries.executeUpdate(executeQuery);
                    JOptionPane.showMessageDialog(null, "Student added to database");
                    addFrame.setVisible(false);
                    operationClass obj = new operationClass();
                    obj.callOpertionMenu();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else if (aE.getSource() == back){
            addFrame.setVisible(false);
            operationClass obj = new operationClass();
            obj.callOpertionMenu();
        }



    }


    public static void main(String[] args){

        addStudent aS = new addStudent();
        aS.addStudentPage();
    }
}
