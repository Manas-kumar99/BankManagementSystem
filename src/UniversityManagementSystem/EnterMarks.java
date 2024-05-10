package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsubl,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,cancel;


    EnterMarks(){
        setSize(1000,600);
        setLocation(100 ,100);
        setLayout(null);
        setResizable(false);
//        getContentPane().setBackground(Color.lightGray);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);

        JLabel heading = new JLabel("Enter Marks For Student");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("seif", Font.BOLD, 30));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number :");
        lblrollnumber.setBounds(30, 80, 200, 20);
        lblrollnumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250, 80, 200, 20);
        add(crollno);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel lblsemester = new JLabel("Select Semester :");
        lblsemester.setBounds(30, 120, 200, 20);
        lblsemester.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblsemester);

        String [] semester = {"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(250,120,200,30);
        cbsemester.setBackground(Color.white);
        add(cbsemester);


        JLabel lblentersubject = new JLabel("Enter Subject ");
        lblentersubject.setBounds(40, 180, 200, 20);
        lblentersubject.setFont(new Font("serif", Font.BOLD, 20));
        add(lblentersubject);

        JLabel lblentermarks = new JLabel("Enter Marks  ");
        lblentermarks.setBounds(285, 180, 200, 20);
        lblentermarks.setFont(new Font("serif", Font.BOLD, 20));
        add(lblentermarks);

        tfsubl  = new JTextField();
        tfsubl.setBounds(20,220,210,30);
        add(tfsubl);
        tfsub2  = new JTextField();
        tfsub2.setBounds(20,260,210,30);
        add(tfsub2);
        tfsub3  = new JTextField();
        tfsub3.setBounds(20,310,210,30);
        add(tfsub3);
        tfsub4  = new JTextField();
        tfsub4.setBounds(20,350,210,30);
        add(tfsub4);
        tfsub5  = new JTextField();
        tfsub5.setBounds(20,390,210,30);
        add(tfsub5);



        tfmarks1  = new JTextField();
        tfmarks1.setBounds(240,220,210,30);
        add(tfmarks1);
        tfmarks2  = new JTextField();
        tfmarks2.setBounds(240,260,210,30);
        add(tfmarks2);
        tfmarks3  = new JTextField();
        tfmarks3.setBounds(240,310,210,30);
        add(tfmarks3);
        tfmarks4  = new JTextField();
        tfmarks4.setBounds(240,350,210,30);
        add(tfmarks4);
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(240,390,210,30);
        add(tfmarks5);




        submit = new JButton("Submit");
        submit.setBounds(30, 460, 200, 35);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(240, 460, 200, 35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(cancel);




        setVisible(true);
    }




    public static void main(String[] args) {
        new EnterMarks();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            try{
                conn c = new conn();
                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsubl.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";

                String query2 = "insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()
                        +"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()
                        +"','"+tfmarks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Marks Inserted Succesfully");
                setVisible(false);


            }catch (Exception ae){
                ae.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
}
