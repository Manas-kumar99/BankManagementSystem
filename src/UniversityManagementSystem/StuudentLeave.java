package UniversityManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StuudentLeave extends JFrame implements ActionListener {
    Choice crollno, ctime;
    JDateChooser dcdob;
    JButton submit ,cancel;
    StuudentLeave(){
        setSize(550,550);
        getContentPane().setBackground(Color.lightGray);
        setLocation(300,100);
        setResizable(false);


        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(160, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblrollno= new JLabel("Search By Roll No : ");
        lblrollno.setBounds(40,100,150,18);
        lblrollno.setFont(new Font("serif",Font.BOLD,16));
        add(lblrollno);
        crollno = new Choice();
        crollno.setBounds(220,100,260,18);
        crollno.setFont(new Font("serif",Font.BOLD,16));
        add(crollno);

        try {
            conn  c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from student ");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel lbldate = new JLabel("Select Date :");
        lbldate.setBounds(40, 130, 260, 50);
        lbldate.setFont(new Font("serif", Font.BOLD, 17));
        add(lbldate);


        dcdob = new JDateChooser();
        dcdob.setBounds(220, 140, 260, 30);
        add(dcdob);

//        ----------------------leave for duration----------------------------------------
        JLabel lbltime= new JLabel("Time Duration");
        lbltime.setBounds(40,180,150,18);
        lbltime.setFont(new Font("serif",Font.BOLD,16));
        add(lbltime);
        ctime = new Choice();
        ctime.setBounds(220,180,260,18);
        ctime.setFont(new Font("serif",Font.BOLD,16));
        ctime.add("Full Day Leave");
        ctime.add("Half Day Leave");
        add(ctime);

//        ---------------------------------------Button--------------------------------------

        submit = new JButton("Submit");
        submit.setBounds(80, 280, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(300, 280, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);






        setLayout(null);
       setVisible(true);

    }

    public static void main(String[] args) {
        new StuudentLeave();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== submit){
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query= "insert into studentleave values('"+rollno+"','"+date+"','"+duration+"')";
            try
            {
                conn c =new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Conformed");
            }catch (Exception x){
                x.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
}
