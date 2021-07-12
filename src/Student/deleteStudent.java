package Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class deleteStudent implements ActionListener {
    JFrame deleteFrame;
    JLabel imageLabel, imageLabel2;
    JLabel heading;
    JLabel studentNumber;
    JButton deleteBtn;
    JButton backBtn;
    JTextField studentT = new JTextField();

    public void deleteStudentPage(){

        deleteFrame = new JFrame("Remove student page");
        deleteFrame.setBackground(Color.yellow);
        deleteFrame.setSize(300, 450);
        deleteFrame.setLocation(450,300);
        deleteFrame.setLayout(null);
        deleteFrame.setVisible(true);


        imageLabel = new JLabel();
        imageLabel.setBounds(0,0,600,350);
        imageLabel.setLayout(null);
        ImageIcon image1 =  new ImageIcon(ClassLoader.getSystemResource("Student/images/dropS.jpg"));
        Image i2 = image1.getImage().getScaledInstance(300,180,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        imageLabel.setIcon(i3);

        deleteFrame.add(imageLabel);

        heading = new JLabel("Remove Student ");
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setForeground(Color.darkGray);
        heading.setBounds(50, 0, 200, 20);
        imageLabel.add(heading);

        studentNumber = new JLabel("Student no :");
        studentNumber.setFont(new Font("serif", Font.ITALIC, 20));
        studentNumber.setBounds(20, 40, 150, 20);
        imageLabel.add(studentNumber);
        studentT.setBounds(130, 40, 150, 25);
        imageLabel.add(studentT);


        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(100, 300, 120, 25);
        deleteBtn.setBackground(Color.red);
        deleteBtn.setForeground(Color.black);
        deleteBtn.addActionListener(this);
        imageLabel.add(deleteBtn);

        backBtn = new JButton("Main Page");
        backBtn.setBounds(100, 330, 120, 25);
        backBtn.setBackground(Color.darkGray);
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(this);
        imageLabel.add(backBtn);
    }

    public void actionPerformed(ActionEvent aE){
        String retrieveStudentNumber = studentT.getText();
        connectionMain connObject = new connectionMain();
        if (aE.getSource()==deleteBtn){
            if(retrieveStudentNumber.isEmpty()){
                JOptionPane.showMessageDialog(null, "Field cannot be empty");
            }else{

                try {
                    String getStudentNumbers = "select `studentNumber` from students where `studentNumber`='"+retrieveStudentNumber+"'";
                    ResultSet rSet = connObject.queries.executeQuery(getStudentNumbers);

                    if(!rSet.next()){
                        JOptionPane.showMessageDialog(null, "Student no. doesn't exist");
                    }else{
                        String removeStudent = "delete from students where `studentNumber`='"+retrieveStudentNumber+"'";
                        connObject.queries.executeUpdate(removeStudent);
                        JOptionPane.showMessageDialog(null,"Entry removed successfully");
                        deleteFrame.setVisible(false);
                        operationClass obj = new operationClass();
                        obj.callOpertionMenu();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
//
            }

        }else if(aE.getSource() == backBtn){
            deleteFrame.setVisible(false);
            operationClass obj = new operationClass();
            obj.callOpertionMenu();

        }


    }

    public static void main(String[] args){
        deleteStudent obj = new deleteStudent();
        obj.deleteStudentPage();

    }
}
