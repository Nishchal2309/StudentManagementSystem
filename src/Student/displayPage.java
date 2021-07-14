package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class displayPage implements ActionListener{

    JFrame frame;
    JLabel id, l1;
    JButton btn1;

    displayPage(){
        frame = new JFrame("Student Registration system");
        frame.setBackground(Color.blue);
        frame.setLayout(null);

//        frame.pack();
        frame.getContentPane().setBackground(Color.orange);

        frame.setVisible(true);// important line, default is false
        frame.setSize(1000, 400);
        frame.setLocation(250, 200);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Student/images/universityImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label1 = new JLabel(i3);

        label1.setBounds(240, 200 , 1400, 530);


        btn1= new JButton("Continue");
        btn1.setFont(new Font("serif", Font.ITALIC,  20));
        btn1.setBackground(Color.darkGray);
        btn1.setForeground(Color.white);
        btn1.setBounds(550, 350, 300, 40);
        btn1.addActionListener(this);

        id = new JLabel();
        id.setBounds(100, 0 , 1400, 530);
        id.setLayout(null);


        l1 = new JLabel();
        l1.setBounds(400, 300 , 1400, 530);
        l1.setLayout(null);

        JLabel heading = new JLabel("Register Students");
        heading.setBounds(150, 100, 1400, 150);
        heading.setForeground(Color.DARK_GRAY);
        heading.setFont(new Font("serif",Font.BOLD, 70));

        id.add(heading);
        label1.add(btn1);
//        id.add(btn1);
        frame.add(id);
        frame.add(l1);
        frame.add(label1);


//        while (true){
//
//            heading.setVisible(false);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                heading.setVisible(true);
//
//            }
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        }



    }

    public void actionPerformed(ActionEvent aP){
        if(aP.getSource()==btn1){
            frame.setVisible(false);
            // call login page here
            optionPage optionObj = new optionPage();
            optionObj.optionPageCall();
        }
    }


    public static void main(String[] args){
        displayPage dp= new displayPage();

    }


}


