package UniversityManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class FeeStructure extends JFrame {

    FeeStructure()
    {
        setSize(1000,600);
        setLocation(200,70);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Structure ");
        heading.setBounds(100,30,500,33);
        heading.setFont(new Font("Serif",Font.BOLD,30));
        add(heading);

        JTable table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1000,500);
        add(jsp);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }






        setVisible(true);
    }
    public static void main(String[] args) {
        new FeeStructure();
    }

}
