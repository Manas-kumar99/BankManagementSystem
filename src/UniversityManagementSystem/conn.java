package UniversityManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class conn {
  Connection c;
  Statement s;
    conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem","root","Manas@jha123");
            s= c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
