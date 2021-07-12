package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
public class operationClass implements ActionListener {
    JFrame opertionFrame;
    JLabel imageLabel, imageLabel2;
    JButton addBtn, deleteBtn, updateBtn, lookUptn;
    //operationClass(){
    public void callOpertionMenu(){
        opertionFrame = new JFrame("Operation page");
        opertionFrame.setLayout(null);
        opertionFrame.setVisible(true);
        opertionFrame.setSize(800, 400);
        opertionFrame.setLocation(250, 200);


        imageLabel = new JLabel();
        imageLabel.setBounds(0,0,800,400);
        imageLabel.setLayout(null);
        ImageIcon image1 =  new ImageIcon(ClassLoader.getSystemResource("Student/images/rgb-logo.jpg"));

        imageLabel.setIcon(image1);


        opertionFrame.add(imageLabel);


        imageLabel2 = new JLabel("Menu Options");
        imageLabel2.setBounds(300, 0, 300, 50);
        imageLabel2.setFont(new Font("serif", Font.ITALIC,  35));
        imageLabel.add(imageLabel2);


        addBtn = new JButton("Add Student");
        addBtn.setFont(new Font("serif", Font.BOLD,  20));
        addBtn.setBackground(Color.darkGray);
        addBtn.setForeground(Color.white);
        addBtn.setBounds(100, 100, 150, 40);
        addBtn.addActionListener(this);
        imageLabel.add(addBtn);

        deleteBtn = new JButton("Remove Student");
        deleteBtn.setFont(new Font("serif", Font.BOLD,  20));
        deleteBtn.setBackground(Color.darkGray);
        deleteBtn.setForeground(Color.white);
        deleteBtn.addActionListener(this::actionPerformed);
        deleteBtn.setBounds(100, 250, 150, 40);

        imageLabel.add(deleteBtn);

        lookUptn = new JButton("LookUp Student");
        lookUptn.setFont(new Font("serif", Font.BOLD,  20));
        lookUptn.setBackground(Color.darkGray);
        lookUptn.setForeground(Color.white);
        lookUptn.setBounds(550, 100, 150, 40);
        lookUptn.addActionListener(this::actionPerformed);
        imageLabel.add(lookUptn);


        updateBtn = new JButton("Update info");
        updateBtn.setFont(new Font("serif", Font.BOLD,  20));
        updateBtn.setBackground(Color.darkGray);
        updateBtn.setForeground(Color.white);
        updateBtn.setBounds(550, 250, 150, 40);

        imageLabel.add(updateBtn);
    }

    //}


    public void actionPerformed(ActionEvent aE){
        if (aE.getSource()==addBtn){
            opertionFrame.setVisible(false);
            addStudent obj = new addStudent();
            obj.addStudentPage();

        }else if(aE.getSource()==deleteBtn){
            opertionFrame.setVisible(false);
            deleteStudent obj = new deleteStudent();
            obj.deleteStudentPage();
        }else if(aE.getSource()==lookUptn){
            opertionFrame.setVisible(false);
            viewClass obj = new viewClass();
            obj.viewClassCall();

        }


    }

    public static void main(String[] args){

        operationClass oc = new operationClass();
        oc.callOpertionMenu();
    }
}
