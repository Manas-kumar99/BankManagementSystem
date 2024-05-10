/*
    STEP TO BE TAKIN FOR CONNECTING DATABASE :-
    .1 Driver Class Register
    .2 Make Connection string
    .3 Make Our Statement
    .4 Execute MySql Query
    .5 Connection Close

 */
package UniversityManagementSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton login,cancel;
    JTextField tfusername,tfpassword ;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(40,20,120,30);
        add(lblusername);
        lblusername.setFont(new Font("Serif",Font.BOLD,18));

        tfusername=  new JTextField();
        tfusername.setBounds(180,20,150,30);
        add(tfusername);


        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setBounds(40,70,120,30);
        add(lblPassword);
        lblPassword.setFont(new Font("Serif",Font.BOLD,18));


        tfpassword =  new JPasswordField();
        tfpassword.setBounds(180,70,150,30);
        add(tfpassword);


        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Serif",Font.BOLD,18));
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(190,140,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Serif",Font.BOLD,18));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310,0,200,200);
        add(image);



        setSize(500,320);
        setLocation(400,200);
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==  login){
            String username = tfusername.getText();
            String password =tfpassword.getText();

            String query = "select * from login where username='"+username+"'and password='"+password+"'";
            try{
                conn c = new conn();
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or password");
                }
                c.s.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }


        } else if (e.getSource() == cancel) {
            setVisible(false);
        }

    }
}
