package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;

public class Pcollage extends JFrame {

    Pcollage()
    {
        setSize(980,550);
        setSize(980,550);
        setResizable(false);

        setLocation(200,100);

        JLabel collage = new JLabel("Purnea Collage Purnea");
        collage.setBounds(250,10,500,40);
        collage.setFont(new Font("Serif",Font.BOLD,40));
        add(collage);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pcollage.png"));
        Image i2 = i1.getImage().getScaledInstance(950,470, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5,80,950,470);
        add(image);

        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Pcollage();
    }
}
