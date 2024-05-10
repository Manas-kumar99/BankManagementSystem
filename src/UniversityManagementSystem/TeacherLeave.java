package UniversityManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice cEmpid, ctime;
    JDateChooser dcdob;
    JButton submit ,cancel;
    TeacherLeave(){
        setSize(550,550);
        getContentPane().setBackground(Color.lightGray);
        setLocation(300,100);
        setResizable(false);


        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(160, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblrollno= new JLabel("Search By Employee Id : ");
        lblrollno.setBounds(40,100,150,18);
        lblrollno.setFont(new Font("serif",Font.BOLD,16));
        add(lblrollno);
        cEmpid = new Choice();
        cEmpid.setBounds(220,100,260,18);
        cEmpid.setFont(new Font("serif",Font.BOLD,16));
        add(cEmpid);

        try {
            conn  c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher ");
            while(rs.next()){
                cEmpid.add(rs.getString("empId"));

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
        new TeacherLeave();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== submit){
            String empId = cEmpid.getSelectedItem();
            String date = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query= "insert into teacherleave values('"+empId+"','"+date+"','"+duration+"')";
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

