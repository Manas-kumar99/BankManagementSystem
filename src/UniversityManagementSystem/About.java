package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About(){


        setSize(900,580);
        setLocation(170,100);
        setResizable(false);


        JLabel University = new JLabel("Purnea University Purnea");
        University.setBounds(200,10,500,50);
        University.setFont(new Font("Serif",Font.BOLD,40));
        add(University);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/university.png"));
        Image i2 = i1.getImage().getScaledInstance(900,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,100,900,450);
        add(image);

        setLayout(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new About();
    }
}
