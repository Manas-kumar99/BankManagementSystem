package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class TeacherleaveDetail extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search ,print, update,add,cancel;
    TeacherleaveDetail(){
        getContentPane().setBackground(Color.orange);
        getContentPane().setForeground(Color.BLACK);
        setSize(900,500);
        setLocation(50,50);
        setResizable(false);
        setLayout(null);

        JLabel heading= new JLabel("Search BY Employee Id");
        heading.setBounds(20,20,150,20);
        add(heading);
        cEmpId = new Choice();
        cEmpId.setBounds(180,20,150,20);
        add(cEmpId);

        try {
            conn  c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher ");
            while(rs.next()){
                cEmpId.add(rs.getString("EmpId"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        search= new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);


        print= new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);



        cancel= new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,700);
        add(jsp);
        try {
            conn  c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from teacherleave ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query = "select * from teacherleave where EmpId ='"+cEmpId.getSelectedItem() +"'";
            try{
                conn c= new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception b){
                b.printStackTrace();
            }
        } else if (ae.getSource()==print) {
            try{
                table.print();
            }catch (Exception a){
                a.printStackTrace();
            }
        } else  {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherleaveDetail();
    }
}

