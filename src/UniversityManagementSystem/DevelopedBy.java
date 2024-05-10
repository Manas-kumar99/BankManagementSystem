package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;

public class DevelopedBy extends JFrame {

    DevelopedBy() {
        setSize(680, 500);
        setLocation(400, 150);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about-me.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);

        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70, 20, 300, 150);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        JLabel name = new JLabel("Developed By: Manas Kumar");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("serif", Font.BOLD, 30));
        add(name);

        JLabel rollno = new JLabel("Roll number: 1497");
        rollno.setBounds(70, 280, 550, 40);
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(rollno);

        JLabel contact = new JLabel("Contact: manasjha.mj92@gmail.com");
        contact.setBounds(70, 340, 550, 40);
        contact.setFont(new Font("seirf", Font.PLAIN, 20));
        add(contact);

        setLayout(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DevelopedBy();
    }
}